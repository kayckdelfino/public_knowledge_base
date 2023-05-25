package Fachadas;

import Excecoes.ErroDeBuscaException;
import Excecoes.ErroDeInsercaoException;
import Excecoes.FormatoInvalidoException;
import Fachadas.Interfaces.IAlunoFachada;
import Controladores.Interfaces.IAlunoControlador;
import Controladores.AlunoControlador;
import Modelos.Aluno;

import java.util.ArrayList;

public class AlunoFachada implements IAlunoFachada {
    private final IAlunoControlador iAlunoControlador;

    public AlunoFachada() {
        this.iAlunoControlador = new AlunoControlador();
    }


    public void inserirAluno(Aluno aluno) throws FormatoInvalidoException, ErroDeInsercaoException {
        this.iAlunoControlador.inserirAluno(aluno);
    }

    public void atualizarAluno(int matricula, String nome, String sobrenome) throws ErroDeBuscaException {
        
        this.iAlunoControlador.atualizarAluno(matricula, nome, sobrenome);
    }

    public void removerAluno(int matricula) throws ErroDeBuscaException {
        this.iAlunoControlador.removerAluno(matricula);
    }

    public Aluno buscarAluno(int matricula) throws ErroDeBuscaException {
        return this.iAlunoControlador.buscarAluno(matricula);
    }

    public ArrayList<Aluno> listarAlunos() {
        return this.iAlunoControlador.listarAlunos();
    }
}