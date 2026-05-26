import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        int opcao;
        Scanner teclado = new Scanner(System.in);
        // imprimentar função dinamica para alocar mais funcionarios
        // criar array de Objeto funcionario

        // Lista para armazenar múltiplos funcionários
        Funcionarios[] listaFuncionarios = new Funcionarios[100];
        int contador = 0;

        do {
            System.out.println("Digite 1 para criar novo funcionario");
            System.out.println("Digite 2 para dar aumento para funcionario");
            System.out.println("Digite 3 para sair");

            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1:
                    Funcionarios funcionario = new Funcionarios();
                    System.out.println("Digite o nome do funcionario");
                    funcionario.nome = teclado.nextLine();
                    System.out.println("Digite o salario do funcionario");
                    funcionario.salario = teclado.nextDouble();

                    listaFuncionarios[contador] = funcionario;
                    contador++;
                    teclado.nextLine();
                    break;

                case 2:
                    System.out.println("Digite o nome do funcionario que recebera aumento");
                    String nome = teclado.nextLine();
                    double valor;

                    for (int i = 0; i < contador; i++) {
                        if (nome.equals(listaFuncionarios[i].nome)) {
                            System.out.println("Qual o valor do aumento");
                            valor = teclado.nextDouble();
                            listaFuncionarios[i].receberAumento(valor);
                        }
                    }
                    break;
            }
        } while (opcao != 3);
    }
}
