public class App {
    public static void main(String[] args) throws Exception {

        Cachorro dog1 = new Cachorro("Rex", 10);

        dog1.dormir();

        dog1.latir();

        Gato cat1 = new Gato("garfield", 7);

        cat1.dormir();

        cat1.miar();
    }
}
