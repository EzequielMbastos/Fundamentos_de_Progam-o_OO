public abstract class Quarto implements Financeiro {
    protected int numero;
    protected double precoBase;
    protected boolean isOcupado;

    public Quarto(int num, double preco) {
        this.numero = num;
        this.precoBase = preco;
        this.isOcupado = false;
    }

    public int getNumero() {
        return this.numero;
    }

    public double getPrecoBase() {
        return this.precoBase;
    }

    public boolean getIsOcupado() {
        return this.isOcupado;
    }

    public void setIsOcupado(boolean isOcupado) {
        this.isOcupado = isOcupado;
    }

    @Override
    public double calcularTotal(int diarias) {
        return precoBase * diarias;
    }

}
