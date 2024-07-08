public class Postagem {
    private String foto, legenda;
    private Data dataPostagem;
    private Usuario usuario;

    // Construtor
    Postagem(String foto, String legenda, Data dataPostagem, Usuario usuario) {
        this.foto = foto;
        this.legenda = legenda;
        this.dataPostagem = dataPostagem;
        this.usuario = usuario;
    }

    // Métodos
    public void mostrarDados() {
        System.out.println(foto);
        System.out.println(legenda);
        System.out.println(this.dataPostagem.toString());
    }

    public Data getDataPostagem() {
        return this.dataPostagem;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }




}
