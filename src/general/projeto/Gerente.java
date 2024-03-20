package general.projeto;

import general.projeto.Funcionario;

public class Gerente extends Funcionario {
    private int	numeroDeFuncionariosGerenciados;

    public	boolean	autentica(int senha) {
        if	(this.senha	== senha)	{
            System.out.println("Acesso	Permitido!");
            return true;
        }	else	{
            System.out.println("Acesso	Negado!");
            return false;
        }
    }

    @Override
    public	double	getBonificacao() {
        return this.salario	*	0.15;
    }
}
