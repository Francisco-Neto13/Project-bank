package general.contas;

public class Evento {
    private int numero;
    private int agencia;
    private String titular;
    private double valor;

    public void setInt(String campo, int valor) {
        if ("numero".equals(campo)) {
            this.numero = valor;
        } else if ("agencia".equals(campo)) {
            this.agencia = valor;
        }
    }

    public void setString(String campo, String valor) {
        if ("titular".equals(campo)) {
            this.titular = valor;
        }
    }

    public void setDouble(String campo, double valor) {
        if ("valor".equals(campo)) {
            this.valor = valor;
        }
    }

    public int getNumero() {
        return numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public String getTitular() {
        return titular;
    }

    public double getValor() {
        return valor;
    }
}
