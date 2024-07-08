import java.util.Comparator;

public class FeedSorter implements Comparator<Postagem> {

    public int compare(Postagem p1, Postagem p2) {

        int comp_data = p1.getDataPostagem().compareTo(p2.getDataPostagem());
        if (comp_data != 0) return comp_data;

        int comp_seguidores = Integer.compare(p1.getUsuario().seguidores.size(), p2.getUsuario().seguidores.size());
        if (comp_seguidores != 0) return comp_seguidores;

        return p1.getUsuario().login.compareTo(p2.getUsuario().login);
    }
}
