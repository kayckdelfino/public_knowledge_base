package ExCollections.ExArrayList.Ex01;

public class EventoDeAgenda {
    String codigo;
    String nome;
    Data data;

    public EventoDeAgenda(String codigo, String nome, Data data) {
        this.codigo = codigo;
        this.nome = nome;
        this.data = data;
    }

    @Override
    public String toString() {
        return "EventoDeAgenda [codigo=" + codigo + ", nome=" + nome + ", dia=" + data.dia + ", mês=" + data.mes
                + ", ano=" + data.ano + "]";
    }

}