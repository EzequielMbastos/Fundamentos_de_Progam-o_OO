public class ProdutoDigital extends Produto {

    public ProdutoDigital(String n, double preco) {
        super(n, preco);
    }

    @Override
    public double calcularPrecoFinal() {
        double precofinal;
        precofinal = this.precoBase;
        return precofinal;
    }

}
