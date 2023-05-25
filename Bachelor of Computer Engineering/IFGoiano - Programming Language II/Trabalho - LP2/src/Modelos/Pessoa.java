package Modelos;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.io.*;

import java.util.ArrayList;

public class Pessoa {
    private String nome;
    private String sobrenome;
    
    public Pessoa(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public static void listaAlunosToJson(ArrayList<Aluno> alunos) throws FileNotFoundException, IOException {
        Gson gson = new GsonBuilder()
        .setPrettyPrinting()
        .serializeNulls()
        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        .create();

        FileWriter fw = new FileWriter("alunos.json");
        String json = gson.toJson(alunos);
        fw.write(json);

        fw.close();
    }

    public static void jsonToListaAlunos() throws FileNotFoundException {
        Gson gson = new GsonBuilder()
        .setPrettyPrinting()
        .serializeNulls()
        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        .create();
    
        FileReader fr = new FileReader("alunos.json");
        Type tipoListaAlunos = new TypeToken<ArrayList<Aluno>>() {}.getType();
        ArrayList<Aluno> alunos = gson.fromJson(fr, tipoListaAlunos);
        for(Aluno a : alunos) System.out.println("Aluno [nome=" + a.getNome() + " sobrenome=" + a.getSobrenome() + " matricula=" + a.getMatricula() + "]");
    }
}