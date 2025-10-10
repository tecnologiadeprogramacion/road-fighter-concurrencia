package Parser;

import Fabricas.FabricaEntidades;
import Juego.Ruta;
import Juego.Silueta;
import Powerups.Nafta;

public class GeneradorRuta {
		
	public Ruta generar_ruta(int numero, FabricaEntidades fabrica_entidades) {
		// To DO: parsear archivo
		return generar_ruta_harcoding(numero, fabrica_entidades);
	}
	
	// Operación para harcoding

	protected Ruta generar_ruta_harcoding(int numero, FabricaEntidades fabrica_entidades) {
		String patente = "AAA-111";
		float peso = 1;
		
		Silueta silueta = fabrica_entidades.get_silueta(numero);
		Ruta ruta = new Ruta(silueta, numero);
		
		ruta.agregar_jugador(fabrica_entidades.get_vehiculo_jugador(200, 0, peso, patente));

		ruta.agregar_vehiculo_carrera(fabrica_entidades.get_vehiculo_carrera(250, 125, peso, patente));
		ruta.agregar_vehiculo_carrera(fabrica_entidades.get_vehiculo_carrera(200, 175, peso, patente));
		ruta.agregar_vehiculo_carrera(fabrica_entidades.get_vehiculo_carrera(250, 225, peso, patente));

		ruta.agregar_vehiculo_transito(fabrica_entidades.get_auto(250, 75, patente));
		ruta.agregar_vehiculo_transito(fabrica_entidades.get_auto(300, 75, patente));
		
		ruta.agregar_vehiculo_transito(fabrica_entidades.get_moto(300, 275, patente));
		ruta.agregar_vehiculo_transito(fabrica_entidades.get_camion(350, 325, patente));
		
		Nafta nafta = fabrica_entidades.get_nafta(300, 400);
		ruta.agregar_vehiculo_transito(fabrica_entidades.get_camion(300, 400, patente, nafta));
		ruta.agregar_vehiculo_transito(fabrica_entidades.get_camion(350, 475, patente, nafta, nafta));
		
		ruta.agregar_obstaculo(fabrica_entidades.get_perro(300, 525));
		
		return ruta;
	}
}
