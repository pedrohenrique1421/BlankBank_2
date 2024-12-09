package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoMySql {

    public static void main(String[] args) {
        // URL de conexão com o MySQL, geralmente no formato: "jdbc:mysql://localhost:3306/nome_do_banco"
        String url = "jdbc:mysql://localhost:3306/meu_banco"; // Substitua 'meu_banco' pelo nome do seu banco de dados
        String user = "root"; // Usuário do MySQL
        String password = ""; // Senha (se estiver usando a senha padrão, deixe vazio)

        try {
            // Estabelecendo a conexão com o banco de dados
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão bem-sucedida ao MySQL!");

            // Criação de uma instrução SQL para testar a conexão
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM sua_tabela"; // Altere 'sua_tabela' para uma tabela existente no seu banco
            stmt.executeQuery(query);

            // Fechando a conexão após o uso
            conn.close();

        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao MySQL: " + e.getMessage());
        }
    }

}
