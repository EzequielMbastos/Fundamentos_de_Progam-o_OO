public class ProdutoFisico extends Produto {

    public ProdutoFisico(String n, double preco){
        super(n, preco);
    }

    @Override
    public double calcularPrecoFinal() {
        double precofinal;
        precofinal = this.precoBase + (this.precoBase * 0.1) + 50.0;
        return precofinal;
    }
}
