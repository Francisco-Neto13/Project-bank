package general.contas;

import java.util.Scanner;

public class TelaDeContas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Evento evento = new Evento();
        ManipuladorDeContas manipulador = new ManipuladorDeContas();

        System.out.println("Digite o número da conta:");
        int numeroConta = 0;
        if (scanner.hasNextInt()) {
            numeroConta = scanner.nextInt();
        } else {
            System.out.println("Número da conta inválido.");
            return;
        }
        evento.setInt("numero", numeroConta);

        System.out.println("Digite o número da agência:");
        int numeroAgencia = 0;
        if (scanner.hasNextInt()) {
            numeroAgencia = scanner.nextInt();
        } else {
            System.out.println("Número da agência inválido.");
            return;
        }
        evento.setInt("agencia", numeroAgencia);

        scanner.nextLine();

        System.out.println("Digite o nome do titular:");
        String titular = scanner.nextLine();
        evento.setString("titular", titular);

        manipulador.criaConta(evento);

        System.out.println("Digite o valor a depositar:");
        double valorDeposito = 0;
        if (scanner.hasNextDouble()) {
            valorDeposito = scanner.nextDouble();
        } else {
            System.out.println("Valor de depósito inválido.");
            return;
        }
        evento.setDouble("valor", valorDeposito);
        manipulador.deposita(evento);

        System.out.println("Digite o valor a sacar:");
        double valorSaque = 0;
        if (scanner.hasNextDouble()) {
            valorSaque = scanner.nextDouble();
        } else {
            System.out.println("Valor de saque inválido.");
            return;
        }
        evento.setDouble("valor", valorSaque);
        manipulador.saca(evento);

        scanner.close();
    }
}
