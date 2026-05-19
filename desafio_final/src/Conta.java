public class Conta {

    String titular;
    double saldo = 0;

    public void depositar(double valor) {
        this.saldo = this.saldo + valor;
        System.out.println("Saldo Atualizado!");
    }

    public void sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo = this.saldo - valor;
            System.out.println("Saque Realizado");
        } else {
            System.out.println("Você não possui saldo");
        }
    }
}
