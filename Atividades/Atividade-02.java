import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conta {
    private String nome;
    private int numero;
    private int agencia;
    private double saldo;
    private Date dataAbertura;
    private static int proximoIdentificador = 1;
    private int identificador;

    public Conta(String nome, int numero, int agencia, double saldo, String dataAbertura) {
        this.nome = nome;
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
        if (validarData(dataAbertura)) {
            this.dataAbertura = converterData(dataAbertura);
        } else {
            System.out.println("Data de abertura inválida!");
        }
        this.identificador = proximoIdentificador++;
    }

    private boolean validarData(String data) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            sdf.parse(data);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private Date converterData(String data) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void depositar(Double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " foi adicionado a conta. Novo saldo: R$" + saldo);
        } else {
            System.out.println("Depósito inválido, insira um valor acima de R$0!");
        }
    }

    public void sacar(Double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Foram retirados R$" + valor);
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void calcularRendimentos() {
        double rendimento = saldo * 0.1;
        System.out.println("Seu rendimento é de R$" + rendimento);
    }

    public void exibirInformacoes() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Nome: " + nome);
        System.out.println("Número: " + numero);
        System.out.println("Agência: " + agencia);
        System.out.println("Saldo R$: " + saldo);
        System.out.println("Data de abertura: " + sdf.format(dataAbertura));
        System.out.println("Identificador: " + identificador);
    }

    public static void main(String[] args) {
        Conta contaFrancisco = new Conta("Francisco", 1234567, 7005, 500, "13/08/2024");
        contaFrancisco.depositar(100.00);
        contaFrancisco.calcularRendimentos();
        contaFrancisco.exibirInformacoes();

        Conta contaLuisa = new Conta("Luisa", 678978, 9018, 800, "15/01/2024");
        contaLuisa.depositar(100.00);
        contaLuisa.calcularRendimentos();
        contaLuisa.exibirInformacoes();
    }
}