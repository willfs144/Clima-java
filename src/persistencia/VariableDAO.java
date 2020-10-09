package persistencia;

import java.io.IOException;
import java.util.List;


import ucar.ma2.Array;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;

public class VariableDAO {
	
	private Array data;
	private NetcdfFile netcdArchivo;
	private Variable variable; 
	
	
	public VariableDAO(NetcdfFile ncfile) {
		this.netcdArchivo = ncfile;
	}

	public List<Variable> consultar() {
		return netcdArchivo.getVariables();
	}
	
	public Array buscarDatos(String filtro) {
		 variable = netcdArchivo.findVariable(filtro);
		 if (variable != null) {
			 try {			
				 data = variable.read();}
			 catch (IOException e) {
				 System.out.println("trying to read "+e);}
		  }		
		return data;
	}
	
	
	public int [] buscarForma(String nombre) {
		return  netcdArchivo.findVariable(nombre).getShapeAll();
	}
	
	public String buscarTipoDato(String nombre) {
		return  netcdArchivo.findVariable(nombre).getDataType().name();
	}
	
	
	public String buscarDimension(String nombre) {
		return  netcdArchivo.findVariable(nombre).getDimensionsString();
	}
	
	public String buscarDescripcion(String nombre) {
		return  netcdArchivo.findVariable(nombre).getDescription().toString();
	}
	
	public String buscarGrupo(String nombre) {
		return  netcdArchivo.findVariable(nombre).getGroup().getDODSName();
	}
	
	public String buscarUnidades(String nombre) {
		return  netcdArchivo.findVariable(nombre).getUnitsString();
	}
	
	

}
