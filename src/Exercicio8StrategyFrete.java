import java.math.BigDecimal;

interface CalculadoraFrete {
    BigDecimal calcular(Pedido pedido);
}

class Pedido {
    private String cep;
    private BigDecimal valor;
    private CalculadoraFrete estrategia;

    public Pedido(String cep, BigDecimal valor, CalculadoraFrete estrategia) {
        this.cep = cep;
        this.valor = valor;
        this.estrategia = estrategia;
    }

    public String getCep() { return cep; }
    public BigDecimal getValor() { return valor; }

    public void setEstrategia(CalculadoraFrete estrategia) {
        this.estrategia = estrategia;
    }

    public BigDecimal calcularFrete() {
        return estrategia.calcular(this);
    }
}

class Sedex implements CalculadoraFrete {
    public BigDecimal calcular(Pedido pedido) {
        return new BigDecimal("30.00");
    }
}

class Pac implements CalculadoraFrete {
    public BigDecimal calcular(Pedido pedido) {
        return new BigDecimal("15.00");
    }
}

class RetiradaNaLoja implements CalculadoraFrete {
    public BigDecimal calcular(Pedido pedido) {
        return BigDecimal.ZERO;
    }
}

public class Exercicio8StrategyFrete {
    public static void main(String[] args) {
        Pedido pedido = new Pedido("12345678", new BigDecimal("200.00"), new Sedex());
        System.out.println("Frete Sedex: " + pedido.calcularFrete());

        pedido.setEstrategia(new Pac());
        System.out.println("Frete PAC: " + pedido.calcularFrete());

        pedido.setEstrategia(new RetiradaNaLoja());
        System.out.println("Retirada na loja: " + pedido.calcularFrete());

        
        pedido.setEstrategia(p -> p.getValor().compareTo(new BigDecimal("100")) > 0 ? BigDecimal.ZERO : new BigDecimal("20"));
        System.out.println("Frete promocional: " + pedido.calcularFrete());
    }
}
