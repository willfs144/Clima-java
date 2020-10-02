package persistencia;

import java.io.IOException;
import java.lang.reflect.Array;

import ucar.ma2.InvalidRangeException;
import ucar.nc2.NCdumpW;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;



public class Leer {
	String nombreArchivo = "D:\\William\\Proyectos_realizados\\Java\\POO\\Clima\\src\\recursos\\outN.3";
	String nombreVariable1 = "radialElev";
	String nombreVariable2 = "siteLat";
	
	public Leer() {		
		
		  NetcdfFile ncfile = null;
		  try {
		    ncfile = NetcdfFile.open(nombreArchivo);
		    process( ncfile);
		    
		  } catch (IOException ioe) {
		    System.out.println("trying to open " + nombreArchivo.toString()+"  "+ioe);
		  } finally { 
		    if (null != ncfile) try {
		      ncfile.close();
		    } catch (IOException ioe) {
		     System.out.println("trying to close " + nombreArchivo.toString()+"  "+ioe);
		    }
		  }
		
	}

	public void process(NetcdfFile ncfile) {
		//System.out.println(ncfile.toString());
		mostrarDatosVariable(ncfile);
	}

	private void mostrarDatosVariable(NetcdfFile ncfile)  {
		
		Variable v = ncfile.findVariable(nombreVariable1);
		  if (null == v) {
			  System.out.println("nulo");
			  return;
		  }
		 try {
		 ucar.ma2.Array data = v.read("1:1");
		 System.out.println("Resultado: "+data.toString());
		  
		 } catch (IOException ioe) {
			 System.out.println("trying to read " + nombreVariable1+" "+ioe);

		  } catch (InvalidRangeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
