import java.util.ArrayList;

public class Usuario {
   protected String login, nome, senha;
   protected Local cidade;
   protected ArrayList<Postagem> posts;
   protected ArrayList<Usuario> seguindo, seguidores;
   protected ArrayList<Pessoa> interessados;



   // Métodos

   public boolean validarAcesso(String senha) {
      return this.senha.equals(senha);
   }

   public String toString() {
      return this.nome + "(" + this.login + ")";
   }

   public void postar(String foto, String legenda, Data hoje, String senha) {
      if (this.validarAcesso(senha)) {
         Postagem novaPostagem = new Postagem(foto, legenda, hoje);
         this.posts.add(novaPostagem);
      }
      else System.out.print("Senha incorreta.");
   }

   public void seguir(Usuario usuario) {
      this.seguindo.add(usuario);
      usuario.seguidores.add(this);
   }

   public void mostrarPosts() {
      for (Postagem postagem : posts) {
         postagem.mostrarDados();
      }
   }

   public void feed() {
      for (Usuario usuario : seguindo) {
         usuario.mostrarPosts();
      }
   }


}
