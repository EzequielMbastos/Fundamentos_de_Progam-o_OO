import org.xml.sax.ContentHandler;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Conta conta1 = new Conta();
        conta1.titular = "Ezequiel";

        conta1.depositar(100);
        System.out.println("saldo da conta de " + conta1.titular + " = " + conta1.saldo);

        conta1.sacar(150);

        conta1.sacar(50);

        System.out.println("saldo da conta de " + conta1.titular + " = " + conta1.saldo);
    }
}
