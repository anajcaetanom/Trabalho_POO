import java.util.Comparator;

public class FeedSorter implements Comparator<Postagem> {

    public int compare(Postagem p1, Postagem p2) {

        // ordena por data se elas nao forem iguais
        int comp_data = p1.getDataPostagem().compareTo(p2.getDataPostagem());
        if (comp_data != 0) return comp_data;

        // ordena por seguidores se a data for igual
        int comp_seguidores = Integer.compare(p1.getUsuario().seguidores.size(), p2.getUsuario().seguidores.size());
        if (comp_seguidores != 0) return comp_seguidores;

        // ordena por login (crescente) se os seguidores for igual
        return p2.getUsuario().login.compareTo(p1.getUsuario().login);

    }
}
