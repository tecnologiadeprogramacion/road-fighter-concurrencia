package Grafica;

import Juego.ControladorJuego;
import Juego.EntidadJugador;
import Juego.EntidadLogica;

public interface ControladorGrafica {
	public void registrar_controlador_juego(ControladorJuego controlador_juego);
    public void mostrar_pantalla_inicial();
    public void mostrar_pantalla_carrera();
	public void mostrar_pantalla_fin_juego();
	public Observer registrar_entidad(EntidadLogica entidad_logica);
	public Observer registrar_jugador(EntidadJugador entidad_jugador);
	public Observer registrar_silueta(EntidadLogica silueta);
}
