package main;

import presentacion.Modelo;

public class Laucher {
	
	private Modelo modelo;
	
	
	public Laucher() {	
		modelo = new Modelo();
		modelo.iniciar();
	}

	public static void main(String[] args) {
		new Laucher();
	}

}
