package persistencia;

import java.io.IOException;

import ucar.ma2.Array;
import ucar.ma2.InvalidRangeException;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;



public class LeerArchivo {
	NetcdfFile netcdArchivo;;
	
	
	public LeerArchivo(String nombreArchivo) {		
		  this.netcdArchivo = null;
		  try {
		    netcdArchivo = NetcdfFile.open(nombreArchivo);
		    }
		  catch (IOException ioe) {
		    System.out.println("trying to open " + nombreArchivo.toString()+"  "+ioe);}
		  finally { 
		    if (null != netcdArchivo) { 
		    	try {
		    		netcdArchivo.close();}
		    	catch (IOException ioe) {
		    		System.out.println("trying to close " + nombreArchivo.toString()+"  "+ioe);}
		    }
		  }		
	}
	
	public NetcdfFile getNcfile() {
		return netcdArchivo;
	}

}
