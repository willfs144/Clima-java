package presentacion;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorVistaTabla implements MouseListener{
	
	private VistaTabla vista;
	private Modelo modelo;

	public ControladorVistaTabla(VistaTabla vistaTabla) {
		this.vista = vistaTabla;
		this.modelo = vista.getModelo();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		modelo.seleccionarItemNavegador();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {	
		if (e.isPopupTrigger()) {
			modelo.mostrarMenuTablaDatos(e.getX(), e.getY());			
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.isPopupTrigger()) {
			modelo.mostrarMenuTablaDatos(e.getX(), e.getY());			
		}
		
	}

}
