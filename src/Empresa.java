import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Empresa extends Usuario {
    private String cnpj, endereco, site, descricao;
    private Area area;

    // Construtor completo
    public Empresa(String login, String nome, String senha, Local cidade, String cnpj, String endereco, String site, String descricao, Area area) {
        super(login, nome, senha, cidade);

        this.cnpj = cnpj;
        this.endereco = endereco;
        this.site = site;
        this.descricao = descricao;
        this.area = area;
    }

    // Construtor da parte 2 do trabalho
    public Empresa(String login, String nome, String senha, String cnpj) {
        super(login, nome, senha);

        this.cnpj = cnpj;
    }

    // Construtor da parte 3 do trabalho
    public Empresa(BufferedReader br) {
        super(br);
        try {
            this.cnpj = br.readLine();
        } catch (IOException e) {
            System.out.println("Erro ao carregar empresa.");
        }
    }

    // Métodos
    public String toString() {
        return this.nome + " (" + this.login + " - " + this.cnpj + ")";
    }

    public void write_empresa(BufferedWriter bw) {
        try {
            bw.write("E" + "\n");
            bw.write(this.login + "\n");
            bw.write(this.nome + "\n");
            bw.write(this.senha + "\n");
            bw.write(this.cnpj + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao gravar os dados do empresa.");
        }
    }





}
