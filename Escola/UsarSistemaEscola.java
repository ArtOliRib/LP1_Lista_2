package Escola;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class UsarSistemaEscola {

    public static void main (String[] args) {

        try {

            int escolha;

            SistemaEscola escola = new SistemaEscola();
            SistemaEscola.Turma nonoAno = escola.turmai();

            nonoAno.addAlunos();

            do {
               escolha = nonoAno.menu();

               if (escolha == 0)
                   JOptionPane.showMessageDialog(null, "O programa esta encerrado!");

            } while (escolha != 0);


        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "O erro foi esse: " + erro);
        }

       /* ArrayList<Integer> x = new ArrayList();
        x.add(1);
        x.add(2);

        for (int xxx : x) {
            JOptionPane.showMessageDialog(null, "é " + xxx);
        } */

    }

}
