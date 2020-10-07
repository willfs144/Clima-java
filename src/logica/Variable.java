package logica;

import java.util.List;
import persistencia.LeerArchivo;
import persistencia.VariableDAO;

public class Variable {
	
	private String url;
	private String nombre;
	private int [] forma;
	private String tipoDato;
			
	public Variable(String rutaArchivo) {
		url = rutaArchivo;
	}
	
	
	
	public Variable(String nombre, int[] shape,  String tipoDato) {
		this.nombre = nombre;
		this.forma = shape;
		this.tipoDato = tipoDato;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int[] getForma() {
		return forma;
	}

	public void setForma(int[] forma) {
		this.forma = forma;
	}

	public String getTipoDato() {
		return tipoDato;
	}

	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}
	
	public List consultar() {
		LeerArchivo leerArchivo = new LeerArchivo(url);
		VariableDAO variableDAO= new VariableDAO(leerArchivo.getNcfile());		
		return variableDAO.consultar();	
	}

	


	

}
