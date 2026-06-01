public class Produto {
    String nome;
    double preco;
    int quantidadeEstoque;

    public void adicionarEstoque(int quantidade) {
        this.quantidadeEstoque = this.quantidadeEstoque + quantidade;

        System.out.println("Estoque Atualizado!");
    }

    public void editarPreco(double precoNovo) {
        this.preco = precoNovo;

        System.out.println("Preco alterado!");
    }
}
