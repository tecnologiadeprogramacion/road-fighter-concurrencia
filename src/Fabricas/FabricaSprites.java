package Fabricas;

import java.util.HashMap;
import java.util.Map;

import Powerups.PowerUp;

public abstract class FabricaSprites {
	
	protected String ruta_a_carpeta;
		
	protected FabricaSprites(String ruta_a_carpeta) {
		this.ruta_a_carpeta = ruta_a_carpeta;
	}

	// Operación de HARCODING
	// To DO: especificar el mapeo estado-imagen para cada entidad, en cada uno de los métodos get_xxx
	// Por ejemplo, get_silueta deberá genera un mapeo de un único estado-imagen
	// Por ejemplo, get_vehiculo_jugador generará un mapeo con un estado-imagen por cada posible imagen
	// que represente un sprite diferente para dicha entidad.
	private Map<Integer,String> get_mapeo_estado_imagen_harcoding(String imagen_unica){
		Map<Integer,String> mapeo_estado_imagen = new HashMap<Integer,String>();
		String ruta_a_imagen_unica = ruta_a_carpeta + "/" + imagen_unica;
		mapeo_estado_imagen.put(0, ruta_a_imagen_unica);
		return mapeo_estado_imagen;
	}
	
	public Sprites get_silueta(int numero) {
		return new Sprites( get_mapeo_estado_imagen_harcoding ("ruta-"+numero+".png"), 0);	
	}
	
	public Sprites get_vehiculo_jugador() {
		Map<Integer,String> mapeo_estado_imagen = new HashMap<Integer,String>();
		mapeo_estado_imagen.put(30, ruta_a_carpeta + "/jugador-30.png");
		mapeo_estado_imagen.put(60, ruta_a_carpeta + "/jugador-60.png");
		mapeo_estado_imagen.put(90, ruta_a_carpeta + "/jugador-90.png");
		mapeo_estado_imagen.put(120, ruta_a_carpeta + "/jugador-120.png");
		mapeo_estado_imagen.put(150, ruta_a_carpeta + "/jugador-150.png");
		return new Sprites(mapeo_estado_imagen, 90);
	}
	
	public Sprites get_vehiculo_carrera() {
		return new Sprites( get_mapeo_estado_imagen_harcoding ("contrincante.png"), 0);
	}
	
	public Sprites get_moto() {
		return new Sprites( get_mapeo_estado_imagen_harcoding ("moto.png"), 0);
	}
	
	public Sprites get_auto() {
		return new Sprites( get_mapeo_estado_imagen_harcoding ("auto.png"), 0);
	}
	
	public Sprites get_camion() {
		return new Sprites( get_mapeo_estado_imagen_harcoding ("camion.png"), 0);
	}
	
	public Sprites get_moto(PowerUp p) {
		return new Sprites( get_mapeo_estado_imagen_harcoding ("moto-power-up.gif"), 0);
	}
	
	public Sprites get_auto(PowerUp p) {
		return new Sprites( get_mapeo_estado_imagen_harcoding ("auto-power-up.gif"), 0);
	}
	
	public Sprites get_camion(PowerUp p) {
		return new Sprites( get_mapeo_estado_imagen_harcoding ("camion-power-up-1.gif"), 0);
	}
	
	public Sprites get_camion(PowerUp p1, PowerUp p2) {
		return new Sprites( get_mapeo_estado_imagen_harcoding ("camion-power-up-2.gif"), 0);
	}
	
	public Sprites get_misil() {
		return new Sprites( get_mapeo_estado_imagen_harcoding ("misil.png"), 0);
	}
	
	public Sprites get_nitro() {
		return new Sprites( get_mapeo_estado_imagen_harcoding ("nitro.png"), 0);
	}
	
	public Sprites get_nafta() {
		return new Sprites( get_mapeo_estado_imagen_harcoding ("nafta.png"), 0);
	}
	
	public Sprites get_anciana() {
		return new Sprites( get_mapeo_estado_imagen_harcoding ("anciana.png"), 0);
	}
	
	public Sprites get_perro() {
		return new Sprites( get_mapeo_estado_imagen_harcoding ("perro.png"), 0);
	}
	
	public Sprites get_lobo() {
		return new Sprites( get_mapeo_estado_imagen_harcoding ("lobo.png"), 0);
	}
	
	public Sprites get_bache() {
		return new Sprites( get_mapeo_estado_imagen_harcoding ("bache.png"), 0);
	}
}
