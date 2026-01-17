package br.com.banco.view;


import br.com.banco.controller.BancoConnection;

import java.sql.*;

public class ShowTables {

        public void mostrarClientes(){
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;
            String sql = "SELECT * FROM Cliente";

                try (Connection conn = BancoConnection.getConnection();
                     PreparedStatement stmt = conn.prepareStatement(sql)) {

                    ResultSet rs= stmt.executeQuery(sql);

                    System.out.println("Mostrando todos os clientes:\n");
                    while (rs.next()) {
                        int id_cliente = rs.getInt("id_client");
                        String cpf = rs.getString("cpf");
                        String nome = rs.getString("nome");
                        float valor_compra = rs.getFloat("valor_compra");
                        String forma_pag = rs.getString("forma_pag");

                        System.out.printf("ID: %d |\nCPF: %s |\nNome: %s |\nValor da Compra: %.2f |\nForma de Pagamento: %s |\n________________________________________________\n",
                                id_cliente, cpf, nome, valor_compra, forma_pag);
                    }

                } catch (SQLException e) {
                    System.err.println("Erro ao estabelecer conexão:" + e.getMessage());
                }
        }
}
