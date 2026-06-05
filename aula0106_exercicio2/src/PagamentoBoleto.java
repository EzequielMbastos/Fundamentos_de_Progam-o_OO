public class PagamentoBoleto extends Pagamento {

    public PagamentoBoleto(double v) {
        super(v);
    }

    @Override
    public void processarPagamento() {
        System.out.println("Gerando codigo de barra para o valor : R$ " + this.valor);
    }
}
