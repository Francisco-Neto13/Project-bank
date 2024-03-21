package general.projeto;

import general.contas.Conta;

public class Main {
    public static void main(String[] args) {
        Conta contaLuisa = criarConta("Luisa", 987654, 1234, 1500, "15/01/2023");
        Conta contaFrancisco = criarConta("Francisco", 145678, 3451, 1234, "13/08/2023");

        exibirTotalContasCriadas();

        operacoesConta(contaLuisa, 2715.00, 500);
        operacoesConta(contaFrancisco, 2713.00, 250);

        ControleDeBonificacoes controle = new ControleDeBonificacoes();
        realizarOperacoesFuncionario(controle);
    }

    private static Conta criarConta(String nomeCliente, int numeroConta, int agencia, double saldo, String dataAbertura) {
        Conta conta = new Conta(nomeCliente, numeroConta, agencia, saldo, dataAbertura);
        System.out.println("Conta criada para " + nomeCliente);
        return conta;
    }

    private static void exibirTotalContasCriadas() {
        System.out.println("Total de contas criadas: " + Conta.getTotalContas());
    }

    private static void operacoesConta(Conta conta, double valorDeposito, double valorSaque) {
        System.out.println("Nome do titular: " + conta.getNomeCliente());
        conta.depositar(valorDeposito);
        conta.calcularRendimentos();
        conta.exibirInformacoes();
        conta.sacar(valorSaque);
        conta.exibirInformacoes();
    }

    private static void realizarOperacoesFuncionario(ControleDeBonificacoes controle) {
        Gerente gerente = criarGerente("Lucas Zonzini Lisboa", 5000.0, 4002);
        Funcionario funcionario = criarFuncionario("José Nogueira", 1000.0, 8821);

        controle.registra(gerente);
        controle.registra(funcionario);

        System.out.println("Senha do gerente: " + gerente.getSenha());
        System.out.println("Bonificação do gerente: " + gerente.getBonificacao());

        System.out.println("Senha do funcionário: " + funcionario.getSenha());
        System.out.println("Bonificação do funcionário: " + funcionario.getBonificacao());

        System.out.println("Total de bonificações: " + controle.getTotalDeBonificacoes());
    }


    private static Gerente criarGerente(String nome, double salario, int senha) {
        Gerente gerente = new Gerente();
        gerente.setNome(nome);
        gerente.setSalario(salario);
        gerente.setSenha(senha);
        return gerente;
    }

    private static Funcionario criarFuncionario(String nome, double salario, int senha) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setSalario(salario);
        funcionario.setSenha(senha);
        return funcionario;
    }
}



