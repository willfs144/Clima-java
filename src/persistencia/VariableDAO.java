package persistencia;

import java.io.IOException;
import java.util.List;


import ucar.ma2.Array;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;

public class VariableDAO {
	
	private Array data;
	private NetcdfFile ncfile;
	
	
	public VariableDAO(NetcdfFile ncfile) {
		this.ncfile = ncfile;
	}

	public List<Variable> consultar() {
		return ncfile.getVariables();
	}
	
	public Array buscar(String filtro) {
		Variable variable = ncfile.findVariable(filtro);
		 if (variable != null) {
			 try {			
				 data = variable.read();}
			 catch (IOException e) {
				 System.out.println("trying to read "+e);}
		  }		
		return data;
	}

}
