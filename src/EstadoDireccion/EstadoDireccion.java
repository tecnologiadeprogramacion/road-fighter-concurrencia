package EstadoDireccion;

import Grafica.ConstantesTeclado;
import Vehiculos.Jugador;

public class EstadoDireccion {
    protected Jugador jugador;
    protected int direccion_en_grados;
    
    public EstadoDireccion(Jugador jugador){
        this.jugador = jugador;
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
}
