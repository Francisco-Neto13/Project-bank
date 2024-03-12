public class Main {
    public static void main(String[] args) {

        Conta contaLuisa = new Conta("Luisa", 987654, 1234, 1500, "15/01/2023");

        Conta contaFrancisco = new Conta("Francisco", 145678, 3451, 1234, "13/08/2023");

        System.out.println("Total de contas criadas: " + Conta.getTotalContas());

        System.out.println("Nome do titular: " + contaLuisa.nomeCliente);
        contaLuisa.depositar(2715.00);
        contaLuisa.calcularRendimentos();
        contaLuisa.exibirInformacoes();
        contaLuisa.sacar(500); // Simula um saque de R$ 500
        contaLuisa.exibirInformacoes(); // Exibe as informações atualizadas após o saque

        System.out.println("Nome do titular: " + contaFrancisco.nomeCliente);
        contaFrancisco.depositar(2713.00);
        contaFrancisco.calcularRendimentos();
        contaFrancisco.exibirInformacoes();
        contaFrancisco.sacar(250);
        contaFrancisco.exibirInformacoes();
    }
}
