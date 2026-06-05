public class Quarto {
    private int numero, diasOcupados;
    private String tipo;
    private double valorDiaria;
    private boolean ocupado;
    private Hospede hospedeAtual;

    public Quarto(int n, String tipo) {
        this.numero = n;
        this.tipo = tipo;
        ocupado = false;
        diasOcupados = 0;
        hospedeAtual = null;
        if (tipo.equalsIgnoreCase("Simples")) {
            this.valorDiaria = 100;
        } else if (tipo.equalsIgnoreCase("Luxo")) {
            this.valorDiaria = 250;

        } else {
            throw new IllegalArgumentException("Tipo inválido. Use Simples ou Luxo.");
        }
    }

    public boolean checkIn(Hospede novoHospede, int dias) {
        if (!ocupado) {
            ocupado = true;
            this.hospedeAtual = novoHospede;
            this.diasOcupados = dias;
            return true;
        } else {
            System.out.println("O Quarto esta Ocupado");
            return false;
        }

    }

    public double checkOut() {
        double total = this.diasOcupados * this.valorDiaria;
        ocupado = false;
        hospedeAtual = null;
        return total;

    }

    public int getNumQuarto() {
        return this.numero;
    }

    public String getTipoQuarto() {
        return this.tipo;
    }

    public double getValorDiaria() {
        return this.valorDiaria;
    }

    public int getDiasOcupados() {
        return diasOcupados;
    }

    public boolean getQuartoOcupado() {
        return this.ocupado;
    }

    public Hospede getHospede() {
        return this.hospedeAtual;
    }

}