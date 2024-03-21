package general.contas;

import java.util.HashMap;
import java.util.Map;

public class ContasManager {
    private Map<String, Conta> contas;

    public ContasManager() {
        this.contas = new HashMap<>();
    }
    public boolean adicionarConta(String chave, Conta conta) {
        if (contas.containsKey(chave)) {
            return false;
        }
        contas.put(chave, conta);
        return true;
    }

    public boolean verificarContaExistente(String chave) {
        return contas.containsKey(chave);
    }
}
