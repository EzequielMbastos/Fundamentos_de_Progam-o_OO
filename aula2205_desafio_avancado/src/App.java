import java.util.Scanner; //importa classes nativas do java, util contem classes utilitarias
import java.util.InputMismatchException;
import java.util.ArrayList;

public class App { // Classe publica por qualquer classe dentro do mesmo projeto (ou qualquer
                   // projeto que tenha a classe no classpath)
    public static void main(String[] args) {
        int opcao = -1;

        Scanner teclado = new Scanner(System.in);

        ArrayList<Quarto> quartos = new ArrayList<>();

        ArrayList<Hospede> hospedes = new ArrayList<>();

        do {
            System.out.println("1 - Cadastrar quarto");
            System.out.println("2 - Cadastrar hóspede");
            System.out.println("3 - Check-in");
            System.out.println("4 - Check-out");
            System.out.println("0 - Sair");

            try {
                opcao = teclado.nextInt();
                teclado.nextLine();
                if (opcao < 0 || opcao > 4) {
                    System.out.println("Digite uma opcao valida");
                    continue;
                }
            } catch (InputMismatchException error) {
                System.out.println("Digite um numero valido");
                teclado.next();
                continue;
            }
            System.out.println("Opcao escolhida : " + opcao);
            switch (opcao) {
                case 1:
                    cadastrarQuarto(teclado, quartos);
                    break;

                case 2:
                    cadastrarHospede(teclado, hospedes);
                    break;

                case 3:

                    fazerCheckin(teclado, quartos, hospedes);
                    break;

                case 4:
                    fazerCheckout(teclado, quartos, hospedes);
            }
        } while (opcao != 0);
        teclado.close();
    }

    private static void cadastrarQuarto(Scanner teclado, ArrayList<Quarto> quartos) {
        int numero = 0;
        boolean numeroValido = false;
        String tipo;
        while (!numeroValido) {
            System.out.println("Digite o número do quarto : ");
            try {
                numero = teclado.nextInt();
                teclado.nextLine();
                if (numero < 0) {
                    System.out.println("Numero deve ser positivo!");
                    continue;
                }
            } catch (InputMismatchException erro) {
                System.out.println("Digite apenas numeros ");
                teclado.next();
                continue;
            }
            // Verificar se o quarto ja foi criado
            numeroValido = true;
            for (Quarto q : quartos) {
                if (q.getNumQuarto() == numero) {
                    numeroValido = false;
                    System.out.println("Numero do Quarto ja cadastrado");
                    break;
                }
            }

            if (!numeroValido) {
                continue;
            }

            do {
                System.out.println("Digite o tipo do quarto: Luxo ou Simples");
                tipo = teclado.nextLine();
                if (tipo.equalsIgnoreCase("Simples")) {
                    tipo = "Simples";
                    System.out.println("Quarto escolhido :" + tipo);
                } else if (tipo.equalsIgnoreCase("Luxo")) {
                    tipo = "Luxo";
                    System.out.println("Quarto escolhido :" + tipo);
                }
            } while (!tipo.equals("Simples") && !tipo.equals("Luxo"));

            quartos.add(new Quarto(numero, tipo));
            System.out.println("Quarto " + numero + " cadastrado com sucesso! Total: " + quartos.size());
        }
    }

    private static void cadastrarHospede(Scanner teclado, ArrayList<Hospede> hospedes) {
        String nome, cpf, telefone;
        do {
            System.out.println("Digite o nome do hospede (max 60 caracteres) : ");
            nome = teclado.nextLine().trim();

            if (nome.length() > 60 || nome.isEmpty()) {
                System.out.println("Maximo 60 caracteres");
                continue;
            } else if (!nome.matches("[\\p{L}\\s]+")) {
                System.out.println("nome invalido");
                continue;
            }
            break;
        } while (true);

        do {
            System.out.println("Digite o CPF");

            cpf = teclado.nextLine().trim();

            if (!validarCPF(cpf)) {
                System.out.println("Cpf Invalido");
                continue;
            }
            System.out.println("CPF : " + cpf);
            break;
        } while (true);


        do {
            System.out.print("Digite o telefone (8 a 11 dígitos): ");
            telefone = teclado.nextLine().trim();

            telefone = telefone.replaceAll("\\D", "");

            if (telefone.length() >= 8 && telefone.length() <= 11) {
                break;
            }
            System.out.println("Telefone inválido. Digite 8 a 11 números.");
        } while (true);

        hospedes.add(new Hospede(nome, cpf, telefone));

        System.out.println("Hóspede cadastrado com nap osicao !" + (hospedes.size() - 1)) ;

        System.out.println("Hóspede cadastrado com sucesso! Total: " + hospedes.size()) ;
    }

