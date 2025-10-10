package Hilos;

import Juego.Juego;

public class HiloJugador extends Thread{
    
    protected Juego juego;

    public HiloJugador(Juego juego){
        this.juego = juego;
    }

    public void run(){
        while(true){
            juego.mover_jugador();
            try {
                sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
