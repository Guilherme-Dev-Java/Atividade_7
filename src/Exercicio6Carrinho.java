import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

enum Moeda { BRL, USD, EUR }

final class Dinheiro {
    private final BigDecimal valor;
    private final Moeda moeda;

    public Dinheiro(BigDecimal valor, Moeda moeda) {
        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor não pode ser negativo");
        }
        this.valor = valor;
        this.moeda = moeda;
    }

    public BigDecimal getValor() { return valor; }
    public Moeda getMoeda() { return moeda; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dinheiro)) return false;
        Dinheiro d = (Dinheiro) o;
        return valor.equals(d.valor) && moeda == d.moeda;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, moeda);
    }
}

class ItemCarrinho {
    private final Exercicio1Produto produto;
    private final int quantidade;

    public ItemCarrinho(Exercicio1Produto produto, int quantidade) {
        if (quantidade <= 0) throw new IllegalArgumentException("Quantidade deve ser > 0");
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Exercicio1Produto getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }
}

class Carrinho {
    private final List<ItemCarrinho> itens;

    public Carrinho(List<ItemCarrinho> itens) {
        this.itens = Collections.unmodifiableList(new ArrayList<>(itens));
    }

    public Carrinho adicionar(ItemCarrinho item) {
        List<ItemCarrinho> novaLista = new ArrayList<>(itens);
        novaLista.add(item);
        return new Carrinho(novaLista);
    }

    public Carrinho remover(ItemCarrinho item) {
        List<ItemCarrinho> novaLista = new ArrayList<>(itens);
        novaLista.remove(item);
        return new Carrinho(novaLista);
    }

    public Carrinho aplicarCupom(double porcentagem) {
        if (porcentagem < 0 || porcentagem > 30) {
            throw new IllegalArgumentException("Cupom inválido (0% a 30%)");
        }
        List<ItemCarrinho> novaLista = new ArrayList<>();
        for (ItemCarrinho item : itens) {
            double precoAtual = item.getProduto().getPreco();
            double novoPreco = precoAtual - (precoAtual * (porcentagem / 100));
           
            Exercicio1Produto produtoComDesconto = new Exercicio1Produto(
                item.getProduto().getNome(),
                new BigDecimal(novoPreco).setScale(2, RoundingMode.HALF_EVEN).doubleValue(),
                item.getProduto().getQuantidadeEmEstoque()
            );
            novaLista.add(new ItemCarrinho(produtoComDesconto, item.getQuantidade()));
        }
        return new Carrinho(novaLista);
    }

    public List<ItemCarrinho> getItens() { return itens; }
}

public class Exercicio6Carrinho {
    public static void main(String[] args) {
        Exercicio1Produto p1 = new Exercicio1Produto("Livro", 50, 5);
        ItemCarrinho item1 = new ItemCarrinho(p1, 2);

        Carrinho carrinho = new Carrinho(new ArrayList<>());
        carrinho = carrinho.adicionar(item1);

        System.out.println("Itens no carrinho: " + carrinho.getItens().size());

        
        Carrinho carrinhoComDesconto = carrinho.aplicarCupom(10);

        System.out.println("Preço original do produto: " + p1.getPreco());
        System.out.println("Preço com desconto no novo carrinho: " + carrinhoComDesconto.getItens().get(0).getProduto().getPreco());
    }
}