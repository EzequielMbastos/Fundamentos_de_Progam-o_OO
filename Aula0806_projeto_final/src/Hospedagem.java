public class Hospedagem {

    private Quarto quarto;
    private Cliente hospede;
    private int diarias;
    private boolean isAtiva;
    private double valorTotal;

    public Hospedagem(Quarto quarto, Cliente hospede, int diarias) {
        this.quarto = quarto;
        this.hospede = hospede;
        this.diarias = diarias;

        this.isAtiva = true;
        this.valorTotal = 0.0;
    }

    public int getDiarias() {
        return this.diarias;
    }

    public Quarto getQuarto() {
        return this.quarto;
    }

    public Cliente getHospede() {
        return this.hospede;
    }

    public boolean getIsativa() {
        return isAtiva;
    }

    public double getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(double v) {
        this.valorTotal = v;
    }

    public void setIsativa(boolean status) {
        this.isAtiva = status;
    }

}
