package Sala;

import java.util.Scanner;

public class Sala {

    public static void main(String[] args){

        televisao televisao;
        ControleTv controle;
        int t = 0;
        Scanner sr = new Scanner(System.in);
        televisao = new televisao();
        controle  = new ControleTv();
    
        while (t == 0){
        	try {
        		System.out.println("\nA tv esta ligada no canal " + televisao.getCanal() + " no volume " + televisao.getVolume());
                System.out.println("O que deseja fazer?\n");

                System.out.println("1. Trocar de canal.\n2.mudar o volume.\n3.Desligar a TV.");
                int x = sr.nextInt();

                if(x == 1){
                    System.out.println("Deseja passar em um o canal ou voltar em um canal?");
                    System.out.println("1.Passar\n2.voltar.\n3.Escolher o canal");

                    int y = sr.nextInt();

                    if(y == 1){
                        controle.aumentar();
                        televisao.setCanal(controle.getValor());
                        controle.setValor(0);

                    }
                    if(y == 2){
                        if(televisao.getCanal() <= 0){
                            System.out.println("Não há canais abaixo do 0");
                        }else {
                            controle.diminuir();
                            televisao.setCanal(controle.getValor());
                            controle.setValor(0);
                        }
                    }
                    if(y == 3){
                        System.out.println("Digite o numero do canal que voce quer assistir:");
                        int z = sr.nextInt();
                        controle.setValorAbsoluto(z);
                        televisao.setCanal(controle.getValorAbsoluto());
                    }
                    if( y != 1 && y !=2 && y != 3){
                        System.out.println("Selecione somente 1 ou 2\n");
                    }


                    }
                if(x == 2){

                    System.out.println("Deseja aumentar o volume em 1 ou diminuir o volume em 1?");
                    System.out.println("1.Aumentar\n2.Diminuir");

                    int y = sr.nextInt();

                    if(y == 1){
                        if(televisao.getVolume() == 100){
                            System.out.println("Não é possivel aumentar o volume");
                        } else{
                            controle.aumentar();
                            televisao.setVolume(controle.getValor());
                            controle.setValor(0);

                        }
                    }
                    if( y == 2){
                        if(televisao.getVolume() == 0){
                            System.out.println("Não é possivel diminuir o volume ");
                        } else{
                            controle.diminuir();
                            televisao.setVolume(controle.getValor());
                            controle.setValor(0);

                        }

                    }if(y != 1 && y != 2){
                        System.out.println("Selecione somente 1 ou 2");
                    }


                }
                    if (x == 3) {
                        System.out.println("Desligando Tv");
                        t += 1;
                    }
        	}catch(Exception x) {
        		System.out.println("Voce digitou valores imcompativeis, tente novamente.");
        		sr.nextLine();
        	}
        }
    }
}