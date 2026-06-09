import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        double caixaDaEmpresa = 0.0;

        Veiculo[] frota = new Veiculo[10];

        Scanner teclado = new Scanner(System.in);

        String placa, modelo, categoria;

        frota[0] = new Veiculo("AAB4356", "palio", "Hatch");
        frota[1] = new Veiculo("AGT2763", "nivus", "Hatch");
        frota[2] = new Veiculo("ADF7854", "HRV", "SUV");
        frota[3] = new Veiculo("ABN1356", "Caravan", "Sedan");
        frota[4] = new Veiculo("BVG7896", "Argo", "Hatch");
        frota[5] = new Veiculo("QER7745", "BMW320", "Sedan");
        frota[6] = new Veiculo("BNH1277", "DS5", "Hatch");
        frota[7] = new Veiculo("BBG3878", "FastBack", "Hatch");
        frota[8] = new Veiculo("ASD9054", "Duster", "SUV");
        frota[9] = new Veiculo("ABN5643", "Passat", "Sedan");

        int opcao = -1;

        do {
            System.out.println("Catalago da empresa - 1 ");
            System.out.println("Alugar Veiculo - 2 ");
            System.out.println("Devolver Veiculo - 3 ");
            System.out.println("Rastrear Veiculo por CNH - 4 ");
            System.out.println("SAIR - 0");

            try {
                opcao = teclado.nextInt();
                teclado.nextLine();

            } catch (Exception e) {
                System.out.println("Digite um valor de 0 a 4");
                continue;
            }

            switch (opcao) {
                case 1:
                    catalagoEmpresa(frota);
                    break;

                case 2:
                    AlugarVeiculo(teclado, frota);
                    break;

                case 3:
                    caixaDaEmpresa += devolverVeiculo(frota, teclado);
                    break;

                case 4:
                    rastrearVeiculo(frota, teclado);
                    break;
                case 0:
                    System.out.println("Saindo do Sistema");
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }

        } while (opcao != 0);

        teclado.close();
    }

    public static void catalagoEmpresa(Veiculo[] frota) {
        for (int i = 0; i < frota.length; i++) {
            System.out.print(frota[i].getPlaca() + " - " + frota[i].getModelo());
            if (frota[i].getDisponivel()) {
                System.out.print("- LIVRE - ");
                System.out.println("Valor diaria : " + frota[i].getValorDiaria());
            } else {
                System.out.println("ALUGADO");
            }
        }
    }

    public static void AlugarVeiculo(Scanner teclado, Veiculo[] frota) {

        String placaCarro;
        String nome, cnh, celular;
        int dias;

        System.out.println("Digite a placa do carro desejado");
        placaCarro = teclado.nextLine();

        for (int i = 0; i < frota.length; i++) {
            if (frota[i].getPlaca().equals(placaCarro) && (frota[i].getDisponivel())) {
                System.out.println("Digite seu nome");
                nome = teclado.nextLine();
                System.out.println("Digite o numero da sua cnh");
                cnh = teclado.nextLine();
                System.out.println("Digite seu celular");
                celular = teclado.nextLine();
                System.out.println("Quantos dias");
                dias = teclado.nextInt();
                teclado.nextLine();

                frota[i].alugarCarro(new Cliente(nome, cnh, celular), dias);
            }

        }
    }

    public static double devolverVeiculo(Veiculo[] frota, Scanner teclado) {
        String placa;
        double valor;
        System.out.println("Digite a placa do Veiculo");
        placa = teclado.nextLine();

        for (Veiculo v : frota) {
            if (v.getPlaca().equals(placa) && !v.getDisponivel()) {
                valor = v.devolverCarro();
                System.out.println("Motorista " + v.getCliente().getNome() + "Total a pagar : " + valor);
                return valor;
            }
        }
        System.out.println("Veiculo nao encontrado ou nao esta alugado");
        return 0.0;
    }

    public static void rastrearVeiculo(Veiculo[] frota, Scanner teclado){
        String cnh;
        System.out.println("cnh");
        cnh = teclado.nextLine();

        for (Veiculo v : frota) {

            if(!v.getDisponivel() && v.getCliente().getCnh().equals(cnh)) {

                System.out.println(v.getPlaca());
                break;
            }

        }
        System.out.println("CNH nao encontrada na base de dados");
    }

}
