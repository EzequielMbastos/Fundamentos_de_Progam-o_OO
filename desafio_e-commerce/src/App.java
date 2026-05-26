public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        ProdutoFisico p1 = new ProdutoFisico("mouse", 100);

        System.out.println("O preço final do " + p1.calcularPrecoFinal());

        ProdutoDigital p2 = new ProdutoDigital("Ebook", 100);

        System.out.println("O preco final e " + p2.calcularPrecoFinal());

    }
}