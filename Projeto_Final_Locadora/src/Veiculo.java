public class Veiculo {
    private String placa, modelo, categoria;
    private double valorDiaria;
    private boolean disponivel;
    private int diasAlugados;
    
    Cliente clienteAtual;

    public Veiculo (String placa,String modelo,String categoria){
        this.placa = placa;
        this.modelo = modelo;
        this.categoria = categoria;

        this.disponivel = true;
        this.diasAlugados = 0;
        this.clienteAtual = null;

        if (categoria.equalsIgnoreCase("Hatch")){
            this.valorDiaria = 120;
        } else if (categoria.equalsIgnoreCase("Sedan")){
            this.valorDiaria = 180;
        } else if (categoria.equalsIgnoreCase("SUV")){
            this.valorDiaria = 280;
        } else {
            throw new IllegalArgumentException("Categoria inválida");
        }
    }

    public String getPlaca(){
        return this.placa;
    }

    public String getModelo(){
        return this.modelo;
    }

    public String getCategoria(){
        return this.categoria;
    }

    public double getValorDiaria(){
        return this.valorDiaria;
    }

    public boolean getDisponivel(){
        return this.disponivel;
    }

    public int getDiasAlugados(){
        return this.diasAlugados;
    }


    public void alugarCarro(Cliente motorista, int dias){
        if (this.disponivel) {
            clienteAtual = motorista;
            this.disponivel = false;
            this.diasAlugados = dias;
            System.out.println("Veiculo alugado com sucesso!");
        } 
    }

    public double devolverCarro(){
        double totalPagar = valorDiaria * diasAlugados;
        this.clienteAtual = null;
        this.diasAlugados = 0;

        this.disponivel = true;

        return totalPagar;
    }

    public Cliente getCliente(){
        return this.clienteAtual;
    }
}
