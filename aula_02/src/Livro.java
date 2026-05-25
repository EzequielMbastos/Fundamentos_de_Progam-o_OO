public class Livro {
    String titulo, autor;
    boolean disponivel;

    public void emprestar() {
        if (this.disponivel == true) {
            this.disponivel = false;
            System.out.println("Emprestimo realizado!");
        } else {
            System.out.println("Livro indisponivel!");
        }
    }

    public void devolver() {
        this.disponivel = true;
        System.out.println("Livro devolvido!");
    }
}
