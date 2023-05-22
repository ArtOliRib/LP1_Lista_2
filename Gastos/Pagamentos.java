package Gastos;

import javax.swing.JOptionPane;
import java.util.Locale;

public class Pagamentos {

    public static void main (String[] args) {
        try {
            Locale.setDefault(Locale.US);
            
            char c;

            c = JOptionPane.showInputDialog("Voce deseja realizar o pagamento em cartao de credito (digite 'c'), ou com transferencia bancaria (digite 't'), ou com boleto bancario (digite 'b'), ou deseja encerrar o programa (digite 'e'): ").charAt(0);

            if (c == 'c') {
                Cartao_de_Credito cartao = new Cartao_de_Credito();
                cartao.realizarPagamento();
                cartao.gerarRecibo();
            } else if (c == 't') {
                Transferencia_Bancaria transf = new Transferencia_Bancaria();
                transf.realizarPagamento();
                transf.gerarRecibo();
            } else if (c == 'b') {
                Boleto_Bancario boleto = new Boleto_Bancario();
                boleto.realizarPagamento();
                boleto.gerarRecibo();
            }

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "O erro eh esse: " + erro);

        }
    }
}
