package Grafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Juego.EntidadJugador;
import Juego.EntidadLogica;
public class PanelPantallaCarrera extends PanelVista {

	private static final long serialVersionUID = -1366756178696496543L;
	private JPanel panel_carreras;
	private JPanel panel_informacion;
	private JLabel imagen_fondo_panel_carreras;
	private JLabel imagen_fondo_panel_informacion;
	private JScrollPane panel_scroll_carrera;
	private JLabel label_puntaje;
	private JLabel label_velocidad;
	private JLabel label_combustible;

	public PanelPantallaCarrera(ControladorVistas controlador_vistas) {
		super(controlador_vistas);
		setPreferredSize(new Dimension(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO));
		setLayout(new BorderLayout());
		setDoubleBuffered(true);
		agregar_panel_informacion();
		agregar_panel_carrera_con_fondo_y_scroll();
	}
	
	public Observer incorporar_entidad(EntidadLogica entidad_logica) {
		ObserverGrafico observer_grafico = new ObserverGrafico(entidad_logica);
		imagen_fondo_panel_carreras.add(observer_grafico);	
		return observer_grafico;
	}
	
	public Observer incorporar_entidad_jugador(EntidadJugador entidad_jugador) {
		ObserverJugador observer_jugador = new ObserverJugador(this, entidad_jugador);
		imagen_fondo_panel_carreras.add(observer_jugador);
		actualizar_info_jugador(entidad_jugador);
		return observer_jugador;
	}
	
	public Observer incorporar_silueta(EntidadLogica entidad_logica) {
		ObserverGrafico observer_grafico = new ObserverGrafico(entidad_logica);
		imagen_fondo_panel_carreras.setIcon(new ImageIcon(getClass().getClassLoader().getResource(entidad_logica.get_sprites().get_ruta_imagen_actual())));
		imagen_fondo_panel_carreras.setBounds(0,0, imagen_fondo_panel_carreras.getIcon().getIconWidth(), imagen_fondo_panel_carreras.getIcon().getIconHeight());
		panel_carreras.setPreferredSize(new Dimension(imagen_fondo_panel_carreras.getIcon().getIconWidth(), imagen_fondo_panel_carreras.getIcon().getIconHeight()));
		return observer_grafico;
	}
		
	protected void actualizar_info_jugador(EntidadJugador jugador) {
		actualizar_labels_informacion(jugador);
		actualizar_scroll_hacia_jugador(jugador);
	}
	
	protected void actualizar_labels_informacion(EntidadJugador jugador) {
		label_puntaje.setText( texto_con_cantidad_digitos(jugador.get_puntaje(), 5) );
		label_velocidad.setText( texto_con_cantidad_digitos(jugador.get_velocidad(), 5) );
		label_combustible.setText( texto_con_cantidad_digitos(jugador.get_combustible(), 5) );
	}
	
	protected String texto_con_cantidad_digitos(int numero, int digitos) {
		String texto_autocompletado = "";
		if (en_rango(numero, 0, 9)) {
			texto_autocompletado = "0000" + numero;
		}else {
			if (en_rango(numero, 10, 99)) {
				texto_autocompletado = "000" + numero;
			}else {
				if (en_rango(numero, 100, 999)) {
					texto_autocompletado = "00" + numero;
				}else {
					if(en_rango(numero, 1000, 9999)) {
						texto_autocompletado = "0" + numero;
					}else {
						texto_autocompletado += numero;
					}
				}
			}
		}
		return texto_autocompletado;
	}
	
	protected boolean en_rango(int numero, int piso, int techo) {
		boolean retorno;
		retorno = numero >= piso;
		retorno = retorno && (numero <= techo);
		return retorno;
	}
	
	// Operacion para observer de jugador
	
