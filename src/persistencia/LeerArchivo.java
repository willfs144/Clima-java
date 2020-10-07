package persistencia;

import java.io.IOException;
import ucar.ma2.InvalidRangeException;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;



public class LeerArchivo {
	NetcdfFile ncfile;
	
	
	public LeerArchivo(String nombreArchivo) {		
		  this.ncfile = null;
		  try {
		    ncfile = NetcdfFile.open(nombreArchivo);}
		  catch (IOException ioe) {
		    System.out.println("trying to open " + nombreArchivo.toString()+"  "+ioe);}
		  finally { 
		    if (null != ncfile) { 
		    	try {
		    		ncfile.close();}
		    	catch (IOException ioe) {
		    		System.out.println("trying to close " + nombreArchivo.toString()+"  "+ioe);}
		    }
		  }		
	}
	
	
	public NetcdfFile getNcfile() {
		return ncfile;
	}







	public void process(NetcdfFile ncfile) {
		//System.out.println(ncfile.toString());
		mostrarDatosVariable(ncfile);
	}

	private void mostrarDatosVariable(NetcdfFile ncfile)  {
		
		//Variable v = ncfile.findVariable(nombreVariable1);
		
		
		for (Variable variable: ncfile.getVariables()) {
			System.err.println(variable.getFullName());
			
			
		}
		
		/*System.out.println(ncfile.getVariables().toString());
		  if (null == v) {
			  System.out.println("nulo");
			  return;
		  }
		 try {
		 ucar.ma2.Array data = v.read();
		 System.out.println("Resultado: "+data.toString());
		  
		 } catch (IOException ioe) {
			// System.out.println("trying to read " + nombreVariable1+" "+ioe);

		  }*/
		
	}

}
