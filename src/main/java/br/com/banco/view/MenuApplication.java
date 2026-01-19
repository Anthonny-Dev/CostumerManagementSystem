package br.com.banco.view;

import br.com.banco.controller.createAccount;
import br.com.banco.model.Account;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuApplication {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("------------------------------------");
            System.out.println("SISTEMA DE GERENCIAMENTO DE CLIENTES");
            System.out.println("------------------------------------");
            System.out.println("1 - ADICIONAR UM NOVO CLIENTE");
            System.out.println("2 - MOSTRAR TODOS OS CLIENTES");
            System.out.println("3 - ACESSAR CLIENTES EM DÉBITO");
            System.out.println("4 - BUSCAR CLIENTES");
            System.out.println("5 - SAIR DO SISTEMA");
            System.out.print("\nESCOLHA UMA OPÇÃO: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Client CPF: ");
                    String cpf = scanner.nextLine();

                    System.out.print("Client Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Valor da Compra R$ ");
                    float valor_compra = scanner.nextFloat();
                    scanner.nextLine();

                    System.out.print("Forma de pagamento: ");
                    String forma_pag = scanner.nextLine();

                    System.out.print("Status do Cliente: ");
                    String status = scanner.nextLine();

                    Account novaconta = new Account(0, cpf, name, valor_compra, forma_pag, status);
                    createAccount dao = new createAccount();
                    dao.createaccount(novaconta);
                    break;

                case 2:
                    new ShowTables().mostrarClientes();
                    break;

                case 3:
                    new ShowTables().mostrarClientesDebito();
                    break;

                case 4:
                    new ShowTables().buscarCliente();
                    break;

                case 5:
                    System.out.println("Saindo do Programa...");
                    break;

                default:
                    System.out.println("Opção inválida!\n");
            }

        } while (choice != 5);

        scanner.close();
    }
}
