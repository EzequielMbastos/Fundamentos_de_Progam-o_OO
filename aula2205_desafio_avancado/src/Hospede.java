public class Hospede {

    private String nome, cpf, telefone;

    public Hospede(String n, String cpf, String tel) {
        this.nome = n;
        this.cpf = cpf;
        this.telefone = tel;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getTelefone() {
        return this.telefone;
    }

}
