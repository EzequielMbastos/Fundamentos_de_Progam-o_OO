public class App {
    public static void main(String[] args) throws Exception {

        Produto notebook = new Produto();

        notebook.nome = "Acer Predator";
        notebook.preco = 100.0;
        notebook.quantidadeEstoque = 50;

        double precoTotalNotebook = notebook.preco * notebook.quantidadeEstoque;
        System.out.println("valor em estoque de Notebook : " + precoTotalNotebook);

        Produto mouse = new Produto();

        mouse.nome = "mouse gamer Helius";
        mouse.preco = 25.0;
        mouse.quantidadeEstoque = 30;

        double precoTotalMouse = mouse.preco * mouse.quantidadeEstoque;
        System.out.println("valor em estoque de Mouse : " + precoTotalMouse);

        notebook.adicionarEstoque(15);
        System.out.println("QTD estoque notebook " + notebook.quantidadeEstoque);

        mouse.adicionarEstoque(20);
        System.out.println("QTD estoque mouse " + mouse.quantidadeEstoque);

        mouse.editarPreco(100.0);

        System.out.println(mouse.preco);
    }
}
