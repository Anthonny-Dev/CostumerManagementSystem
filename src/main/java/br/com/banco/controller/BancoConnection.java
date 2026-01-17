package br.com.banco.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/database_client";
    private static final String USER = "root";
    private static final String PASSWORD = "@Computador1908";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            System.out.println("Conectando ao banco de dados...");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            if (connection != null) {
                System.out.println("Conexão estabelecida com sucesso.");

                statement = connection.createStatement();

                String sql = "SHOW TABLES";
                resultSet = statement.executeQuery(sql);


                System.out.println("\n Tabelas no banco de dados 'database_client':");
                int count = 1;
                while (resultSet.next()) {
                    String tableName = resultSet.getString(1);
                    System.out.println(count + ". " + tableName);
                    count++;
                }

                System.out.println("\n Clientes cadastrados:");
                sql = "SELECT * FROM cliente";
                resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    int id_cliente = resultSet.getInt("id_client");
                    String cpf = resultSet.getString("cpf");
                    String nome = resultSet.getString("nome");
                    float valor_compra = resultSet.getFloat("valor_compra");
                    String forma_pag = resultSet.getString("forma_pag");

                    System.out.printf("ID: %d |\n CPF: %s |\n Nome: %s |\n  Valor da Compra: %f |\n Forma de Pagamento: %s |\n________________________________________________\n",
                            id_cliente, cpf, nome, valor_compra, forma_pag);
                }

            }

        } catch (SQLException e) {
            System.err.println(" Erro na conexao com o banco de dados:");
            System.err.println("Mensagem: " + e.getMessage());
            System.err.println("Código de erro: " + e.getErrorCode());
            System.err.println("Estado SQL: " + e.getSQLState());

        } finally {

            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) {
                    connection.close();
                    System.out.println("\n Conexão fechada.");
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
