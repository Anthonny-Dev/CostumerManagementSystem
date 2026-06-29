package br.com.banco.controller;

import br.com.banco.controller.BancoConnection;
import br.com.banco.model.Account;
import br.com.banco.model.Produtos;

import java.sql.*;

public class createAccount{
    public void createaccount(Account account) throws SQLException {

        String sqlCliente = "INSERT INTO cliente(cpf, nome, valor_compra, forma_pag, status, telefone_cliente) VALUES (?, ?, ?, ?, ?, ?)";
        String sqlClienteProduto = "INSERT INTO cliente_produto (id_client, id_produto, quantidade) VALUES (?, ?, ?)";

        try (Connection conn = BancoConnection.getConnection()) {

            conn.setAutoCommit(false);

            try (
                    PreparedStatement stmtCliente = conn.prepareStatement(sqlCliente, Statement.RETURN_GENERATED_KEYS);
            ) {

                stmtCliente.setString(1, account.getCpf());
                stmtCliente.setString(2, account.getNome());
                stmtCliente.setFloat(3, account.getValor_compra());
                stmtCliente.setString(4, account.getForma_pag());
                stmtCliente.setString(5, account.getStatus());
                stmtCliente.setString(6, account.getTelefone_cliente());

                stmtCliente.executeUpdate();

                ResultSet generatedKeys = stmtCliente.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int idGerado = generatedKeys.getInt(1);
                    account.setIdClient(idGerado);
                } else {
                    throw new SQLException("Falha ao obter ID do cliente.");
                }

                try (PreparedStatement stmtClienteProduto = conn.prepareStatement(sqlClienteProduto)) {

                    for (Produtos produto : account.getProdutos()) {

                        stmtClienteProduto.setInt(1, account.getIdClient());
                        stmtClienteProduto.setInt(2, produto.getId_produto());
                        stmtClienteProduto.setInt(3, produto.getQuantidade());

                        stmtClienteProduto.executeUpdate();
                    }
                }
                conn.commit();
                System.out.println("Cliente cadastrado com Sucesso!");

            } catch (SQLException e) {

                conn.rollback();
                System.err.println("Erro ao criar cliente: " + e.getMessage());
            }
        }
    }

}

