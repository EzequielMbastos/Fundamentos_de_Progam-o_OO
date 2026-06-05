public class PagamentoCartao extends Pagamento {

    public PagamentoCartao(double v) {
        super(v);
    }

    @Override
    public void processarPagamento() {
        System.out.println("Enviando dados para operadora de cartão : R$ " + this.valor);
    }
}
