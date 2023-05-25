package Controladores;

import Excecoes.ErroDeBuscaException;
import Excecoes.ErroDeInsercaoException;
import Excecoes.FormatoInvalidoException;
import Controladores.Interfaces.IAlunoControlador;
import Persistencia.Interfaces.IAlunoPersistencia;
import Persistencia.BancoDeDados;
import Modelos.Aluno;

import java.util.ArrayList;

public class AlunoControlador implements IAlunoControlador {
    private final IAlunoPersistencia iAlunoPersistencia;

    public AlunoControlador() {
        this.iAlunoPersistencia = new BancoDeDados();
    }

    @Override
    public void inserirAluno(Aluno aluno) throws FormatoInvalidoException, ErroDeInsercaoException {
        validaInsercao(aluno);
        
        this.iAlunoPersistencia.inserirAluno(aluno);
    }

    @Override
    public void atualizarAluno(int matricula, String nome, String sobrenome) throws ErroDeBuscaException {
        validaBusca(matricula);
        this.iAlunoPersistencia.atualizarAluno(matricula, nome, sobrenome);
    }

    @Override
    public void removerAluno(int matricula) throws ErroDeBuscaException {
        validaBusca(matricula);
        
        this.iAlunoPersistencia.removerAluno(matricula);
    }

    @Override
    public Aluno buscarAluno(int matricula) throws ErroDeBuscaException {
        validaBusca(matricula);

        return this.iAlunoPersistencia.buscarAluno(matricula);
    }

    @Override
    public ArrayList<Aluno> listarAlunos() {
        return this.iAlunoPersistencia.listarAlunos();
    }

    public void validaInsercao(Aluno aluno) throws ErroDeInsercaoException, FormatoInvalidoException{
        for(Aluno a : this.iAlunoPersistencia.listarAlunos()){
            if(a.getMatricula() == aluno.getMatricula()) throw new ErroDeInsercaoException("Matrícula de aluno já existente.");
        }
        if (aluno == null) throw new FormatoInvalidoException("Aluno inválido.");
        if (aluno.getNome().length() > 30) throw new ErroDeInsercaoException("Nome excedeu o tamanho máximo.");
        if (aluno.getSobrenome().length() > 30) throw new ErroDeInsercaoException("Sobrenome excedeu o tamanho máximo.");
    }

    public void validaBusca(int matricula) throws ErroDeBuscaException {
        boolean condicao = false;
        while (!condicao) {
            for (Aluno a : this.iAlunoPersistencia.listarAlunos()) {
                if(a.getMatricula() == matricula) condicao = true;
            }
            if (!condicao) throw new ErroDeBuscaException("Matrícula de aluno não encontrada.");
        }
    }
}