package general.contas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;



public class ContaWindow extends JFrame {
    private JTextField agenciaField, numeroField, titularField, saldoField, valorField;
    private double saldoAtual;
    private Map<String, Conta> contas;

    public ContaWindow() {
        super("Conta Bancária");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        contas = new HashMap<>();
        System.out.println("Diretório atual: " + System.getProperty("user.dir"));
        carregarContas();

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);


        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(new JLabel("Agência:"), constraints);
        constraints.gridx = 1;
        constraints.gridy = 0;
        agenciaField = new JTextField(15);
        panel.add(agenciaField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(new JLabel("Número:"), constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        numeroField = new JTextField(15);
        panel.add(numeroField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(new JLabel("Titular:"), constraints);
        constraints.gridx = 1;
        constraints.gridy = 2;
        titularField = new JTextField(15);
        panel.add(titularField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(new JLabel("Saldo:"), constraints);
        constraints.gridx = 1;
        constraints.gridy = 3;
        saldoField = new JTextField(15);
        saldoField.setEditable(false);
        panel.add(saldoField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        JButton criarContaButton = new JButton("Criar Conta");
        criarContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String agencia = agenciaField.getText();
                String numero = numeroField.getText();
                String titular = titularField.getText();

                if (agencia.isEmpty() || numero.isEmpty() || titular.isEmpty()) {
                    JOptionPane.showMessageDialog(ContaWindow.this, "Preencha todos os campos para criar a conta.");
                    return;
                }

                if (agencia.length() != 4) {
                    JOptionPane.showMessageDialog(ContaWindow.this, "Agência inválida. Deve conter 4 dígitos.");
                    return;
                }

                if (numero.length() != 6) {
                    JOptionPane.showMessageDialog(ContaWindow.this, "Número de conta inválido. Deve conter 6 dígitos.");
                    return;
                }

                if (!titular.matches("[a-zA-Z ]+")) {
                    JOptionPane.showMessageDialog(ContaWindow.this, "Nome do titular inválido. Deve conter apenas letras.");
                    return;
                }

                String chave = agencia + numero;
                if (contas.containsKey(chave)) {
                    JOptionPane.showMessageDialog(ContaWindow.this, "Conta já existe.");
                    return;
                }

                Conta novaConta = new Conta(titular, Integer.parseInt(numero), Integer.parseInt(agencia), 0.0, "data");
                contas.put(chave, novaConta);
                saldoAtual = 0.0;
                saldoField.setText(String.valueOf(saldoAtual));
                JOptionPane.showMessageDialog(ContaWindow.this, "Conta criada com sucesso!");
            }
        });

        panel.add(criarContaButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        panel.add(new JLabel("Valor:"), constraints);
        constraints.gridx = 1;
        constraints.gridy = 5;
        valorField = new JTextField(15);
        panel.add(valorField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 1;
        JButton depositarButton = new JButton("Depositar");
        depositarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valor = valorField.getText();
                if (valor.isEmpty()) {
                    JOptionPane.showMessageDialog(ContaWindow.this, "Informe um valor para depositar.");
                    return;
                }
                double valorDeposito = Double.parseDouble(valor);
                saldoAtual += valorDeposito;
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        saldoField.setText(String.valueOf(saldoAtual));
                    }
                });
                JOptionPane.showMessageDialog(ContaWindow.this, "Valor depositado: " + valor);
            }
        });


        panel.add(depositarButton, constraints);

        constraints.gridx = 1;
        constraints.gridy = 6;
        JButton sacarButton = new JButton("Sacar");
        sacarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valor = valorField.getText();
                if (valor.isEmpty()) {
                    JOptionPane.showMessageDialog(ContaWindow.this, "Informe um valor para sacar.");
                    return;
                }
                double valorSaque = Double.parseDouble(valor);
                if (valorSaque > saldoAtual) {
                    JOptionPane.showMessageDialog(ContaWindow.this, "Saque indisponível. Saldo insuficiente.");
                    return;
                }
                saldoAtual -= valorSaque;
                saldoField.setText(String.valueOf(saldoAtual));
                JOptionPane.showMessageDialog(ContaWindow.this, "Valor sacado: " + valor);
            }
        });
        panel.add(sacarButton, constraints);



        constraints.gridx = 2;
        constraints.gridy = 6;
        JButton exibirContasButton = new JButton("Exibir Contas");
        exibirContasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirContas();
            }
        });
        panel.add(exibirContasButton, constraints);


        add(panel);
        pack();
        setVisible(true);
    }

    public void exibirContas() {
        for (Map.Entry<String, Conta> entry : contas.entrySet()) {
            String chave = entry.getKey();
            Conta conta = entry.getValue();
            System.out.println("Chave: " + chave);
            System.out.println("Agência: " + conta.getNumeroAgencia());
            System.out.println("Número: " + conta.getNumeroConta());
            System.out.println("Titular: " + conta.getNomeCliente());
            System.out.println("Saldo: " + conta.getSaldoConta());
            System.out.println("Data de Abertura: " + conta.getDataAberturaConta());
            System.out.println("--------------------------");
        }
    }

    public static void main(String[] args) {
        new ContaWindow();
    }

    private void carregarContas() {
        contas = new HashMap<>();
        String filePath = System.getProperty("user.dir") + File.separator + "contas.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String chave = parts[0];
                String titular = parts[1];
                int numero = Integer.parseInt(parts[2]);
                int agencia = Integer.parseInt(parts[3]);
                double saldo = Double.parseDouble(parts[4]);
                String dataAbertura = parts[5];
                Conta conta = new Conta(titular, numero, agencia, saldo, dataAbertura);
                contas.put(chave, conta);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar contas: " + e.getMessage());
        }
    }


}
