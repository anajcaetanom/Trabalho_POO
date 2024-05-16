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
        for (Pessoa p : this.pessoas) {
            System.out.println("Pessoas:");
            System.out.println(p.toString());
        }

        for (Empresa e : this.empresas) {
            System.out.println("Empresas:");
            System.out.println(e.toString());
        }
    }

}