	protected void actualizar_scroll_hacia_jugador(EntidadJugador jugador) {
		int pos_y_jugador = AdaptadorPosicionPixel.transformar_y(jugador.get_pos_y());
		int margen_debajo_jugador = ConstantesVistas.MARGEN_DEBAJO_JUGADOR;
		int viewport_nuevo_y =  (pos_y_jugador + margen_debajo_jugador) - ConstantesVistas.PANEL_ALTO;
		panel_scroll_carrera.getViewport().setViewPosition(new Point(0,viewport_nuevo_y));		
	}
	
	// Operaciones propias para construccion de PanelPantallaCarrera
	
	protected void agregar_panel_carrera_con_fondo_y_scroll() {
		imagen_fondo_panel_carreras = new JLabel();
		imagen_fondo_panel_carreras.setLayout(null);
		imagen_fondo_panel_carreras.setBounds(0,0, ConstantesVistas.PANEL_CARRERA_ANCHO, ConstantesVistas.PANEL_ALTO);
		
		panel_carreras = new JPanel(null);
		panel_carreras.setPreferredSize(new Dimension(ConstantesVistas.PANEL_CARRERA_ANCHO, ConstantesVistas.PANEL_ALTO));
		panel_carreras.add(imagen_fondo_panel_carreras);
		
		panel_scroll_carrera = new JScrollPane(panel_carreras);
		panel_scroll_carrera.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel_scroll_carrera.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		panel_scroll_carrera.setWheelScrollingEnabled(false);
		panel_scroll_carrera.setBounds(0, 0, ConstantesVistas.PANEL_CARRERA_ANCHO, ConstantesVistas.PANEL_ALTO);
			
		add(panel_scroll_carrera, BorderLayout.CENTER);
	}
		
	protected void agregar_panel_informacion() {
		panel_informacion = new JPanel();
		panel_informacion.setLayout(null);
		panel_informacion.setPreferredSize(new Dimension(ConstantesVistas.PANEL_INFORMACION_ANCHO, ConstantesVistas.PANEL_ALTO));
		agregar_imagen_fondo_panel_informacion();
		agregar_labels_editables_informacion();
		add(panel_informacion, BorderLayout.EAST);
	}
	
	protected void agregar_imagen_fondo_panel_informacion() {
		imagen_fondo_panel_informacion = new JLabel();
		ImageIcon icono_imagen = new ImageIcon(this.getClass().getResource("/imagenes/pantalla-informacion.png"));
		Image imagen_escalada = icono_imagen.getImage().getScaledInstance(ConstantesVistas.PANEL_INFORMACION_ANCHO, ConstantesVistas.PANEL_ALTO, Image.SCALE_SMOOTH);
		Icon icono_imagen_escalado = new ImageIcon(imagen_escalada);
		imagen_fondo_panel_informacion.setIcon(icono_imagen_escalado);
		imagen_fondo_panel_informacion.setBounds(0,0, ConstantesVistas.PANEL_INFORMACION_ANCHO, ConstantesVistas.PANEL_ALTO);
		panel_informacion.add(imagen_fondo_panel_informacion);
	}
	
	protected void agregar_labels_editables_informacion() {
		label_puntaje = new JLabel("00000");
		label_velocidad = new JLabel("00000");
		label_combustible = new JLabel("00000");
		decorar_labels_informacion();
		imagen_fondo_panel_informacion.add(label_puntaje);
		imagen_fondo_panel_informacion.add(label_velocidad);
		imagen_fondo_panel_informacion.add(label_combustible);
	}	
	
	protected void decorar_labels_informacion() {
		label_puntaje.setBounds(49, 120, 150, 50);
		label_velocidad.setBounds(54, 290, 150, 50);
		label_combustible.setBounds(52, 450, 150, 50);
		
		label_puntaje.setForeground(Color.WHITE);
		label_velocidad.setForeground(Color.WHITE);
		label_combustible.setForeground(Color.WHITE);
		
		label_puntaje.setFont(new Font(label_puntaje.getFont().getName(), Font.BOLD, 24));
		label_velocidad.setFont(new Font(label_puntaje.getFont().getName(), Font.BOLD, 24));
		label_combustible.setFont(new Font(label_puntaje.getFont().getName(), Font.BOLD, 24));
	}
}
