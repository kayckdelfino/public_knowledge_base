package Controladores;

import Excecoes.ErroDeBuscaException;
import Excecoes.ErroDeInsercaoException;
import Excecoes.FormatoInvalidoException;
import Controladores.Interfaces.IProfessorControlador;
import Persistencia.Interfaces.IProfessorPersistencia;
import Persistencia.BancoDeDados;
import Modelos.Professor;

import java.util.ArrayList;

public class ProfessorControlador implements IProfessorControlador {
    private final IProfessorPersistencia iProfessorPersistencia;

    public ProfessorControlador() {
        this.iProfessorPersistencia = new BancoDeDados();
    }

    @Override
    public void inserirProfessor(Professor professor) throws FormatoInvalidoException, ErroDeInsercaoException {
        validaInsercao(professor);
        
        this.iProfessorPersistencia.inserirProfessor(professor);
    }

    @Override
    public void atualizarProfessor(String nome, String sobrenome, String disciplina) throws ErroDeBuscaException {
        validaBusca(nome, sobrenome);
        this.iProfessorPersistencia.atualizarProfessor(nome, sobrenome, disciplina);
    }

    @Override
    public void removerProfessor(String nome, String sobrenome) throws ErroDeBuscaException {
        validaBusca(nome, sobrenome);
        
        this.iProfessorPersistencia.removerProfessor(nome, sobrenome);
    }

    @Override
    public Professor buscarProfessor(String nome, String sobrenome) throws ErroDeBuscaException {
        validaBusca(nome, sobrenome);
        
        return this.iProfessorPersistencia.buscarProfessor(nome, sobrenome);
    }

    @Override
    public ArrayList<Professor> listarProfessores() {
        return this.iProfessorPersistencia.listarProfessores();
    }

    public void validaInsercao(Professor professor) throws ErroDeInsercaoException, FormatoInvalidoException{
        for(Professor p : this.iProfessorPersistencia.listarProfessores()){
            if(p.getNome().equals(professor.getNome()) && p.getSobrenome().equals(professor.getSobrenome())) throw new ErroDeInsercaoException("Professor já existente.");
        }
        if (professor == null) throw new FormatoInvalidoException("Professor inválido.");
        if (professor.getNome().length() > 30) throw new ErroDeInsercaoException("Nome excedeu o tamanho máximo.");
        if (professor.getSobrenome().length() > 30) throw new ErroDeInsercaoException("Sobrenome excedeu o tamanho máximo.");
        
    }

    public void validaBusca(String nome, String sobrenome) throws ErroDeBuscaException {
        boolean condicao = false;
        while (!condicao) {
            for (Professor p : this.iProfessorPersistencia.listarProfessores()) {
                if(p.getNome() == nome && p.getSobrenome() == sobrenome) condicao = true;
            }
            if (!condicao) throw new ErroDeBuscaException("Professor não encontrado.");
        }
    }
}