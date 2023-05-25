package ExComparator.Ex01;

import java.util.ArrayList;
import java.util.Collections;

public class Teste {
    public static void main(String[] args) {
        ArrayList<Produto> p = new ArrayList<Produto>();

        p.add(new Produto(0));
        p.add(new Produto(1));

        Collections.sort(p, new ProdutoComparator());
        for (Produto produto : p)
            System.out.println(produto.codigo);
    }
}
