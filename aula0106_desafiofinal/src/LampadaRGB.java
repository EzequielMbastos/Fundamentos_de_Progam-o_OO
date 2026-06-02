public class LampadaRGB implements DispositivoInteligente {

    @Override
    public void ligar() {
        System.out.println("Acendendo luz Branca");
    }

    @Override
    public void desligar() {
        System.out.println("Desligando lampada");
    }
}
