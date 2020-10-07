package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import logica.Sistema;

public class Modelo {
	
	private VistaNavegador vistaNavegador;
	
	private VistaPrincipal vistaPrincipal;
	private Sistema sistema;
	
public void iniciar() {		
	this.vistaPrincipal = new VistaPrincipal(this);
	this.vistaPrincipal.setSize(980, 700);
	this.vistaPrincipal.setVisible(true);	
		
	}



	
	public void abrir() {
		this.vistaPrincipal.showDialogAbrir();
		String  urlArchivo =  vistaPrincipal.getUrl();
		if (urlArchivo != null) {
			this.sistema = new Sistema(urlArchivo);
			this.vistaPrincipal.listarVariables(sistema.consultarVariables());			
		}
		
	}

}
