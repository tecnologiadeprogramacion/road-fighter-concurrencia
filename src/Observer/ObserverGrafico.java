package Grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Juego.EntidadLogica;
public class ObserverGrafico extends JLabel implements Observer{
	
	private static final long serialVersionUID = 1L;
	protected EntidadLogica entidad_observada;
	
	public ObserverGrafico(EntidadLogica entidad_observada) {
		super();
		this.entidad_observada = entidad_observada;
		actualizar();
	}
	
	public void actualizar() {
		actualizar_imagen();
		actualizar_posicion_tamano();
	}
	
	protected void actualizar_imagen() {
		String ruta_imagen = entidad_observada.get_sprites().get_ruta_imagen_actual();
		ImageIcon icono = new ImageIcon(getClass().getClassLoader().getResource(ruta_imagen));
		setIcon(icono);
	}
	
	protected void actualizar_posicion_tamano() {
		int x = AdaptadorPosicionPixel.transformar_x(entidad_observada.get_pos_x());
		int y = AdaptadorPosicionPixel.transformar_y(entidad_observada.get_pos_y());
		int ancho = this.getIcon().getIconWidth();
		int alto = this.getIcon().getIconHeight();
		setBounds(x, y, ancho, alto);
	}
}
