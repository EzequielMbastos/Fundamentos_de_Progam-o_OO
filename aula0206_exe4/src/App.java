import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Musica> musicas = new ArrayList<>();

        musicas.add(new Musica("Pink Floyd", "Another brick"));
        musicas.add(new Musica("Sad but true", "Metallica"));
        musicas.add(new Musica("Territory", "Sepultura"));

        for (Musica m : musicas) {
            System.out.println("Tocando : " + m.getMusica() + " - " + m.getArtista());
        }

    }
}
