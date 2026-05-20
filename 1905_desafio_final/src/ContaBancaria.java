public class ContaBancaria {
    private String titular;
    private double saldo;

    public ContaBancaria(String nome) {
        this.titular = nome;
        this.saldo = 0.0;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void depositar(double v) {
        this.saldo = this.saldo + v;
        System.out.println("Seu novo saldo é : " + this.saldo);
    }

    public void sacar(double v) {
        if (this.saldo > v) {
            this.saldo = this.saldo - v;
        }
        System.out.println("Seu novo saldo é : " + this.saldo);
    }

}
