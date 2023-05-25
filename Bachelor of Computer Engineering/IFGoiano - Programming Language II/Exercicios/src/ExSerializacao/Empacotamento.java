package ExSerializacao;

import java.io.*;

public class Empacotamento {
    public static void gravarArquivoBinario(Agenda agenda, String nomeArq) {
        try (ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(nomeArq))) {
            objOutput.writeObject(agenda);
            System.out.println("Objetos gravados com sucesso!\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Agenda lerArquivoBinario(String nomeArq) {
        Agenda lista = new Agenda();
        try (ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(nomeArq))) {
            File arq = new File(nomeArq);
            if (arq.exists()) {
                lista = (Agenda) objInput.readObject();
                System.out.println("Objetos lidos com sucesso!\n");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return (lista);
    }
}