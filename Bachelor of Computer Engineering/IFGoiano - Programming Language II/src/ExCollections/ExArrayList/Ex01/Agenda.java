package ExCollections.ExArrayList.Ex01;

import java.util.ArrayList;

public class Agenda {
    ArrayList<EventoDeAgenda> lista;

    public Agenda() {
        this.lista = new ArrayList<EventoDeAgenda>();
    }

    @Override
    public String toString() {
        return "Agenda [lista=" + lista + "]";
    }

}