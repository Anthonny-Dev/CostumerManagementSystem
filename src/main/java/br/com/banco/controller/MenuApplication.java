package br.com.banco.controller;

import br.com.banco.view.ShowTables;
import br.com.banco.model.Account;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuApplication {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------------------------\nSISTEMA DE GERENCIAMENTO DE CLIENTES\n----------------------------------\n1 - CREATE A NEW CLIENT\n2- SHOW ALL CLIENTS\n3 - EXIT SYSTEM\n Choice a Option:");

        int choice = scanner.nextInt();

        switch (choice){
            // Esse é o menu principal da aplicação
            case 1:
                // vamos inicializar o metodo Scanner e armazenar seus inputs em variáveis exatamente iguais as do BD MySQL pra que não ocorra erros de interferencia.
                Scanner sc = new Scanner(System.in);

                System.out.println("Client CPF: ");
                String cpf = sc.nextLine();

                System.out.println("Client Name: ");
                String name = sc.nextLine();

                System.out.println("Valor da Compra R$ ");
                float valor_compra = sc.nextFloat();

                sc.nextLine();

                System.out.println("Forma de pagamento: ");
                String forma_pag = sc.nextLine();

                // we create a variable type 'Account' for storage the value of the inputs in a new account
                // criamos uma váriavel do tipo 'Account' para armazenar o valor dos inputs em uma nova conta
                Account novaconta = new Account(0, cpf, name, valor_compra, forma_pag);

                // we create a temporary variable for create a new instance from createAccount class
                // criamos uma variável temporária para criar uma nova instancia da classe createAccount
                createAccount dao = new createAccount();

                // we create the account, following the logic's method: createaccount from createAccount class
                // criamos de fato a conta, seguindo a lógica do METODO: createaccount da CLASSE: createAccount
                dao.createaccount(novaconta);

                break;
            case 2:
                ShowTables mostrarclientes = new ShowTables();
                mostrarclientes.mostrarClientes();
                break;

            case 3:
                System.out.println("Saindo do Programa...");
                break;
            default:
                System.out.println("Tente Novamente.\n");

        }
    }
}
