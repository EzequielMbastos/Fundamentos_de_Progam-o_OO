public class App {
    public static void main(String[] args) throws Exception {
        Televisao t = new Televisao();

        LampadaRGB l = new LampadaRGB();

        t.ligar();
        t.desligar();

        l.ligar();
        l.desligar();
    }
}
