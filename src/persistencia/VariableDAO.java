package persistencia;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;


import ucar.ma2.Array;
import ucar.ma2.InvalidRangeException;
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
	
	public Array buscarDatos(String varName) {
		Variable v = netcdArchivo.findVariable(varName);
		try {
			this.netcdArchivo = NetcdfFile.open(this.netcdArchivo.getLocation());
			 if (null == v) return null;
			 Array data = v.read();
			 System.out.println(data);
		} catch (IOException e) {
			 System.out.println(varName+"  "+e);
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
		return  netcdArchivo.findVariable(nombre).getDescription();
	}
	
	public String buscarGrupo(String nombre) {
		return  netcdArchivo.findVariable(nombre).getGroup().getDODSName();
	}
	
	public String buscarUnidades(String nombre) {
		return  netcdArchivo.findVariable(nombre).getUnitsString();
	}
	
	

}
