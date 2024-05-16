import java.util.ArrayList;

public class Pessoa extends Usuario {
    private String cpf, bio;
    private Data dataNasc;
    private ArrayList<Usuario> interesses;

    // Construtor completo
    public Pessoa(String login, String nome, String senha, Local cidade, String cpf, String bio, int dia, int mes, int ano) {
        super(login, nome, senha, cidade);

        this.cpf = cpf;
        this.bio = bio;
        this.dataNasc = new Data(dia, mes, ano);
        this.interesses = new ArrayList<>();
    }

    // Construtor da parte 2 do trabalho
    public Pessoa(String login, String nome, String senha, String cpf, String bio, int dia, int mes, int ano) {
        super(login, nome, senha);

        this.cpf = cpf;
        this.bio = bio;
        this.dataNasc = new Data(dia, mes, ano);
        this.interesses = new ArrayList<>();
    }

    // Métodos
    public String toString() {
        return this.nome + "(" + this.login + " - " + this.cpf + ")";
    }


}
