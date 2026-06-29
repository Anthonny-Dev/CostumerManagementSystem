package br.com.banco.view;

import br.com.banco.controller.createAccount;
import br.com.banco.model.Account;
import br.com.banco.model.Produtos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CadastroView {

    public static VBox createPane() {
        List<Produtos> listaProdutos = new ArrayList<>();


        TextField idClientField = new TextField();
        idClientField.setPromptText("ID do Cliente");

        TextField cpfField = new TextField();
        cpfField.setPromptText("CPF do Cliente");

        TextField nomeField = new TextField();
        nomeField.setPromptText("Nome do Cliente");

        TextField valor_compraField = new TextField();
        valor_compraField.setPromptText("Valor Total da Compra");

        TextField forma_pagField = new TextField();
        forma_pagField.setPromptText("Forma de Pagamento");

        TextField statusField = new TextField();
        statusField.setPromptText("Status de Pagamento");

        TextField telefone_clienteField = new TextField();
        telefone_clienteField.setPromptText("Telefone");

        Button salvarBtn = new Button("Cadastrar Cliente");

        salvarBtn.setOnAction(e -> {
            try {
                String cpf = cpfField.getText();
                String nome = nomeField.getText();
                Float valor_compra = Float.valueOf(valor_compraField.getText());
                String forma_pag = forma_pagField.getText();
                String status = statusField.getText();
                String telefone_cliente = telefone_clienteField.getText();
                LocalDateTime dataCompra = LocalDateTime.now();

                Account account = new Account(
                        cpf,
                        nome,
                        valor_compra,
                        forma_pag,
                        status,
                        telefone_cliente,
                        dataCompra
                );
                for (Produtos produtos : listaProdutos) {
                    account.adicionarProdutos(produtos);
                }

                createAccount controller = new createAccount();
                controller.createaccount(account);

                listaProdutos.clear();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Cliente cadastrado com sucesso!");
                alert.show();

                cpfField.clear();
                nomeField.clear();
                valor_compraField.clear();
                forma_pagField.clear();
                statusField.clear();
                telefone_clienteField.clear();
                //dataCompraField.clear();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        VBox layout = new VBox(10, cpfField, nomeField, valor_compraField, forma_pagField, statusField, telefone_clienteField /*dataCompraField*/, salvarBtn);
        layout.setPadding(new Insets(20));

        return layout;
    }
}
