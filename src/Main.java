import model.Cliente;
import model.Servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.math.BigDecimal;

public class Main {
    private static final List<Cliente> clientes = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);
    private static int proximoIdCliente = 1;
    private static final List<Servico> servicos = new ArrayList<>();
    private static int proximoIdServico = 1;

    public static void main(String[] args) {
        int opcao;

        do {
            mostrarMenu();

            opcao = lerInteiro("Escolha: ", 0);

            switch (opcao) {
                case 1 -> cadastrarCliente();
                case 2 -> listarClientes();
                case 3 -> cadastrarServico();
                case 4 -> listarServicos();
                case 0 -> System.out.println("Fechando...");
                default -> System.out.println("Opção Inválida!");
            }
        } while (opcao != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n*** Salão ***");
        System.out.println("1 - Cadastrar Cliente.");
        System.out.println("2 - Listar Clientes.");
        System.out.println("3 - Cadastrar Serviço.");
        System.out.println("4 - Listar Serviços.");
        System.out.println("0 - Sair.");
    }

    private static void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Telefone: ");
        String telefone = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        Cliente cliente = new Cliente(proximoIdCliente, nome, telefone, email);
        clientes.add(cliente);
        proximoIdCliente++;

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

    private static int lerInteiro(String mensagem, int minimo) {
        while (true) {
            System.out.print(mensagem);
            try {
                int valor = Integer.parseInt(sc.nextLine());
                if (valor >= minimo) {
                    return valor;
                } else {
                    System.out.println("[ERRO] O valor deve ser no mínimo " + minimo + "!");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERRO] Digite apenas números inteiros válidos!");
            }
        }
    }

    private static BigDecimal lerPreco(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                String entrada = sc.nextLine().replace(",", ".");
                BigDecimal preco = new BigDecimal(entrada);
                if (preco.compareTo(BigDecimal.ZERO) > 0) {
                    return preco;
                } else {
                    System.out.println("[ERRO] O preço deve ser maior que zero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERRO] Digite um valor válido, como 80.00");
            }
        }
    }

    private static void cadastrarServico() {
        System.out.print("Nome do serviço: ");
        String nome = sc.nextLine();
        BigDecimal preco = lerPreco("Preço (ex: 80.00): ");
        int duracao = lerInteiro("Duração em minutos: ", 1);

        Servico servico = new Servico(proximoIdServico, nome, preco, duracao);
        servicos.add(servico);
        proximoIdServico++;

        System.out.println("Serviço Cadastrado: " + servico);
    }

    private static void listarServicos() {
        if (servicos.isEmpty()) {
            System.out.println("Nenhum serviço cadastrado!");
            return;
        }
        for (Servico s : servicos) {
            System.out.println(s);
        }
    }
}