package Vehiculos;

import java.util.LinkedList;
import java.util.List;

import EstadoDireccion.EstadoDireccion;
import Fabricas.Sprites;
import Juego.EntidadJugador;
import Obstaculos.Obstaculo;
import Powerups.Misil;
import Powerups.PowerUp;
import Visitor.Colisionable;
import Visitor.Colisionador;

public class Jugador extends Carrera implements EntidadJugador, Colisionador {

	protected EstadoDireccion estado_direccion;
	protected List<Misil> mis_misiles;
	protected int combustible;
	protected int puntaje;
	protected int vidas;
	
	public Jugador(Sprites sprites, int x, int y, float peso, String patente) {
		super(sprites, x, y, peso, patente);
		estado_direccion = new EstadoDireccion(this);
		velocidad = 90;
		mis_misiles = new LinkedList<Misil>();
		combustible = 100;
		puntaje = 0;
		vidas = 3;
	}

	public void set_direccion(int direccion){
		estado_direccion.cambiar_direccion(direccion);
		this.mis_sprites.set_estado_actual(get_clave_representando_estado());
		notificar_observers();
	}

	public void set_velocidad(int velocidad){
		this.velocidad = velocidad;
	}

	public void set_combustible(int combustible){
		this.combustible = combustible;
	}

	public void set_puntaje(int puntaje){
		this.puntaje = puntaje;
	}

	public int get_velocidad(){
		return velocidad;
	}

	public int get_combustible() {
		return combustible;
	}

	public int get_puntaje() {
		return puntaje;
	}

	public void mover(){
		estado_direccion.mover();
		notificar_observers();
	}

	public void chocar(Colisionable colisionable) {
		colisionable.afectar(this);
	}

	public void afectar(Jugador jugador){
		// To DO
	}

	public void afectar(Transito transito){
		// To DO
	}

	public void juntar(PowerUp power_up){
		// To DO
	}

	public void quitar_power_ups(){
		// To DO
	}

	public void agregar_misil(Misil misil){
		mis_misiles.add(misil);
	}

	public void lanzar_misil(Obstaculo obstaculo){
		// To DO
	}

	public void pierde_partida(){
		// To DO
	}

	protected int get_clave_representando_estado(){
		// To DO: Este metodo solo considera como estado la direccion a la que apunta el auto
		// La clave debera considerar cuestiones extras, como por ejmplo, si contiene misiles,
		// lo que posiblemente redundara en otros sprites representando al jugador.
		return estado_direccion.get_direccion_en_grados();
	}
}
