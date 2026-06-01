public class Funcionarios {

    String nome;
    double salario;

    public void receberAumento(double valorAdicional) {
        this.salario = this.salario + valorAdicional;
        System.out.println("O novo salario do funcionario : " + this.nome + " é " + this.salario);
    }

}