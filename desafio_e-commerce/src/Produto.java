public class Produto {
    protected String nome;
    protected double precoBase;

    public Produto(String n, double preco) {
        this.nome = n;
        this.precoBase = preco;
    }

    public double calcularPrecoFinal() {
        double precofinal;
        precofinal = this.precoBase + (this.precoBase * 0.1);
        return precofinal;
    }
}
