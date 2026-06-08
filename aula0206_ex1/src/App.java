public class App {
    public static void main(String[] args) throws Exception {

        Livro[] estante = new Livro[3];

        estante[0] = new Livro("Harry Potter", "J. K. Rouling");
        estante[1] = new Livro("O codigo da vinci", "Dan Brown");
        estante[2] = new Livro("Arte da Guerra", "Sun Tzu");

        for (Livro l : estante) {
            System.out.println(l.getTitulo());
        }

    }
}
