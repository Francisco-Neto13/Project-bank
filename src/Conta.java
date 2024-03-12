public class Conta {
    private String nomeCliente;
    private int numeroConta;
    private int numeroAgencia;
    private double saldoConta;
    private String dataAberturaConta;

    public Conta(String nomeCliente, int numeroConta, int numeroAgencia, double saldoConta, String dataAberturaConta) {
        this.nomeCliente = nomeCliente;
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.saldoConta = saldoConta;
        this.dataAberturaConta = dataAberturaConta;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldoConta += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso. Novo saldo: R$" + saldoConta);
        } else {
            System.out.println("Depósito inválido. Insira um valor acima de R$0!");
        }
    }

    public void sacar(double valor) {
        if (valor <= saldoConta) {
            saldoConta -= valor;
            System.out.println("Foram sacados R$" + valor);
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void calcularRendimentos() {
        double rendimento = saldoConta * 0.1;
        System.out.println("Seu rendimento é de R$" + rendimento);
    }

    public void exibirInformacoes() {
        System.out.println("Nome do cliente: " + nomeCliente);
        System.out.println("Número da conta: " + numeroConta);
        System.out.println("Número da agência: " + numeroAgencia);
        System.out.println("Saldo da conta R$: " + saldoConta);
        System.out.println("Data de abertura da conta: " + dataAberturaConta);
    }

    public static void main(String[] args) {
        Conta contaLuisa = new Conta("Luisa", 987654, 1234, 1500, "03/12/2023");
        contaLuisa.depositar(2715.00);
        contaLuisa.calcularRendimentos();
        contaLuisa.exibirInformacoes();
    }
}
