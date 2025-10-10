package EstadoDireccion;

import Grafica.ConstantesTeclado;
import Vehiculos.Jugador;

public class EstadoDireccion {
    protected Jugador jugador;
    protected int [] deriva_x;
    protected int [] deriva_y;
    protected int direccion_en_grados;
    
    public EstadoDireccion(Jugador jugador){
        this.jugador = jugador;
        this.deriva_x = new int [] {+3, +5, +0, -5, -5};
        this.deriva_y = new int [] {+3, +3, +5, +3, +3};
        this.direccion_en_grados = 90; //Adelante
    }

    public void cambiar_direccion(int direccion){
        if (direccion == ConstantesTeclado.DERECHA){
            direccion_en_grados -=30;
            direccion_en_grados = (direccion_en_grados == 0 ? 30 : direccion_en_grados);
        }else{
            if (direccion == ConstantesTeclado.IZQUIERDA){
                direccion_en_grados +=30;
                direccion_en_grados = (direccion_en_grados == 180 ? 150 : direccion_en_grados);
            }   
        }
    }

    public int get_direccion_en_grados(){
        return direccion_en_grados;
    }

    public void mover(){
        jugador.set_pos_x( jugador.get_pos_x() + get_deriva_x() * jugador.get_velocidad() / 30);
        jugador.set_pos_y( jugador.get_pos_y() + get_deriva_y() * jugador.get_velocidad() / 30);
    }

    protected int get_deriva_x(){
        int indice = get_indice_segun_grados();
        return deriva_x[indice];
    }

    protected int get_deriva_y(){
        int indice = get_indice_segun_grados();
        return deriva_y[indice];
    }

     protected int get_indice_segun_grados(){
        return (direccion_en_grados/30)-1;
    }
}
