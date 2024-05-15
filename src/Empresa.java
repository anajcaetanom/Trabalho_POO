public class Empresa extends Usuario {
    private String cnpj, endereco, site, descricao;
    private Area area;




    public String toString() {
        return this.nome + "(" + this.login + " - " + this.cnpj + ")";
    }


}
