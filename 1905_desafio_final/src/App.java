public class App {
    public static void main(String[] args) throws Exception {

        ContaBancaria pessoa1 = new ContaBancaria("Ezequiel");
        System.out.println("Seu saldo é : " + pessoa1.getSaldo());
        pessoa1.depositar(50);
        pessoa1.sacar(50);
    }
}
