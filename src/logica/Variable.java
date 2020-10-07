package logica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	
	public String [] consultar() {
		LeerArchivo leerArchivo = new LeerArchivo(url);
		VariableDAO variableDAO= new VariableDAO(leerArchivo.getNcfile());	
		ArrayList<ucar.nc2.Variable> lista = new ArrayList<ucar.nc2.Variable>(variableDAO.consultar());
		String [] listaVariables = new String[lista.size()];
		List<Variable> listaCompleta = new ArrayList<Variable>();
		int index = 0;
		for (ucar.nc2.Variable elemento : lista) {
			listaVariables[index]= elemento.getFullName();
			Variable variable = new Variable(elemento.getFullName(), elemento.getShape(), elemento.getDataType().toString());
			listaCompleta.add(variable);
			index++;			
		}
		return listaVariables;
		
		
	}



	

}
