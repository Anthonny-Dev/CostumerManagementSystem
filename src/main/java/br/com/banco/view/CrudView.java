package br.com.banco.view;

import br.com.banco.model.Account;
import br.com.banco.view.ShowTables;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.util.List;

public class CrudView {

    public static VBox createPane() {

        TextField idField = new TextField();
        idField.setPromptText("ID do Cliente");

        Button buscarBtn = new Button("Buscar");
        Button deletarBtn = new Button("Deletar");
        Button buscarClienteEmDebito = new Button("Buscar Cliente em Débito");

        buscarBtn.setOnAction(e -> {
            ShowTables controller = new ShowTables();
            controller.buscarCliente(Integer.parseInt(idField.getText()));
        });

        deletarBtn.setOnAction(e -> {
            ShowTables controller = new ShowTables();
            controller.deletarClienteEspecifico(Integer.parseInt(idField.getText()));
        });

        buscarClienteEmDebito.setOnAction(event -> {
            ShowTables controller = new ShowTables();
            controller.mostrarClientesDebito();

        });

        VBox layout = new VBox(10, idField, buscarBtn, deletarBtn, buscarClienteEmDebito);
        layout.setPadding(new Insets(20));

        return layout;
    }
}