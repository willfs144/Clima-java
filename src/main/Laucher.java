package main;

import logica.Variable;
import persistencia.LeerArchivo;
import presentacion.Modelo;

public class Laucher {
	
	private Modelo modelo;
	private LeerArchivo leer;
	private Variable variable;
	
	public Laucher() {
		//leer = new Leer();
		modelo = new Modelo();
		modelo.iniciar();
		//variable = new Variable("D:\\outN.3");
		//System.out.println(variable.consultar());
	}

	public static void main(String[] args) {
		new Laucher();

	}

}
