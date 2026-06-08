public class App {
    public static void main(String[] args) throws Exception {
        Aluno[] alunos = new Aluno[4];

        alunos[0] = new Aluno("joao", 7.0, 3.2);
        alunos[1] = new Aluno("carlos", 6.0, 4.5);
        alunos[2] = new Aluno("marlon", 7.2, 8.5);
        alunos[3] = new Aluno("thais", 5.0, 6.5);

        double somaNotas = 0;

        for (Aluno l : alunos) {
            somaNotas += l.getMedia();
        }
        System.out.printf("A media é : %.1f ", somaNotas / 4);
    }

}
