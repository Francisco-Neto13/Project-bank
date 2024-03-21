package general.contas;

public class ManipuladorDeContas {
    private Conta conta;

    public void criaConta(Evento evento) {
        int numeroConta = evento.getNumero();
        int numeroAgencia = evento.getAgencia();
        String titular = evento.getTitular();
        conta = new Conta(titular, numeroConta, numeroAgencia, 0, "");
    }

    public void deposita(Evento evento) {
        double valor = evento.getValor();
        conta.depositar(valor);
    }

    public void saca(Evento evento) {
        double valor = evento.getValor();
        conta.sacar(valor);
    }
}
