public class App {
    public static void main(String[] args) throws Exception {

        Carro carro1 = new Carro("Pajero", "mitsubishi", "preto", 2001);
        Carro carro2 = new Carro("Palio", "Fiat", "cinza", 2010);

        carro1.setAno(2010);

        System.out.println("O carro " + carro1.getMarca() + " " + carro1.getModelo() + " " + carro1.getCor() + " " +
                carro1.getAno() + " adicionado");

        System.out.println("O carro " + carro2.getMarca() + " " + carro2.getModelo() + " " + carro2.getCor() + " " +
                carro2.getAno() + " adicionado");

    }
}
