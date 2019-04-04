package Maletines;

import java.util.ArrayList;

import javax.swing.JButton;

public class Maletas {
	private ArrayList<JButton> maletines;
	
	public Maletas() {
		setMaletines(new ArrayList<JButton>());
	}

	public ArrayList<JButton> getMaletines() {
		return maletines;
	}

	public void setMaletines(ArrayList<JButton> maletines) {
		this.maletines = maletines;
	}
	
	public void agregarMal(JButton jBotones) {
		this.maletines.add(jBotones);
	}
	
	
}
