package Grafica;

import Juego.EntidadJugador;
public class ObserverJugador extends ObserverGrafico{

	private static final long serialVersionUID = 7017967195998406908L;
	private PanelPantallaCarrera panel_pantalla_carreras;
	private EntidadJugador jugador_observado;
	
	public ObserverJugador(PanelPantallaCarrera panel_pantalla_carreras, EntidadJugador jugador_observado) {
		super(jugador_observado);
		this.panel_pantalla_carreras = panel_pantalla_carreras;
		this.jugador_observado = jugador_observado;
		actualizar();
	}
	
	public void actualizar() {
		super.actualizar();
		if (panel_pantalla_carreras != null){
			panel_pantalla_carreras.actualizar_scroll_hacia_jugador(jugador_observado);
		}
	}
}
