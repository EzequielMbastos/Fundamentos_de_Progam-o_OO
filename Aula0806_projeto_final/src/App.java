import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Quarto[] quartos = new Quarto[5];

        quartos[0] = new QuartoSimples(101, 100);
        quartos[1] = new QuartoSimples(102, 100);
        quartos[2] = new QuartoSimples(103, 100);
        quartos[3] = new QuartoLuxo(201, 200);
        quartos[4] = new QuartoLuxo(202, 200);

        ArrayList<Cliente> listaClientes = new ArrayList<>();

        ArrayList<Hospedagem> hospedagens = new ArrayList<>();

        double totalCaixa = 0.0;

        int opcao = -1;

        do {

            System.out.println("======= Mapa dos Quartos =======");
            for (Quarto q : quartos) {
                if (q.getIsOcupado()) {
                    System.out.println("quarto -" + q.getNumero() + " [Ocupado]");
                } else {
                    System.out.println("quarto -" + q.getNumero() + " [Livre]");
                }
            }

            System.out.println("================================");

            System.out.println("Cadastrar Cliente - 1");
            System.out.println("Check-in - 2");
            System.out.println("Check out - 3");
            System.out.println("Balanço do caixa - 4");
            System.out.println("Sair - 5");
            System.out.println("Digite uma opção");

            try {
                opcao = teclado.nextInt();
                teclado.nextLine();
                if (opcao < 0 || opcao > 5) {
                    System.out.println("Opcao invalida!");
                    continue;
                }
            } catch (InputMismatchException error) {
                System.out.println("Opcao invalida!");
                opcao = -1;
                continue;
            }

            switch (opcao) {
                case 1:
                    listaClientes.add(cadastrarCliente(teclado, listaClientes));
                    break;

                case 2:
                    checkIn(quartos, listaClientes, teclado, hospedagens);
                    break;

                case 3:
                    checkOut(hospedagens, teclado);
                    break;

                case 4:
                    totalCaixa += balancoCaixa(hospedagens);
                    System.out.println("Balaço total " + totalCaixa);
                    break;
                case 5:
                    System.out.println("Fechando Programa");
                    break;
                default:
                    System.out.println("Operação Invalida");
            }

        } while (opcao != 5);
    }

    public static Cliente cadastrarCliente(Scanner teclado, ArrayList<Cliente> listaClientes) {
        String nome, cpf;
        System.out.println("Digite o nome do cliente");
        nome = teclado.nextLine();
        System.out.println("Digite o cpf");
        cpf = teclado.nextLine();

        return (new Cliente(nome, cpf));
    }

    public static void checkIn(Quarto[] quartos, ArrayList<Cliente> listaClientes, Scanner teclado,
            ArrayList<Hospedagem> hospedagens) {
        int numQuarto;
        for (int i = 0; i < listaClientes.size(); i++) {

            System.out.println(i + " - " + listaClientes.get(i).getNome());
        }
        System.out.println("Digite o indice do cliente");

        int cid = teclado.nextInt();

        System.out.println("Digite o numero do quarto escolhido");
        numQuarto = teclado.nextInt();

        System.out.println("Digite o numero de diarias");
        int nDiarias = teclado.nextInt();
        teclado.nextLine();

        for (Quarto q : quartos) {
            if (!q.getIsOcupado() && q.getNumero() == numQuarto) {
                q.setIsOcupado(true);
                hospedagens.add(new Hospedagem(q, listaClientes.get(cid), nDiarias));
                System.out.println("Hospedagem criado com sucesso!");
                break;
            }
            break;
        }

    }

    public static void checkOut(ArrayList<Hospedagem> hospedagens, Scanner teclado) {

        System.out.println("Digite o numero do quarto para ckeckout");
        int numCheckout = teclado.nextInt();

        for (Hospedagem h : hospedagens) {
            if (h.getQuarto().getNumero() == numCheckout && h.getIsativa()) {
                double total = h.getQuarto().calcularTotal(h.getDiarias());
                System.out.println("Total a pagar R$" + total);
                h.getQuarto().setIsOcupado(false);
                h.setIsativa(false);
                h.setValorTotal(total);
                System.out.println("Checkout realizado");
            }
        }

    }

    public static double balancoCaixa(ArrayList<Hospedagem> hospedagens) {
        double totalCaixa = 0.0;
        for (Hospedagem h : hospedagens) {
            if (!h.getIsativa()) {
                totalCaixa += h.getValorTotal();
            }
        }

        return totalCaixa;
    }
}
