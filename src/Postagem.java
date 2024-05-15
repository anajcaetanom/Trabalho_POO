public class Postagem {
    private String foto, legenda;
    private Data dataPostagem;

    // Construtor
    Postagem(String foto, String legenda, Data dataPostagem) {
        this.foto = foto;
        this.legenda = legenda;
        this.dataPostagem = dataPostagem;
    }

    // Métodos
    public void mostrarDados() {
        System.out.println(foto);
        System.out.println(legenda);
        System.out.println(this.dataPostagem.toString());
    }



}
