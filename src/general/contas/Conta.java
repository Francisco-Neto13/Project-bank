package general.contas;

public class Conta {
    private String nomeCliente;
    private int numeroConta;
    private int numeroAgencia;
    private double saldoConta;
    private String dataAberturaConta;
    private static int totalContas = 0;

    public Conta(String nomeCliente, int numeroConta, int numeroAgencia, double saldoConta, String dataAberturaConta) {
        this.nomeCliente = nomeCliente;
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.saldoConta = saldoConta;
        this.dataAberturaConta = dataAberturaConta;
        totalContas++;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }

    public String getDataAberturaConta() {
        return dataAberturaConta;
    }

    public void setDataAberturaConta(String dataAberturaConta) {
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
        System.out.println("Seu rendimento é de R$" + String.format("%.2f", rendimento));
    }

    public void exibirInformacoes() {
        System.out.println("Nome do cliente: " + nomeCliente);
        System.out.println("Número da conta: " + numeroConta);
        System.out.println("Número da agência: " + numeroAgencia);
        System.out.println("Saldo da conta R$: " + saldoConta);
        System.out.println("Data de abertura da conta: " + dataAberturaConta);
    }

    public static int getTotalContas() {
        return totalContas;
    }
}
