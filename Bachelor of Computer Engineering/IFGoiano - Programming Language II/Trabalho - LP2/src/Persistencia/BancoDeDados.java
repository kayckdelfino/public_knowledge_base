package Persistencia;

import Excecoes.ErroDeBuscaException;
import Excecoes.ErroDeInsercaoException;
import Excecoes.FormatoInvalidoException;
import Persistencia.Interfaces.IAlunoPersistencia;
import Persistencia.Interfaces.IProfessorPersistencia;
import Modelos.Aluno;
import Modelos.Professor;

import java.util.ArrayList;
import java.sql.*;

public class BancoDeDados implements IAlunoPersistencia, IProfessorPersistencia {
    // Dados do BD
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/Aplicação_LP2";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "postgres";

    // Métodos pra inserir
    @Override
    public void inserirAluno(Aluno aluno) throws FormatoInvalidoException, ErroDeInsercaoException {
        Connection conn = conecta();
        try {
            String query = "INSERT INTO aluno (nome, sobrenome, matricula) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, aluno.getNome());
            pstmt.setString(2, aluno.getSobrenome());
            pstmt.setInt(3, aluno.getMatricula());
            pstmt.executeUpdate();
            System.out.println("Aluno inserido com sucesso no banco de dados.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir aluno no banco de dados.");
            e.printStackTrace();
        }
        desconecta(conn);
    }

    @Override
    public void inserirProfessor(Professor professor) throws FormatoInvalidoException, ErroDeInsercaoException {
        Connection conn = conecta();
        try {
            String query = "INSERT INTO professor (nome, sobrenome, disciplina) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, professor.getNome());
            pstmt.setString(2, professor.getSobrenome());
            pstmt.setString(3, professor.getDisciplina());
            pstmt.executeUpdate();
            System.out.println("Professor inserido com sucesso no banco de dados.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir professor no banco de dados.");
            e.printStackTrace();
        }
        desconecta(conn);
    }

    // Métodos pra atualizar
    @Override
    public void atualizarAluno(int matricula, String nome, String sobrenome) throws ErroDeBuscaException {
        Connection conn = conecta();
        try {
            String query = "UPDATE aluno SET nome = ?, sobrenome = ? WHERE matricula = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(3, matricula);
            pstmt.setString(1, nome);
            pstmt.setString(2, sobrenome);
            pstmt.executeUpdate();
            System.out.println("Aluno atualizado com sucesso no banco de dados.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar aluno no banco de dados.");
            e.printStackTrace();
        }
        desconecta(conn);
    }

    @Override
    public void atualizarProfessor(String nome, String sobrenome, String disciplina) throws ErroDeBuscaException {
        Connection conn = conecta();
        try {
            String query = "UPDATE professor SET disciplina = ? WHERE nome = ? AND sobrenome = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, disciplina);
            pstmt.setString(2, nome);
            pstmt.setString(3, sobrenome);
            pstmt.executeUpdate();
            System.out.println("Professor atualizado com sucesso no banco de dados.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar aluno no banco de dados.");
            e.printStackTrace();
        }
        desconecta(conn);
    }

    // Métodos pra remover
    @Override
    public void removerAluno(int matricula) throws ErroDeBuscaException {
        Connection conn = conecta();
        try {
            String query = "DELETE FROM aluno WHERE matricula = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, matricula);
            pstmt.executeUpdate();
            System.out.println("Aluno removido com sucesso do banco de dados.");
        } catch (SQLException e) {
            System.out.println("Erro ao remover aluno do banco de dados.");
            e.printStackTrace();
        }
        desconecta(conn);
    }

    @Override
    public void removerProfessor(String nome, String sobrenome) throws ErroDeBuscaException {
        Connection conn = conecta();
        try {
            String query = "DELETE FROM professor WHERE nome = ?  AND sobrenome = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nome);
            pstmt.setString(2, sobrenome);
            pstmt.executeUpdate();
            System.out.println("Professor removido com sucesso do banco de dados.");
        } catch (SQLException e) {
            System.out.println("Erro ao remover professor do banco de dados.");
            e.printStackTrace();
        }
        desconecta(conn);
    }

    // Métodos pra buscar
    @Override
    public Aluno buscarAluno(int matricula) throws ErroDeBuscaException {
        Aluno aluno = null;
        Connection conn = conecta();
        try {
            String query = "SELECT * FROM aluno WHERE matricula = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, matricula);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                aluno = new Aluno(nome, sobrenome, matricula);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar aluno por matrícula no banco de dados.");
            e.printStackTrace();
        }
        desconecta(conn);
        return aluno;
    }

    @Override
    public Professor buscarProfessor(String nome, String sobrenome) throws ErroDeBuscaException {
        Professor professor = null;
        Connection conn = conecta();
        try {
            String query = "SELECT * FROM professor WHERE nome = ? AND sobrenome = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nome);
            pstmt.setString(2, sobrenome);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String disciplina = rs.getString("disciplina");
                professor = new Professor(nome, sobrenome, disciplina);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar professor por nome no banco de dados.");
            e.printStackTrace();
        }
        desconecta(conn);
        return professor;
    }

    // Métodos pra listar
    @Override
    public ArrayList<Aluno> listarAlunos() {
        ArrayList<Aluno> alunos = new ArrayList<>();
        Connection conn = conecta();
        try {
            String query = "SELECT * FROM aluno";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                int matricula = rs.getInt("matricula");
                Aluno aluno = new Aluno(nome, sobrenome, matricula);
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar alunos do banco de dados.");
            e.printStackTrace();
        }
        desconecta(conn);
        return alunos;
    }

    @Override
    public ArrayList<Professor> listarProfessores() {
        ArrayList<Professor> professores = new ArrayList<>();
        Connection conn = conecta();
        try {
            String query = "SELECT * FROM professor";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                String disciplina = rs.getString("disciplina");
                Professor professor = new Professor(nome, sobrenome, disciplina);
                professores.add(professor);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar professores do banco de dados.");
            e.printStackTrace();
        }
        desconecta(conn);
        return professores;
    }

    private Connection conecta() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void desconecta(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}