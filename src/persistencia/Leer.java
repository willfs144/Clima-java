package persistencia;

import java.io.IOException;

import ucar.nc2.NetcdfFile;



public class Leer {
	String filename = "D:\\William\\Proyectos_realizados\\Java\\POO\\Clima\\src\\recursos\\outN.1";
	
	public Leer() {
		
		
		  NetcdfFile ncfile = null;
		  try {
		    ncfile = NetcdfFile.open(filename);
		    process( ncfile);
		  } catch (IOException ioe) {
		    System.out.println("trying to open " + filename.toString()+"  "+ioe);
		  } finally { 
		    if (null != ncfile) try {
		      ncfile.close();
		    } catch (IOException ioe) {
		     System.out.println("trying to close " + filename.toString()+"  "+ioe);
		    }
		  }
		
	}

	public void process(NetcdfFile ncfile) {
		System.out.println(ncfile.toString());	
	}

	public static void main(String[] args) {
		new Leer();
	}

}