    public static boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("\\D", "");
        if (cpf.length() != 11)
            return false;

        if (cpf.matches("(\\d)\\1{10}"))
            return false;

        try {
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += (cpf.charAt(i) - '0') * (10 - i);
            }
            int primeiroDigito = 11 - (soma % 11);
            if (primeiroDigito >= 10)
                primeiroDigito = 0;

            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += (cpf.charAt(i) - '0') * (11 - i);
            }
            int segundoDigito = 11 - (soma % 11);
            if (segundoDigito >= 10)
                segundoDigito = 0;

            return (cpf.charAt(9) - '0' == primeiroDigito) &&
                    (cpf.charAt(10) - '0' == segundoDigito);
        } catch (Exception e) {
            return false;
        }
    }

    private static void fazerCheckin(Scanner teclado,
            ArrayList<Quarto> quartos,
            ArrayList<Hospede> hospedes) {
        System.out.println("Quartos disponíveis:");
        for (Quarto q : quartos) {
            if (!q.getQuartoOcupado()) {
                System.out.println("Quarto " + q.getNumQuarto() + " - " + q.getTipoQuarto());
            }
        }

        int numQuarto;
        do {
            try {
                System.out.print("Digite o número do quarto: ");
                numQuarto = teclado.nextInt();
            } catch (InputMismatchException error) {
                System.out.println("Digite um numero valido");
                teclado.next();
                continue;
            }
            break;
        } while (true);
        Quarto quartoEscolhido = null;
        for (Quarto q : quartos) {
            if (q.getNumQuarto() == numQuarto && !q.getQuartoOcupado()) {
                quartoEscolhido = q;
                break;
            }
        }

        if (quartoEscolhido == null) {
            System.out.println("Quarto não encontrado ou ocupado.");
            return;
        }
        teclado.nextLine();
        System.out.print("Digite o CPF do hóspede: ");
        String cpf = teclado.nextLine().trim();

        Hospede hospede = null;
        for (Hospede h : hospedes) {
            if (h.getCpf().equals(cpf)) {
                hospede = h;
                break;
            }
        }

        if (hospede == null) {
            System.out.println("Hóspede não cadastrado. Cadastre agora:");
            cadastrarHospede(teclado, hospedes);
            hospede = hospedes.get(hospedes.size() - 1);
        }

        // 4. Dias
        System.out.print("Quantos dias? ");
        int dias = teclado.nextInt();
        teclado.nextLine();

        // 5. Check-in
        if (quartoEscolhido.checkIn(hospede, dias)) {
            System.out.println("Check-in realizado!");
        }
    }

    private static void fazerCheckout(Scanner teclado,
            ArrayList<Quarto> quartos,
            ArrayList<Hospede> hospedes) {
        String cpfcheckout;
        Quarto quartoAtual = null;
        System.out.print("Digite o CPF do hóspede: ");
        cpfcheckout = teclado.nextLine().trim();

        Hospede hospede = null;
        for (Hospede h : hospedes) {
            if (h.getCpf().equals(cpfcheckout)) {
                hospede = h;
                break;
            } else {
                System.out.println("Hospede nao encontrado");
                break;
            }
        }

        for (Quarto q : quartos) {
            if (q.getHospede().getCpf() == hospede.getCpf()) {
                quartoAtual = q;
            } else {
                System.out.println("Hospede nao registrado em nenhum quarto");
            }
        }

        System.out.println("O valor total da sua estadia : " + quartoAtual.checkOut());

    }

}
