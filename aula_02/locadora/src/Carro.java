public class Carro {

    private String modelo, marca, cor;
    private int ano;

    public Carro(String m, String ma, String cor, int an) {
        this.modelo = m;
        this.marca = ma;
        this.cor = cor;
        this.ano = an;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modeloNovo) {
        this.modelo = modeloNovo;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marcaNova) {
        this.marca = marcaNova;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String corNova) {
        this.cor = corNova;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int anoNovo) {
        this.ano = anoNovo;
    }
}
