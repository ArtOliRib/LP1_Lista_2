package Gastos;

import javax.swing.*;

public class Cartao_de_Credito implements iPagamento{

    private float valor;

    public void realizarPagamento () {

        float pagamento = Float.parseFloat(JOptionPane.showInputDialog("Digite, em reais e com ponto ao inves de virgula, o valor que voce deseja realizar a transaçao no cartao: "));

        this.valor = pagamento;

    }
    public void gerarRecibo () {

        System.out.println(String.format("O pagamento de R$%.2f foi realizado pelo cartao de credito!", this.valor));

    }

}
