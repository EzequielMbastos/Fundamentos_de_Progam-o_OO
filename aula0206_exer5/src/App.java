import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Tarefa> tarefas = new ArrayList<>();

        tarefas.add(new Tarefa("Lavar louca"));
        tarefas.add(new Tarefa("estudar"));
        tarefas.add(new Tarefa("trabalhar"));
        tarefas.add(new Tarefa("almocar"));

        tarefas.get(1).finalizarTarefa();

        System.out.println("Tarefa finalizada " + tarefas.get(1).getDescricao());

        for (Tarefa t : tarefas) {
            if (!t.getConcluida()) {
                System.out.println(t.getDescricao());

            }
        }
    }
}
