public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Aqui é a Main!");

        Cliente cliente1 = new Cliente();

        cliente1.nome = "Mauricio";
        cliente1.idade = 23;
        cliente1.cpf = "12345678910";
        cliente1.saldoEmLoja = 100.0;

        Cliente c2 = new Cliente();

        c2.nome = "Alex";
        c2.idade = 20;
        c2.cpf = "12345678901";
        c2.saldoEmLoja = 200.0;

        System.out.println(cliente1.saldoEmLoja);

        System.out.println(c2.nome);

    }
}
