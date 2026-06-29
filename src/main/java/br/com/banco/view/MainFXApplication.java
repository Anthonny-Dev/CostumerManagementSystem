package br.com.banco.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainFXApplication extends Application {

    @Override
    public void start(Stage stage) {

        TabPane tabPane = new TabPane();

        Tab cadastroTab = new Tab("Cadastro");
        cadastroTab.setContent(CadastroView.createPane());

        Tab crudTab = new Tab("CRUD");
        crudTab.setContent(CrudView.createPane());

        Tab listagemTab = new Tab("Listagem Completa");
        listagemTab.setContent(ListagemView.createPane());

        Tab ClientesDebTab = new Tab("Clientes em Débito");
        ClientesDebTab.setContent(ClientesDebView.createPane());

        tabPane.getTabs().addAll(cadastroTab, crudTab, listagemTab, ClientesDebTab);

        Scene scene = new Scene(tabPane, 800, 500);

        stage.setTitle("Gerenciador de Clientes");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}