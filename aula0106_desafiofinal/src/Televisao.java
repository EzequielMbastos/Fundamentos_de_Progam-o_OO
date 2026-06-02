public class Televisao implements DispositivoInteligente {

    @Override
    public void ligar() {
        System.out.println("Inicializando sistema Android");
    }

    @Override
    public void desligar() {
        System.out.println("Desligando sistema android");
    }
}
