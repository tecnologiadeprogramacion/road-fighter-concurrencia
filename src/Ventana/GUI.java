package Grafica;

import javax.swing.JFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Juego.ControladorJuego;
import Juego.EntidadJugador;
import Juego.EntidadLogica;

public class GUI implements ControladorVistas, ControladorGrafica{
	protected JFrame ventana;
	protected PanelPantallaPrincipal panel_pantalla_principal;
	protected PanelPantallaCarrera panel_pantalla_carrera;
	protected PanelPantallaPuntaje panel_pantalla_puntaje;
	
	protected ControladorJuego controlador_juego;
	
	public GUI() {
		panel_pantalla_puntaje = new PanelPantallaPuntaje(this);
		panel_pantalla_principal = new PanelPantallaPrincipal(this);
		panel_pantalla_carrera = new PanelPantallaCarrera(this);
		configurar_ventana();
		registrar_oyente_ventana();
	}
	
	protected void configurar_ventana() {
		ventana = new JFrame("TdP :: Mini Road Fighter");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setSize(ConstantesVistas.VENTANA_ANCHO, ConstantesVistas.VENTANA_ALTO);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		ventana.setFocusable(true);
	}
	
	protected void registrar_oyente_ventana() {
		ventana.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				if (e.getKeyCode() == KeyEvent.VK_A){
					controlador_juego.cambiar_direccion_jugador(ConstantesTeclado.IZQUIERDA);
				}
				if (e.getKeyCode() == KeyEvent.VK_D){
					controlador_juego.cambiar_direccion_jugador(ConstantesTeclado.DERECHA);
				}
				if (e.getKeyCode() == KeyEvent.VK_SPACE){
					controlador_juego.lanzar_misil();
				}
			}
		});
	}
		
	// De interfaz ControladorVistas
	
	public void accionar_inicio_juego() {
		controlador_juego.iniciar();
	}
	
	public void accionar_pantalla_puntajes() {
		// To Do
	}
	
	public void accionar_pantalla_modo_juego() {
		// To Do
	}
	
	public void cambiar_modo_juego(int modo) {
		// To Do
	}
	
	// De interfaz ControladorGrafica

	public void registrar_controlador_juego(ControladorJuego controlador_juego){
		this.controlador_juego = controlador_juego;
	}

	public void mostrar_pantalla_inicial() {
		ventana.setContentPane(panel_pantalla_principal);
		refrescar();
	}
	
	public Observer registrar_entidad(EntidadLogica entidad_logica) {
		Observer observer_entidad = panel_pantalla_carrera.incorporar_entidad(entidad_logica);
		refrescar();
		return observer_entidad;
	}
	
	public Observer registrar_jugador(EntidadJugador entidad_jugador) {
		Observer observer_jugador = panel_pantalla_carrera.incorporar_entidad_jugador(entidad_jugador);
		refrescar();
		return observer_jugador;
	}
	
	public Observer registrar_silueta(EntidadLogica silueta) {
		Observer observer_silueta = panel_pantalla_carrera.incorporar_silueta(silueta);
		refrescar();
		return observer_silueta;
	}
	
	public void mostrar_pantalla_carrera() {
		ventana.setContentPane(panel_pantalla_carrera);
		refrescar();
	}

	public void mostrar_pantalla_fin_juego() {
		// To Do
	}
	
	protected void refrescar() {
		ventana.revalidate();
		ventana.repaint();
	}
}
