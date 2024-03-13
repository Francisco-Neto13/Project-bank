public class Main {
    public static void main(String[] args) {

        Conta contaLuisa = new Conta("Luisa", 987654, 1234, 1500, "15/01/2023");

        Conta contaFrancisco = new Conta("Francisco", 145678, 3451, 1234, "13/08/2023");

        Gerente	gerente	= new Gerente();

        gerente.setNome("Lucas Zonzini Lisboa");
        gerente.setSenha(4002);


        System.out.println("Total de contas criadas: " + Conta.getTotalContas());

        System.out.println("Nome do titular: " + contaLuisa.nomeCliente);
        contaLuisa.depositar(2715.00);
        contaLuisa.calcularRendimentos();
        contaLuisa.exibirInformacoes();
        contaLuisa.sacar(500);
        contaLuisa.exibirInformacoes();

        System.out.println("Nome do titular: " + contaFrancisco.nomeCliente);
        contaFrancisco.depositar(2713.00);
        contaFrancisco.calcularRendimentos();
        contaFrancisco.exibirInformacoes();
        contaFrancisco.sacar(250);
        contaFrancisco.exibirInformacoes();

        System.out.println("Bonificação" + gerente.getBonificacao());

    }

}



