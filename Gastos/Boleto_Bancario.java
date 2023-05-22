package Gastos;

import javax.swing.*;

public class Boleto_Bancario implements iPagamento{

    private float valor;

    public void realizarPagamento () {

        float pagamento = Float.parseFloat(JOptionPane.showInputDialog("Digite, em reais e com ponto ao inves de virgula, o valor que voce deseja realizar o pagamento no boleto: "));

        this.valor = pagamento;

    }
    public void gerarRecibo () {

        System.out.println(String.format("O pagamento de R$%.2f foi realizado pelo boleto bancario!", this.valor));

    }

}