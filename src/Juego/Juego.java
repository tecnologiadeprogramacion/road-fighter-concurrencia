package Juego;

import java.util.List;

import Fabricas.FabricaEntidades;
import Fabricas.SpritesOriginales;
import Grafica.ControladorGrafica;
import Grafica.Observer;
import Parser.GeneradorRuta;
import Vehiculos.Jugador;

public class Juego implements ControladorJuego{
	
	protected ControladorGrafica controlador_grafica;
	protected GeneradorRuta generador_ruta;
	protected FabricaEntidades fabrica_entidades;
	protected Ruta ruta_actual;
	
	public Juego(ControladorGrafica controlador_grafica) {
		this.controlador_grafica = controlador_grafica;
		fabrica_entidades = new FabricaEntidades(new SpritesOriginales());
		generador_ruta = new GeneradorRuta();
	}
	
	// Operaciones para Launcher
		
	public void configurar(){
		controlador_grafica.mostrar_pantalla_inicial();
	}

	// Operaciones para ControladorGrafica
	
	public void iniciar() {
		ruta_actual = generador_ruta.generar_ruta(1, fabrica_entidades);
		registrar_observers();
		controlador_grafica.mostrar_pantalla_carrera();
	}

	public void cambiar_modo_juego(int modo){
		// To DO
	}

    public void cambiar_direccion_jugador(int direccion){
		ruta_actual.get_vehiculo_jugador().set_direccion(direccion);
	}

    public void lanzar_misil(){
		// To DO
	}
	
	protected void registrar_observers() {
		registrar_observer_jugador(ruta_actual.get_vehiculo_jugador());
		registrar_observer_silueta(ruta_actual.get_silueta());
		registrar_observers_para_entidades(ruta_actual.get_vehiculos_carrera());
		registrar_observers_para_entidades(ruta_actual.get_vehiculos_transito());
		registrar_observers_para_entidades(ruta_actual.get_obstaculos());
		registrar_observers_para_entidades(ruta_actual.get_power_ups());
	}
	
	protected void registrar_observer_jugador(Jugador vehiculo_jugador) {
		Observer observer_jugador = controlador_grafica.registrar_jugador(vehiculo_jugador);
		vehiculo_jugador.registrar_observer(observer_jugador);
	}
	
	protected void registrar_observer_silueta(Silueta silueta_ruta) {
		Observer observer = controlador_grafica.registrar_silueta(silueta_ruta);
		silueta_ruta.registrar_observer(observer);
	}
	
	protected void registrar_observers_para_entidades(List<? extends Entidad> entidades) {
		for(Entidad entidad : entidades) {
			Observer observer = controlador_grafica.registrar_entidad(entidad);
			entidad.registrar_observer(observer);
		}
	}
}
