package logica;

import java.awt.Shape;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sistema {
	
	private Variable variable;
	private ArrayList<Variable> variables;
	private String rutaArchivo;
	
	
	public Sistema(String rutaArchivo) {
		variable = new Variable(rutaArchivo);
	}
	
	
	public Variable getVariable() {
		return variable;
	}
	public void setVariable(Variable variable) {
		this.variable = variable;
	}
	public ArrayList<Variable> getVariables() {
		
		return variables;
	}
	public void setVariables(ArrayList<Variable> variables) {
		this.variables = variables;
	}
	
	public void leerArchivo() {
		
	}
	
	public String[] consultarVariables() {
		String [] variables2 = variable.consultar();
		
		return variable.consultar();
	}
	
	
	

}
