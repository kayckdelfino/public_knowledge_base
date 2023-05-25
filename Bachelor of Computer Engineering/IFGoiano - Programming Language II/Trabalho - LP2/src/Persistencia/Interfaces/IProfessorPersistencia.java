package Persistencia.Interfaces;

import Excecoes.ErroDeBuscaException;
import Excecoes.ErroDeInsercaoException;
import Excecoes.FormatoInvalidoException;
import Modelos.Professor;

import java.util.ArrayList;

public interface IProfessorPersistencia {
    void inserirProfessor(Professor professor) throws FormatoInvalidoException, ErroDeInsercaoException;
    void atualizarProfessor(String nome, String sobrenome, String disciplina) throws ErroDeBuscaException;
    void removerProfessor(String nome, String sobrenome) throws ErroDeBuscaException;
    Professor buscarProfessor(String nome, String sobrenome) throws ErroDeBuscaException;
    ArrayList<Professor> listarProfessores();
}