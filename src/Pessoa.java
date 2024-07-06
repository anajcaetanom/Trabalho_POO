import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Pessoa extends Usuario {
    private String cpf;
    private Data dataNasc;
    private ArrayList<Usuario> interesses;

    // Construtor completo
    public Pessoa(String login, String nome, String senha, Local cidade, String cpf, int dia, int mes, int ano) {
        super(login, nome, senha, cidade);

        this.cpf = cpf;
        this.dataNasc = new Data(dia, mes, ano);
        this.interesses = new ArrayList<>();
    }

    // Construtor da parte 2 do trabalho
    public Pessoa(String login, String nome, String senha, String cpf, int dia, int mes, int ano) {
        super(login, nome, senha);

        this.cpf = cpf;
        this.dataNasc = new Data(dia, mes, ano);
        this.interesses = new ArrayList<>();
    }

    // Construtor da parte 3 do trabalho
    public Pessoa(BufferedReader br) {
        super(br);
        try {
            this.cpf = br.readLine();
            this.dataNasc = new Data(br);
        } catch (IOException e) {
            System.out.println("Erro ao carregar pessoa.");
        }
    }

    // Métodos
    public String toString() {
        return this.nome + " (" + this.login + " - " + this.cpf + ")";
    }

    public void write_pessoa (BufferedWriter bw) {
        try {
            bw.write("P" + "\n");
            bw.write(this.login + "\n");
            bw.write(this.nome + "\n");
            bw.write(this.senha + "\n");
            bw.write(this.cpf + "\n");
            dataNasc.write_data(bw);
        } catch (IOException e) {
            System.out.println("Erro ao gravar dados da pessoa.");
        }
    }





}
