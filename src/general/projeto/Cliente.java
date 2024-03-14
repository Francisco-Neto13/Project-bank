package general.projeto;

class Cliente {
    private String nome;
    private String endereco;
    private String cpf;
    private int idade;

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void mudaCPF(String cpf) {
        if (this.idade <= 60) {
            validaCPF(cpf);
        }
        this.cpf = cpf;
    }

    private void validaCPF(String cpf) {

    }
}
