public class Tarefa {
    private String descricao;
    private boolean concluida;

    public Tarefa(String d) {
        this.concluida = false;
        this.descricao = d;
    }

    public void finalizarTarefa() {
        this.concluida = true;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public boolean getConcluida() {
        return this.concluida;
    }

}
