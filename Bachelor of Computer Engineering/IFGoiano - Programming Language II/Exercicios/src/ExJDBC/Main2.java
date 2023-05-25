/*
Atividade 
- Abrir o pgadmin e criar uma tabela "users" com os campos: -id(pk) -nome -endereço -telefone         *todos String (varchar)*
- Criar uma conexão JDBC usando o driver do postgre
- Criar um statement e rodar uma query para buscar todos os usuários (mostrar no console)
- Usar o PreparedStatement para criar uma query com parâmetros e fazer atualização em um registro
- Crie um registro novo (insert)
- Delete um registro baseado em um critério
- Usando o método addBatch da interface PreparedStatement, crie um método que inclua 5 registros ao mesmo tempo via conexão JDBC
*/

package ExJDBC;

import java.sql.*;

public class Main2 {
    public static void main(String[] args) throws SQLException {
        Connection conexao = null;

        try {
            // Acessando driver JDBC e estabelecendo conexão ao BD
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost/AulasLP2", "postgres", "postgres");

            imprimirRegistros(conexao);

        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados não localizado.");

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco de dados: " + ex.getMessage());
        } finally {
            if (conexao != null)
                conexao.close();
        }
    }

    // Consulta de valores do BD
    static void imprimirRegistros(Connection conexao){
        try {
            ResultSet rs = conexao.createStatement().executeQuery("select * from users");

            while (rs.next()) {
                System.out.println("id: " + rs.getString("id") + " nome: " + rs.getString("nome") + " endereco: "
                        + rs.getString("endereco") + " telefone: " + rs.getString("telefone"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Inserindo um valor ao BD
    static void insereUm(Connection conexao){
        try {
            Statement st = conexao.createStatement();
            st.execute("insert into users values ('654', 'Lucas', 'Rua 4', '11111')");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Inserindo valores ao BD (PreparedStatement)
    static void insereUmPreparado(Connection conexao){
        try {
            PreparedStatement ps = conexao.prepareStatement("insert into users values(?,?,?,?)");
            ps.setString(1, "123");
            ps.setString(2, "Kayck");
            ps.setString(3, "Rua 1");
            ps.setString(4, "123456789");
            int resultado = ps.executeUpdate();
            if (resultado == 1)
                System.out.println("Dados adicionados com sucesso!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Metodo pra adicionar 5 registros de uma vez
    static void inserirBatch(Connection conexao){
        String[] ids = {"1","2","3","4","5"};
        String[] nomes = {"João","Juca","Jorge","Jonas","José"};
        String[] enderecos = {"Rua","Rua","Rua","Rua","Rua"};
        String[] telefones = {"123","123","123","123","123"};

        try {
            PreparedStatement pstmt = conexao.prepareStatement("insert into users values(?,?,?,?)");

            for(int i = 0; i < ids.length; i++){
                pstmt.setString(1, ids[i]);
                pstmt.setString(2, nomes[i]);
                pstmt.setString(3, enderecos[i]);
                pstmt.setString(4, telefones[i]);
                pstmt.addBatch();
            }

            int[] updateCounts = pstmt.executeBatch();
            System.out.println(updateCounts);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Deletando registros do BD
    static void deleta(Connection conexao){
        try {
            Statement st = conexao.createStatement();
            st.execute("delete from users where nome = 'Kayck'");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}