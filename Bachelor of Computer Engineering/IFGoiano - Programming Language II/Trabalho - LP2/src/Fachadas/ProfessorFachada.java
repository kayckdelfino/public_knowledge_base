package Fachadas;

import java.util.ArrayList;

import Excecoes.ErroDeBuscaException;
import Excecoes.ErroDeInsercaoException;
import Excecoes.FormatoInvalidoException;
import Fachadas.Interfaces.IProfessorFachada;
import Controladores.Interfaces.IProfessorControlador;
import Controladores.ProfessorControlador;
import Modelos.Professor;

public class ProfessorFachada implements IProfessorFachada {
    private final IProfessorControlador iProfessorControlador;

    public ProfessorFachada() {
        this.iProfessorControlador = new ProfessorControlador();
    }

    
    public void inserirProfessor(Professor professor) throws FormatoInvalidoException, ErroDeInsercaoException {
        if (professor != null) {
            iProfessorControlador.inserirProfessor(professor);
        } else {
            throw new FormatoInvalidoException("Aluno inválido");
        }
    }

    public void atualizarProfessor(String nome, String sobrenome, String disciplina) throws ErroDeBuscaException {
        
        iProfessorControlador.atualizarProfessor(nome, sobrenome, disciplina);
    }

    public void removerProfessor(String nome, String sobrenome) throws ErroDeBuscaException {
        iProfessorControlador.removerProfessor(nome, sobrenome);
    }

    public Professor buscarProfessor(String nome, String sobrenome) throws ErroDeBuscaException {
        return iProfessorControlador.buscarProfessor(nome, sobrenome);
    }

    public ArrayList<Professor> listarProfessores() {
        return iProfessorControlador.listarProfessores();
    }
}