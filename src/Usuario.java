import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Usuario {
   protected String login, nome, senha;
   protected Local cidade;
   protected ArrayList<Postagem> posts;
   protected ArrayList<Usuario> seguindo, seguidores;
   protected ArrayList<Pessoa> interessados;

   // Construtor completo
   public Usuario(String login, String nome, String senha, Local cidade) {
      this.login = login;
      this.nome = nome;
      this.senha = senha;
      this.cidade = cidade;

      this.posts = new ArrayList<>();
      this.seguindo = new ArrayList<>();
      this.seguidores = new ArrayList<>();
      this.interessados = new ArrayList<>();
   }

   // Construtor da parte 2 do trabalho
   public Usuario(String login, String nome, String senha) {
      this.login = login;
      this.nome = nome;
      this.senha = senha;

      this.posts = new ArrayList<>();
      this.seguindo = new ArrayList<>();
      this.seguidores = new ArrayList<>();
      this.interessados = new ArrayList<>();
   }

   // Construtor da parte 3 do trabalho
   public Usuario(BufferedReader br) {
      try {
         this.login = br.readLine();
         this.nome = br.readLine();
         this.senha = br.readLine();

         this.posts = new ArrayList<>();
         this.seguindo = new ArrayList<>();
         this.seguidores = new ArrayList<>();

         System.out.println("Usuario " + this.login + " carregado(a) no sistema.");

      } catch (IOException e) {
         System.out.println("Erro ao carregar usuario.");
      }
   }

   // Método Abstrato
   public abstract String toString();

   // Métodos Concretos
   public boolean validarAcesso(String senha) {
      return this.senha.equals(senha);
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
      for (Postagem postagem : this.posts) {
         postagem.mostrarDados();
      }
   }

   public void feed() {
      System.out.println("\nFEED\nN");
      for (Usuario usuario : this.seguindo) {
         usuario.mostrarPosts();
      }
   }

   public void write_seguindo (BufferedWriter bw) {
      try {
         for (Usuario u : this.seguindo) {
            bw.write("S" + "\n");
            bw.write(this.login + "\n");
            bw.write(u.login + "\n");
         }
      } catch (IOException e) {
         System.out.println("Erro ao gravar seguidores.");
      }
   }





}
