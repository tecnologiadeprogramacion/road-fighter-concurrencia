package Juego;

import java.util.LinkedList;
import java.util.List;

import Fabricas.Sprites;
import Grafica.Observer;

public abstract class Entidad implements EntidadLogica {
	
	protected Sprites mis_sprites;
	protected List<Observer> mis_observers;
	protected int x;
	protected int y;
	
	protected Entidad(Sprites sprites, int x, int y) {
		this.mis_sprites = sprites;
		this.mis_observers = new LinkedList<Observer>();
		this.x = x;
		this.y = y;
	}
	
	public Sprites get_sprites() {
		return mis_sprites;
	}
	
	public int get_pos_x() {
		return x;
	}
	
	public int get_pos_y() {
		return y;
	}
	
	public void set_pos_x(int x) {
		this.x = x;
	}
	
	public void set_pos_y(int y) {
		this.y = y;
	}
	
	public void registrar_observer(Observer observer) {
		this.mis_observers.add(observer);
	}

	public void remover_observer(Observer observer) {
		this.mis_observers.remove(observer);
	}

	public void notificar_observers(){
		for(Observer o: mis_observers){
			o.actualizar();
		}
	}
}
