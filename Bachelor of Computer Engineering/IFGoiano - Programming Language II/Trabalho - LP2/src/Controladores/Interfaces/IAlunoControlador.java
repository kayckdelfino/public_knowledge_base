package Controladores.Interfaces;

import Excecoes.ErroDeBuscaException;
import Excecoes.ErroDeInsercaoException;
import Excecoes.FormatoInvalidoException;
import Modelos.Aluno;

import java.util.ArrayList;

public interface IAlunoControlador {
    public void inserirAluno(Aluno aluno) throws FormatoInvalidoException, ErroDeInsercaoException;
    public void atualizarAluno(int matricula, String nome, String sobrenome) throws ErroDeBuscaException;
    public void removerAluno(int matricula) throws ErroDeBuscaException;
    public Aluno buscarAluno(int matricula) throws ErroDeBuscaException;
    public ArrayList<Aluno> listarAlunos();
}