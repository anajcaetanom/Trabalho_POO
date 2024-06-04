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

    // Métodos
    public String toString() {
        return this.nome + " (" + this.login + " - " + this.cnpj + ")";
    }


}
