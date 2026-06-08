import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<String> produtos = new ArrayList<>();

        produtos.add("Notebook");
        produtos.add("TV");
        produtos.add("Controle Remote");

        produtos.remove(1);

        for (String p : produtos) {
            System.out.println(p);
        }
    }
}