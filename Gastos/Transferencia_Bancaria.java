package Gastos;

import javax.swing.*;

public class Transferencia_Bancaria implements iPagamento{

    private float valor;

    public void realizarPagamento () {

        float pagamento = Float.parseFloat(JOptionPane.showInputDialog("Digite, em reais e com ponto ao inves de virgula, o valor que voce deseja realizar a transferencia bancaria: "));

        this.valor = pagamento;

    }
    public void gerarRecibo () {

        System.out.println(String.format("O pagamento de R$%.2f foi realizado pela Transferencia Bancaria!", this.valor));

    }

}