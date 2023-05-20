package ExComparator.Ex01;

import java.util.Comparator;

public class ProdutoComparator implements Comparator<Produto> {
    public int compare(Produto p1, Produto p2) {
        if (p1.codigo > p2.codigo)
            return 1;
        else
            return -1;
    }
}
