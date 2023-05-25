package Fachadas.Interfaces;

import Excecoes.ErroDeBuscaException;
import Excecoes.ErroDeInsercaoException;
import Excecoes.FormatoInvalidoException;
import Modelos.Aluno;

import java.util.ArrayList;

public interface IAlunoFachada {
    void inserirAluno(Aluno aluno) throws FormatoInvalidoException, ErroDeInsercaoException;
    void atualizarAluno(int matricula, String nome, String sobrenome) throws ErroDeBuscaException;
    void removerAluno(int matricula) throws ErroDeBuscaException;
    Aluno buscarAluno(int matricula) throws ErroDeBuscaException;
    ArrayList<Aluno> listarAlunos();
}