import java.math.BigDecimal;

abstract class FormaPagamento {
    public abstract void validarPagamento(String dados) throws Exception;
    public abstract void processarPagamento(BigDecimal valor);
}

class CartaoCredito extends FormaPagamento {
    private String numeroCartao;

    public void validarPagamento(String dados) throws Exception {
        if (dados == null || dados.length() != 16) {
            throw new Exception("Número de cartão inválido");
        }
        this.numeroCartao = dados;
    }

    public void processarPagamento(BigDecimal valor) {
        System.out.println("Pagamento de " + valor + " processado no cartão " + numeroCartao);
    }
}

class Boleto extends FormaPagamento {
    private String codigo;

    public void validarPagamento(String dados) throws Exception {
        if (dados == null || dados.length() != 10) {
            throw new Exception("Código de boleto inválido");
        }
        this.codigo = dados;
    }

    public void processarPagamento(BigDecimal valor) {
        System.out.println("Pagamento de " + valor + " processado via boleto " + codigo);
    }
}

class Pix extends FormaPagamento {
    private String chave;

    public void validarPagamento(String dados) throws Exception {
        if (dados == null || dados.trim().isEmpty()) {
            throw new Exception("Chave Pix inválida");
        }
        this.chave = dados;
    }

    public void processarPagamento(BigDecimal valor) {
        System.out.println("Pagamento de " + valor + " processado via Pix " + chave);
    }
}

public class Exercicio5Pagamento {
    public static void main(String[] args) {
        try {
            FormaPagamento cartao = new CartaoCredito();
            cartao.validarPagamento("1234567812345678");
            cartao.processarPagamento(new BigDecimal("150.00"));

            FormaPagamento boleto = new Boleto();
            boleto.validarPagamento("1234567890");
            boleto.processarPagamento(new BigDecimal("200.00"));

            FormaPagamento pix = new Pix();
            pix.validarPagamento("chave@pix.com");
            pix.processarPagamento(new BigDecimal("50.00"));
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
