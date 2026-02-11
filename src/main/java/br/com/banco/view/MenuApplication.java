package br.com.banco.view;

import br.com.banco.controller.createAccount;
import br.com.banco.model.Account;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MenuApplication {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("------------------------------------");
            System.out.println("SISTEMA DE GERENCIAMENTO DE CLIENTES");
            System.out.println("------------------------------------");
            System.out.println("0 - EXCLUIR CLIENTES PARA TESTES");
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

                    if(cpf.equals(null)){
                        System.out.println("Valor Inválido!\n");

                        System.out.print("Client CPF: ");
                        cpf = scanner.nextLine();
                    }

//                  -----------------------------------------------------------------

                    System.out.print("Client Name: ");
                    String name = scanner.nextLine();

                    if(name.equals(null) || name.isEmpty()){
                        System.out.println("Valor Inválido!\n");

                        System.out.print("Client Name: ");
                        name = scanner.nextLine();
                    }

//                  -----------------------------------------------------------------

                    System.out.print("Valor da Compra R$ ");
                    float valor_compra = scanner.nextFloat();
                    scanner.nextLine();


                    if (valor_compra <= 0){
                        System.out.println("Valor inválido!\nTente Novamente");

                        System.out.print("Valor da Compra R$ ");
                        valor_compra = scanner.nextFloat();
                        scanner.nextLine();
                    }

//                  -----------------------------------------------------------------

                    System.out.print("Forma de pagamento: ");
                    String forma_pag = scanner.nextLine();

                    if(forma_pag.equals(null)){
                        System.out.println("Valor Inválido!\n");

                        System.out.print("Forma de pagamento: ");
                        forma_pag = scanner.nextLine();
                    }

//                  -----------------------------------------------------------------

                    System.out.print("Status do Cliente: ");
                    String status = scanner.nextLine();

                    if(status.equals(null)){
                        System.out.println("Valor Inválido!\n");

                        System.out.print("Status do Cliente: ");
                        status = scanner.nextLine();
                    }

//                  -----------------------------------------------------------------

                    System.out.print("Telefone do Cliente: ");
                    String telefone_cliente = scanner.nextLine();

                    while (telefone_cliente.equals(null) || telefone_cliente.isEmpty() || telefone_cliente.length()< 11){
                        System.out.println("valor Inválido!\nTente Novamente.");

                        System.out.print("Telefone do Cliente: ");
                        telefone_cliente = scanner.nextLine();
                    }

//                  -----------------------------------------------------------------
                    // aqui setamos a data antes de instanciar o novo objeto, pois a data só pode ser instanciada depois da criacao do objeto
                    LocalDateTime dataCompra = LocalDateTime.now();
                    Account novaconta = new Account(0, cpf, name, valor_compra, forma_pag, status, telefone_cliente, dataCompra);
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


                case 0:
                    new ShowTables().deletarClientesTeste();
                    break;

                default:
                    System.out.println("Opção inválida!\n");
            }

        } while (choice != 5);

        scanner.close();
    }
}
