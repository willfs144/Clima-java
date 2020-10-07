package logica;

import java.util.ArrayList;

public class Sistema {
	
	private Variable variable;
	private ArrayList<Variable> variables;	
	
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
	
	
	public String[] consultarVariables() {		
		ArrayList<ucar.nc2.Variable> lista = new ArrayList<ucar.nc2.Variable>(variable.consultar());
		String [] listaVariables = new String[lista.size()];
		this.variables = new ArrayList<Variable>();
		int index = 0;
		for (ucar.nc2.Variable elemento : lista) {
			listaVariables[index]= elemento.getFullName();
			Variable variable = new Variable(elemento.getFullName(), elemento.getShape(), elemento.getDataType().toString());
			variables.add(variable);
			index++;			
		}
		return listaVariables;
	}
	
	
	
	

}
