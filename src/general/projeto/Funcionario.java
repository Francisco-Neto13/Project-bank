package general.projeto;

public class Funcionario	{
    protected String nome;
    protected String cpf;
    protected double salario;
    protected double bonificacao;
    protected int senha;

    protected String getNome() {
        return nome;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected String getCpf() {
        return cpf;
    }

    protected void setCpf(String cpf) {
        this.cpf = cpf;
    }

    protected double getSalario() {
        return salario;
    }

    protected void setSalario(double salario) {
        this.salario = salario;
    }

    protected void setSenha(int senha) {
        this.senha = senha;
    }
    protected int getSenha() {
        return senha;
    }
    protected double getBonificacao() {
        return this.salario * 0.1;
    }
}