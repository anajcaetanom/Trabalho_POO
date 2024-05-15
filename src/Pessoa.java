import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class Pessoa extends Usuario {
    private String cpf, bio;
    private Data dataNasc;
    private ArrayList<Usuario> interesses;

    // Construtor
    Pessoa(String login, String nome, String senha, String cpf, String bio, int dia, int mes, int ano) {
        this.login = login;
        this.nome = nome;
        this.senha = senha;
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
