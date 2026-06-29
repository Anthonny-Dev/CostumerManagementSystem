package br.com.banco.view;

import br.com.banco.controller.BancoConnection;
import br.com.banco.controller.createAccount;
import br.com.banco.model.Account;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
                        int idCliente = rs.getInt("id_client");
                        String cpf = rs.getString("cpf");
                        String nome = rs.getString("nome");
                        float valor_compra = rs.getFloat("valor_compra");
                        String forma_pag = rs.getString("forma_pag");
                        String status = rs.getString("status");
                        String telefone_cliente = rs.getString("telefone_cliente");
                        Date dataCompra = rs.getDate("dataCompra");

                        System.out.printf("ID: %d |\nCPF: %s |\nNome: %s |\nValor da Compra: %.2f |\nForma de Pagamento: %s |\nStatus do Cliente: %s\nTelefone do Cliente: %s\nData da Compra: %s\n________________________________________________\n",
                                idCliente, cpf, nome, valor_compra, forma_pag, status, telefone_cliente, dataCompra);
                    }

                } catch (SQLException e) {
                    System.err.println("Erro ao estabelecer conexão:" + e.getMessage());
                }
        }

    public List<Account> listarClientes() {

        List<Account> lista = new ArrayList<>();

        String sql = "SELECT * FROM cliente";

        try (Connection conn = BancoConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Account account = new Account(
                        rs.getInt("id_client"),
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        rs.getFloat("valor_compra"),
                        rs.getString("forma_pag"),
                        rs.getString("status"),
                        rs.getString("telefone_cliente"),
                        rs.getTimestamp("dataCompra").toLocalDateTime()

                );

                lista.add(account);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }


    public List<Account> mostrarClientesDebito(){
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;
            String sql = "SELECT * FROM Cliente WHERE status = 'em débito'";
            List<Account> lista = new ArrayList<>();

            try (Connection conn = BancoConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                ResultSet rs = stmt.executeQuery();

                System.out.println("CLIENTES EM DÉBITO:\n");
                Account account = null;
                while (rs.next()) {
                    account = new Account();

                    account.setIdClient(rs.getInt("id_client"));
                    account.setCpf(rs.getString("cpf"));
                    account.setNome(rs.getString("nome"));
                    account.setValor_compra(rs.getFloat("valor_compra"));
                    account.setForma_pag(rs.getString("forma_pag"));
                    account.setStatus(rs.getString("status"));
                    account.setTelefone_cliente(rs.getString("telefone_cliente"));
                    account.setDataCompra(rs.getTimestamp("dataCompra").toLocalDateTime());
                    lista.add(account);
                }


            } catch (SQLException e) {
                System.err.println("Erro ao estabelecer conexão:" + e.getMessage());
            }
        return lista;
    }

        public void buscarCliente(int i){
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
                    int idCliente = rs.getInt("id_client");
                    String cpf = rs.getString("cpf");
                    String nome = rs.getString("nome");
                    float valor_compra = rs.getFloat("valor_compra");
                    String forma_pag = rs.getString("forma_pag");
                    String status = rs.getString("status");
                    String telefone_cliente = rs.getString("telefone_cliente");
                    Date dataCompra = rs.getDate("dataCompra");


                    System.out.printf("ID: %d |\nCPF: %s |\nNome: %s |\nValor da Compra: %.2f |\nForma de Pagamento: %s |\nStatus do Cliente: %s\nTelefone do Cliente: %s\nData da Compra: %s\n________________________________________________\n",
                            idCliente, cpf, nome, valor_compra, forma_pag, status, telefone_cliente, dataCompra);
                }

            } catch (SQLException e) {
                System.err.println("Erro ao estabelecer conexão:" + e.getMessage());
            }
        }

        public void deletarClientesTeste(){
            Scanner scanner = new Scanner(System.in);
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;

            System.out.println("ZERAR TABELA CLIENTES? [Y/N]");
            String resposta = scanner.next().toUpperCase();

            // verificacao para confirmar zerar a tabela
            if (resposta.equals("Y")){
                try (Connection conn = BancoConnection.getConnection();
                     Statement stmt = conn.createStatement()) {
                    //                  ⬆ Statement: estado para a variável stmt com o metodo para criar uma string sql (por isso não é passada como parametro)

                    stmt.executeUpdate("TRUNCATE TABLE cliente");
//                        ⬆ não precisamos passar parametros nesse metodo pois é só a execucao de uma string sql
                    System.out.println("LISTA DE CLIENTES ZERADA COM SUCESSO.");

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } else if (resposta.equals("N")) {
                System.out.println("Finalizando método.");
            }
        }

        public void deletarClienteEspecifico(int i){
            Scanner scanner = new Scanner(System.in);
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;

            System.out.println("Deletar cliente via ID\nID do Cliente: ");
            int clienteDeletado = scanner.nextInt();

            String sql = "DELETE from cliente WHERE id_client = ?";

            try (Connection conn = BancoConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, clienteDeletado);

                int rs = stmt.executeUpdate();

                if(rs > 0){
                    System.out.println("Cliente deletado com sucesso!");
                }
                else {
                    System.out.println("Nenhum Cliente encontrado.");
                }

            } catch (SQLException e) {
                }
        }
}
