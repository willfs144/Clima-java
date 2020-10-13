package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorTabla implements ActionListener, MouseListener{
	
	private VistaTabla vista;
	private Modelo modelo;

	public ControladorTabla(VistaTabla vistaTabla) {
		this.vista = vistaTabla;
		this.modelo = vista.getModelo();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		if (event.getSource() == vista.getMenuItemDeclaracion()) {
			modelo.mostrarResultadoDeclaracion();
		}
		else if (event.getSource() == vista.getMenuItemNcML()) {
			modelo.mostrarResultadoNcML();
		}
		else if (event.getSource() == vista.getMenuItemDatos()) {
			modelo.mostrarResultadoDatos();
		}
		else if (event.getSource() == vista.getMenuItemTabla()) {
			modelo.mostrarResultadoTabla();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		if (event.getSource() == vista.getTabla()) {
			modelo.seleccionarItemNavegador();
		}
		
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
