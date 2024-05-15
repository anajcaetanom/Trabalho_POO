
import java.util.ArrayList;

public class Sistema {
    private ArrayList<Pessoa> pessoas;
    private ArrayList<Empresa> empresas;

    // Construtor
    Sistema() {
        ArrayList pessoas = new ArrayList();
        ArrayList empresas = new ArrayList();
    }

    // Métodos
    public Usuario buscarUsuario(String login) {
        for (Usuario u : pessoas) {
            if (u.login.equals(login)) return u;
        }

        for (Empresa e : empresas) {
            if (e.login.equals(login)) return e;
        }

        return null;
    }

    public void novaPessoa(Pessoa p) {
        pessoas.add(p);
    }

    public void novaEmpresa(Empresa e) {
        empresas.add(e);
    }

    public void listarUsuarios() {
        for (Pessoa p : pessoas) {
            System.out.println(p.toString());
        }

        for (Empresa e : empresas) {
            System.out.println(e.toString());
        }
    }

}
