package Sala;

public class televisao {

    private int canal = 0;
    private int volume = 0;

    public void setCanal(int valor){
        this.canal = canal + valor;
    }

    public void setVolume(int valor) {
        this.volume = volume + valor;
    }

    public int getCanal() { return canal; }

    public int getVolume() { return volume; }
}
