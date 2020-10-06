package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import logica.Sistema;

public class Modelo {
	

	
	private VistaPrincipal vistaPrincipal;
	private Sistema sistema;
	
public void iniciar() {		
	this.vistaPrincipal = new VistaPrincipal(this);
	this.vistaPrincipal.setSize(980, 700);
	this.vistaPrincipal.setVisible(true);
	
	
	System.out.println("Paso");
		
	}


}
