package Datos;

import java.util.ArrayList;
import java.util.Collections;

public class Datos {
	private ArrayList<Integer> valores;
	
	public Datos() {
		setValores(new ArrayList<Integer>());
		agregar();
		
	}

	public ArrayList<Integer> getValores() {
		return valores;
	}

	public void setValores(ArrayList<Integer> valores) {
		this.valores = valores;
	}
	
	public void agregar() {
		valores.add(1);
		valores.add(5);
		valores.add(10);
		valores.add(15);
		valores.add(25);
		valores.add(50);
		valores.add(75);
		valores.add(100);
		valores.add(200);
		valores.add(300);
		valores.add(400);
		valores.add(500);
		valores.add(750);
		valores.add(1000);
		valores.add(5000);
		valores.add(10000);
		valores.add(25000);
		valores.add(50000);
		valores.add(75000);
		valores.add(100000);
		valores.add(200000);
		valores.add(300000);
		valores.add(400000);
		valores.add(500000);
		valores.add(750000);
		valores.add(1000000);
	}
	
	public void desordenar() {
		Collections.shuffle(this.valores);
	}
	
	public void ordenar() {
	//	valores.sort(c);
	}
}
