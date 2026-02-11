package br.com.banco.view;

import br.com.banco.controller.BancoConnection;
import br.com.banco.model.Account;

import java.sql.*;
import java.util.Scanner;

public class ShowTables {

        public void mostrarClientes(){
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;
            String sql = "SELECT * FROM Cliente";

                try (Connection conn = BancoConnection.getConnection();
                     PreparedStatement stmt = conn.prepareStatement(sql)) {

                    ResultSet rs = stmt.executeQuery(sql);

                    System.out.println("Mostrando todos os clientes:\n");
                    while (rs.next()) {
                        int id_cliente = rs.getInt("id_client");
                        String cpf = rs.getString("cpf");
                        String nome = rs.getString("nome");
                        float valor_compra = rs.getFloat("valor_compra");
                        String forma_pag = rs.getString("forma_pag");
                        String status = rs.getString("status");
                        String telefone_cliente = rs.getString("telefone_cliente");
                        Date dataCompra = rs.getDate("dataCompra");

                        System.out.printf("ID: %d |\nCPF: %s |\nNome: %s |\nValor da Compra: %.2f |\nForma de Pagamento: %s |\nStatus do Cliente: %s\nTelefone do Cliente: %s\nData da Compra: %s\n________________________________________________\n",
                                id_cliente, cpf, nome, valor_compra, forma_pag, status, telefone_cliente, dataCompra);
                    }

                } catch (SQLException e) {
                    System.err.println("Erro ao estabelecer conexão:" + e.getMessage());
                }
        }

        public void mostrarClientesDebito(){
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;
            String sql = "SELECT * FROM Cliente WHERE status = 'em débito'";

            try (Connection conn = BancoConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                ResultSet rs = stmt.executeQuery(sql);

                System.out.println("CLIENTES EM DÉBITO:\n");
                while (rs.next()) {
                    int id_cliente = rs.getInt("id_client");
                    String cpf = rs.getString("cpf");
                    String nome = rs.getString("nome");
                    float valor_compra = rs.getFloat("valor_compra");
                    String forma_pag = rs.getString("forma_pag");
                    String status = rs.getString("status");
                    String telefone_cliente = rs.getString("telefone_cliente");
                    Date dataCompra = rs.getDate("dataCompra");


                    System.out.printf("ID: %d |\nCPF: %s |\nNome: %s |\nValor da Compra: %.2f |\nForma de Pagamento: %s |\nStatus do Cliente: %s\nTelefone do Cliente: %s\nData da Compra: %s\n________________________________________________\n",
                            id_cliente, cpf, nome, valor_compra, forma_pag, status, telefone_cliente, dataCompra);
                }

            } catch (SQLException e) {
                System.err.println("Erro ao estabelecer conexão:" + e.getMessage());
            }
        }

        public void buscarCliente(){
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;

            Scanner sc = new Scanner(System.in);
            System.out.println("CPF do Cliente: ");
            String cpfCliente = sc.nextLine();

            String sql = "SELECT * FROM Cliente WHERE cpf = ?";

            try (Connection conn = BancoConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, cpfCliente);

                ResultSet rs = stmt.executeQuery();

                System.out.println("CLIENTES ENCONTRADOS:\n");
                while (rs.next()) {
                    int id_cliente = rs.getInt("id_client");
                    String cpf = rs.getString("cpf");
                    String nome = rs.getString("nome");
                    float valor_compra = rs.getFloat("valor_compra");
                    String forma_pag = rs.getString("forma_pag");
                    String status = rs.getString("status");
                    String telefone_cliente = rs.getString("telefone_cliente");
                    Date dataCompra = rs.getDate("dataCompra");


                    System.out.printf("ID: %d |\nCPF: %s |\nNome: %s |\nValor da Compra: %.2f |\nForma de Pagamento: %s |\nStatus do Cliente: %s\nTelefone do Cliente: %s\nData da Compra: %s\n________________________________________________\n",
                            id_cliente, cpf, nome, valor_compra, forma_pag, status, telefone_cliente, dataCompra);
                }

            } catch (SQLException e) {
                System.err.println("Erro ao estabelecer conexão:" + e.getMessage());
            }
        }

        public void deletarClientesTeste(){
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;


            try (Connection conn = BancoConnection.getConnection();
                 Statement stmt = conn.createStatement()) {
 //                  ⬆ Statement: estado para a variável stmt com o metodo para criar uma string sql (por isso não é passada como parametro)

                stmt.executeUpdate("TRUNCATE TABLE cliente");
//                        ⬆ não precisamos passar parametros nesse metodo pois é só a execucao de uma string sql
                System.out.println("LISTA DE CLIENTES ZERADA COM SUCESSO.");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
}
