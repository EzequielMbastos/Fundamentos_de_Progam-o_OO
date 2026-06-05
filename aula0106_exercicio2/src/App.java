public class App {
    public static void main(String[] args) throws Exception {

        PagamentoBoleto pb = new PagamentoBoleto(2000);

        PagamentoCartao pc = new PagamentoCartao(3000);

        pb.processarPagamento();
        pc.processarPagamento();

    }
}
