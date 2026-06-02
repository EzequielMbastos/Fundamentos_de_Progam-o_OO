public class App {
    public static void main(String[] args) throws Exception {

        Vendedor v1 = new Vendedor("Ezequiel", 3000);
        Vendedor v2 = new Vendedor("Joao", 2000);
        Gerente g1 = new Gerente("Carlos", 5000);

        System.out.printf("salario v1 : %.2f \n", v1.calcularSalario());
        System.out.printf("salario v2 : %.2f \n", v2.calcularSalario());
        System.out.printf("salario g1 : %.2f \n", g1.calcularSalario());
    }
}
