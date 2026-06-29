package br.com.banco.view;


import br.com.banco.model.Account;
import br.com.banco.view.ShowTables;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.time.LocalDateTime;
import java.util.List;

public class ClientesDebView {

    public static VBox createPane() {

        TableView<Account> table = new TableView<>();

        TableColumn<Account, Integer> idClientCol = new TableColumn<>("ID");
        idClientCol.setCellValueFactory(new PropertyValueFactory<>("idClient"));

        TableColumn<Account, String> cpfCol = new TableColumn<>("CPF");
        cpfCol.setCellValueFactory(new PropertyValueFactory<>("cpf"));

        TableColumn<Account, String> nomeCol = new TableColumn<>("Nome");
        nomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<Account, Float> valor_compraCol = new TableColumn<>("Valor Total da Compra");
        valor_compraCol.setCellValueFactory(new PropertyValueFactory<>("valor_compra"));

        TableColumn<Account, String> forma_pagCol = new TableColumn<>("Forma de Pagamento");
        forma_pagCol.setCellValueFactory(new PropertyValueFactory<>("forma_pag"));

        TableColumn<Account, String> statusCol = new TableColumn<>("Status do Cliente");
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        TableColumn<Account, String> telefone_clienteCol = new TableColumn<>("Telefone");
        telefone_clienteCol.setCellValueFactory(new PropertyValueFactory<>("telefone_cliente"));

        TableColumn<Account, LocalDateTime> dataCompraCol = new TableColumn<>("Data da Compra");
        dataCompraCol.setCellValueFactory(new PropertyValueFactory<>("dataCompra"));

        table.getColumns().addAll(idClientCol, cpfCol, nomeCol, valor_compraCol, forma_pagCol, statusCol, telefone_clienteCol, dataCompraCol);

        Button atualizarBtn = new Button("Atualizar Tabela");

        atualizarBtn.setOnAction(e -> {
            ShowTables controller = new ShowTables();
            List<Account> lista = controller.mostrarClientesDebito(); // metodo deveria retornar uma tabela somente com os clientes em débito

            ObservableList<Account> dados = FXCollections.observableArrayList(lista);
            table.setItems(dados);
        });

        VBox layout = new VBox(10, atualizarBtn, table);
        layout.setPadding(new Insets(20));

        return layout;
    }
}
