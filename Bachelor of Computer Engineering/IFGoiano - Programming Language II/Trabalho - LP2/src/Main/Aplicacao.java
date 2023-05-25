package Main;

import Excecoes.ErroDeBuscaException;
import Excecoes.ErroDeInsercaoException;
import Excecoes.FormatoInvalidoException;
import Fachadas.AlunoFachada;
import Fachadas.ProfessorFachada;
import Modelos.Aluno;
import Modelos.Pessoa;
import Modelos.Professor;
import Modelos.SalaDeAula;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args)
            throws ErroDeInsercaoException, ErroDeBuscaException, FormatoInvalidoException, FileNotFoundException, IOException {
       
        // Criação das fachadas
        AlunoFachada alunoFachada = new AlunoFachada();
        ProfessorFachada professorFachada = new ProfessorFachada();

        // Criação das listas de teste
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        ArrayList<Professor> professores = new ArrayList<Professor>();

        // Recebendo valores já cadastrados no banco de dados
        for(Aluno a : alunoFachada.listarAlunos()) alunos.add(a);
        for(Professor p : professorFachada.listarProfessores()) professores.add(p);

        Scanner scanner = new Scanner(System.in);
        int tamanhoDosTestes = 5;
        
        //Criação de alunos pra teste
        System.out.println("\tCadastre os alunos:");
        for (int i = 0; i < tamanhoDosTestes; i++) {
            System.out.println("\nDigite os dados do Aluno " + (i + 1) + ":");
            cadastraAluno(scanner, alunoFachada, alunos);
        }

        // //Criação de professores pra teste
        System.out.println("\tCadastre os professores:");
        for (int i = 0; i < tamanhoDosTestes; i++) {
            System.out.println("\nDigite os dados do Professor " + (i + 1) + ":");
            cadastraProfessor(scanner, professorFachada, professores);
        }

        SalaDeAula sala = null;
        boolean continua = true;
        while (continua) {
            int opcao = menu(scanner);
            switch (opcao) {
                case 0: {
                    continua = false;
                    System.out.println("\nPrograma finalizado!");
                    break;
                }
                case 1: {
                    System.out.println("Cadastrando aluno...");
                    cadastraAluno(scanner, alunoFachada, alunos);
                    break;
                }
                case 2: {
                    System.out.println("Atualizando aluno...");
                    System.out.println("Insira a matrícula do aluno a ser atualizado:");
                    int matricula = Integer.parseInt(scanner.nextLine());
                    System.out.println("Insira o nome do aluno:");
                    String nome = scanner.nextLine();
                    System.out.println("Insira o sobrenome do aluno:");
                    String sobrenome = scanner.nextLine();
                    alunoFachada.atualizarAluno(matricula, nome, sobrenome);
                    break;
                }
                case 3: {
                    System.out.println("Removendo aluno...");
                    System.out.println("Informe matrícula do aluno a ser removido:");
                    int matricula = Integer.parseInt(scanner.nextLine());
                    alunoFachada.removerAluno(matricula);
                    alunos.remove(alunoFachada.buscarAluno(matricula));
                    break;
                }
                case 4: {
                    System.out.println("Buscando aluno...");
                    System.out.println("Informe a matrícula do aluno:");
                    int matricula = Integer.parseInt(scanner.nextLine());
                    Aluno a = alunoFachada.buscarAluno(matricula);
                    System.out.println("Aluno [nome=" + a.getNome() + " sobrenome=" + a.getSobrenome() + " matricula=" + a.getMatricula() + "]");
                    break;

                }
                case 5: {
                    System.out.println("Listando alunos...");
                    for(Aluno a : alunoFachada.listarAlunos()){
                        System.out.println("Aluno [nome=" + a.getNome() + " sobrenome=" + a.getSobrenome() + " matricula=" + a.getMatricula() + "]");
                    }
                    break;
                }
                case 6: {
                    System.out.println("Cadastrando professor...");
                    cadastraProfessor(scanner, professorFachada, professores);
                    break;
                }
                case 7: {
                    System.out.println("Atualizando professor...");
                    System.out.println("Insira o nome do professor a ser atualizado:");
                    String nome = scanner.nextLine();
                    System.out.println("Insira o sobrenome do professor a ser atualizado:");
                    String sobrenome = scanner.nextLine();
                    System.out.println("Insira a nova disciplina deste professor:");
                    String disciplina = scanner.nextLine();
                    professorFachada.atualizarProfessor(nome, sobrenome, disciplina);
                    break;
                }
                case 8: {
                    System.out.println("Removendo professor...");
                    System.out.println("Informe nome do professor a ser removido:");
                    String nome = scanner.nextLine();
                    System.out.println("Informe o sobrenome do professor a ser removido:");
                    String sobrenome = scanner.nextLine();
                    professorFachada.removerProfessor(nome, sobrenome);
                    break;
                }
                case 9: {
                    System.out.println("Buscando professor...");
                    System.out.println("Informe o nome do professor:");
                    String nome = scanner.nextLine();
                    System.out.println("Informe o sobrenome do professor:");
                    String sobrenome = scanner.nextLine();
                    Professor p = professorFachada.buscarProfessor(nome, sobrenome);
                    System.out.println("Professor [nome=" + p.getNome() + " sobrenome=" + p.getSobrenome() + " disciplina=" + p.getDisciplina() + "]");
                    break;
                }
                case 10: {
                    System.out.println("Listando professores...");
                    for(Professor p : professorFachada.listarProfessores()) {
                        System.out.println("Professor [nome=" + p.getNome() + " sobrenome=" + p.getSobrenome() + " disciplina=" + p.getDisciplina() + "]");
                    }
                    
                    break;
                }
                case 11: {
                    if (sala == null) {
                        System.out.println("Cadastrando sala de aula...");
                        System.out.println("Informe a identificação da sala de aula:");
                        String identificacao = scanner.nextLine();
                        sala = new SalaDeAula(identificacao, alunos);
                        System.out.println("Sala cadastrada!");
                    } else {
                        System.out.println("A sala já foi cadastrada!");
                    }
                    break;
                }
                case 12: {
                    System.out.println("Ordenando sala de aula por ordem alfabética...");
                    sala.ordenarAlunosPorNome();
                    System.out.println("Sala de aula ordenada.");
                    break;
                }
                case 13: {
                    System.out.println("Ordenando sala de aula por matrícula...");
                    sala.ordenarAlunosPorMatricula();
                    System.out.println("Sala de aula ordenada.");
                    break;
                }
                case 14: {
                    System.out.println("Informe o nome do professor:");
                    String nome = scanner.nextLine();
                    System.out.println("Informe o sobrenome do professor:");
                    String sobrenome = scanner.nextLine();
                    System.out.println("Informe a disciplina do professor:");
                    String disciplina = scanner.nextLine();
                    professorFachada.buscarProfessor(nome, sobrenome);

                    sala.alterarProfessor(new Professor(nome, sobrenome, disciplina));
                    break;
                }
                case 15: {
                    if (sala.getProfessor() != null) {
                        sala.imprimeSala();
                    } else {
                        System.out.println("A sala não possui um professor, por favor insira-o!");
                    }
                    break;
                }
                case 16: {
                    System.out.println("Serializando...");
                    Pessoa.listaAlunosToJson(alunos);
                    System.out.println("Lista de alunos serializada.");
                    break;
                }
                case 17: {
                    System.out.println("Desserializando...");
                    Pessoa.jsonToListaAlunos();
                    break;
                }
            }
        }
        scanner.close();
    }

    public static void cadastraAluno(Scanner scanner, AlunoFachada alunoFachada, ArrayList<Aluno> alunos)
            throws FormatoInvalidoException, ErroDeInsercaoException {
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Matrícula: ");
        int matricula = Integer.parseInt(scanner.nextLine());

        Aluno aluno = new Aluno(nome, sobrenome, matricula);
        alunoFachada.inserirAluno(aluno);
        alunos.add(aluno);
    }

    public static void cadastraProfessor(Scanner scanner, ProfessorFachada professorFachada,
            ArrayList<Professor> professores) throws FormatoInvalidoException, ErroDeInsercaoException {
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Disciplina: ");
        String disciplina = scanner.nextLine();

        Professor professor = new Professor(nome, sobrenome, disciplina);
        professorFachada.inserirProfessor(professor);
        professores.add(professor);
    }

    public static int menu(Scanner scanner) {
        System.out.println("=========================================");
        System.out.println("\tAluno_BancoDeDados:");
        System.out.println("(1) Inserir um aluno novo.");
        System.out.println("(2) Atualizar um aluno existente.");
        System.out.println("(3) Remover um aluno existente.");
        System.out.println("(4) Buscar um aluno pela matrícula.");
        System.out.println("(5) Listar todos os alunos.");
        System.out.println("=========================================");
        System.out.println("\tProfessor_BancoDeDados:");
        System.out.println("(6) Inserir um professor novo.");
        System.out.println("(7) Atualizar um professor existente.");
        System.out.println("(8) Remover um professor existente.");
        System.out.println("(9) Buscar um professor pelo nome e sobrenome.");
        System.out.println("(10) Listar todos os professores");
        System.out.println("=========================================");
        System.out.println("\tSala de aula:");
        System.out.println("(11) Criar uma sala de aula a partir da lista de alunos.");
        System.out.println("(12) Ordenar a lista de alunos por ordem alfabética.");
        System.out.println("(13) Ordenar a lista de alunos por matrícula.");
        System.out.println("(14) Definir professor da sala.");
        System.out.println("(15) Imprimir sala.");
        System.out.println("=========================================");
        System.out.println("\tSerialização:");
        System.out.println("(16) Serializar lista de alunos em arquivo JSON.");
        System.out.println("(17) Desserializar lista de alunos JSON.");
        System.out.println("=========================================");
        System.out.println("(0) Encerrar programa.");
        System.out.println("=========================================");
        System.out.println("Escolha uma opção:");
        System.out.println("=========================================");

        int[] opcoesValidas = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 };
        int num = Integer.parseInt(scanner.nextLine());
        for (int i : opcoesValidas) {
            if (i == num) break;
            else if (i == 17 && i != num){
                System.out.println("Opção inválida.");
                return menu(scanner);
            }
            
        }
        return num;
    }
}