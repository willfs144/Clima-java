package presentacion;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorVistaNavegador implements MouseListener{
	
	private VistaNavegador vista;
	private Modelo modelo;
	

	public ControladorVistaNavegador(VistaNavegador vistaNavegador) {
		this.vista = vistaNavegador;
		this.modelo = vistaNavegador.getModelo();		
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		this.modelo.seleccionarFilaTabla();
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



}
