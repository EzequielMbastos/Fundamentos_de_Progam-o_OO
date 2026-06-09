public class Cliente {
    //atributos private 
    String nome, cnh, celular;

    // contrutor deve retornar algo ou fazer alguma validacao? 

    public Cliente(String nome, String cnh, String celular){
        this.nome = nome;
        this.cnh = cnh;
        this.celular = celular;        
    }

    public String getNome(){
        return this.nome;
    }

    public String getCnh(){
        return this.cnh;
    }

    public String getCelular(){
        return this.celular;
    }

}
