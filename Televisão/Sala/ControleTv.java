package Sala;

import java.util.Scanner;

public class ControleTv implements Controle{

    private int valor = 0;
    private int valorAbsoluto = 0;

    @Override
    public void aumentar() {
        this.valor += 1;

    }

    @Override
    public void diminuir() {
        this.valor -= 1;

    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getValor() { return valor; }


    public void setValorAbsoluto(int valorAbsoluto) { this.valorAbsoluto = valorAbsoluto; }

    public int getValorAbsoluto() { return valorAbsoluto; }
}
