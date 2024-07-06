import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;

public class Sistema {
    private ArrayList<Pessoa> pessoas;
    private ArrayList<Empresa> empresas;

    // Construtor
    Sistema() {
        this.pessoas = new ArrayList<>();
        this.empresas = new ArrayList<>();
    }

    // Métodos
    public Usuario buscarUsuario(String login) {
        for (Usuario u : this.pessoas) {
            if (u.login.equals(login)) return u;
        }

        for (Empresa e : this.empresas) {
            if (e.login.equals(login)) return e;
        }

        return null;
    }

    public void novaPessoa(Pessoa p) {
        this.pessoas.add(p);
    }

    public void novaEmpresa(Empresa e) {
        this.empresas.add(e);
    }

    public void listarUsuarios() {
        System.out.println("Pessoas:");
        for (Pessoa p : this.pessoas) {
            System.out.println(p.toString());
        }

        System.out.println("Empresas:");
        for (Empresa e : this.empresas) {
            System.out.println(e.toString());
        }
    }

    public void write_txt_file () {
        try (FileWriter fw = new FileWriter("dados.txt");
            BufferedWriter bw = new BufferedWriter(fw)) {

            if (!this.pessoas.isEmpty()) {
                for (Pessoa p : this.pessoas) {
                    p.write_pessoa(bw);
                }
            }

            if (!this.empresas.isEmpty()) {
                for (Empresa e : this.empresas) {
                    e.write_empresa(bw);
                }
            }

            for (Pessoa p : this.pessoas) {
                if (!p.seguindo.isEmpty()) {
                    p.write_seguindo(bw);
                }
            }

            for (Empresa e : this.empresas) {
                if (!e.seguindo.isEmpty()) {
                    e.write_seguindo(bw);
                }
            }

            bw.write("F");

        } catch (IOException e) {
            System.out.println("erro");
        }
    }

    public void read_txt_file () {
        try (FileReader fr = new FileReader("dados.txt");
            BufferedReader br = new BufferedReader(fr)) {

            char caractere = br.readLine().charAt(0);

            while (caractere != 'F') {
                if (caractere == 'P') {
                    Pessoa p = new Pessoa(br);
                    this.novaPessoa(p);
                }

                if (caractere == 'E') {
                    Empresa e = new Empresa(br);
                    this.novaEmpresa(e);
                }

                if (caractere == 'S') {
                    Usuario user1 = buscarUsuario(br.readLine());
                    Usuario user2 = buscarUsuario(br.readLine());
                    user1.seguir(user2);
                    System.out.println(user1.login + " segue " + user2.login + ".");
                }

                caractere = br.readLine().charAt(0);
            }


        } catch (FileNotFoundException e) {
            System.out.println("Arquivo nao encontrado.");

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
        }
    }

}
