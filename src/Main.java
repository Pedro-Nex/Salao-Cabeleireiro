import model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Cliente> clientes = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);
    private static int proximoId = 1;

    public static void main(String[] args) {
        int opcao;

        do {
            mostrarMenu();

            try {
                opcao = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\n[ERRO] Digite apenas números válidos!");
                opcao = -1;
            }

            switch (opcao) {
                case 1 -> cadastrarCliente();
                case 2 -> listarClientes();
                case 0 -> System.out.println("Fechando...");
                default -> {
                    if (opcao != -1) {
                        System.out.println("Opção Inválida!");
                    }
                }
            }
        } while (opcao != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n*** Salão ***");
        System.out.println("1 - Cadastrar Cliente.");
        System.out.println("2 - Listar Clientes.");
        System.out.println("0 - Sair.");
        System.out.print("Escolha: ");
    }

    private static void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Telefone: ");
        String telefone = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        Cliente cliente = new Cliente(proximoId, nome, telefone, email);
        clientes.add(cliente);
        proximoId++;

        System.out.println("Cliente Cadastrado: " + cliente);
    }

    private static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado!");
            return;
        }
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }
}