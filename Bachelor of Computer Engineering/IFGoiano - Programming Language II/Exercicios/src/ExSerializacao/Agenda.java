package ExSerializacao;

import java.util.ArrayList;
import java.io.Serializable;

public class Agenda implements Serializable {
    ArrayList<EventoDeAgenda> lista;

    public Agenda() {
        this.lista = new ArrayList<EventoDeAgenda>();
    }

    @Override
    public String toString() {
        return "Agenda [lista=" + lista + "]";
    }

}