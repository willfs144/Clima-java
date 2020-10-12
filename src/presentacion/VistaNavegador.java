package presentacion;



import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.event.AncestorListener;

public class VistaNavegador extends JInternalFrame{
	
	private JList<String> listaNavegador;
	private DefaultListModel<String> modeloLista;
	private String[] listaVariables;
	
	private Modelo modelo;
	private ControladorVistaNavegador controladorVistaNavegador;
	
	
	public VistaNavegador(Modelo modelo) {
		this.modelo = modelo;
		this.controladorVistaNavegador = new ControladorVistaNavegador(this);
	
		this.setTitle("Navegar Variables");
		this.setVisible(true);
		this.listaNavegador= new JList<String>();
		
		this.listaNavegador.addMouseListener(controladorVistaNavegador);
	}
	
	public void cargarListaNavegar() {
		ListModel<String> modelLista = new DefaultComboBoxModel<String>(listaVariables);		
		listaNavegador.setModel(modelLista);
		listaNavegador.setBounds(12, 12,410, 510);
		listaNavegador.setSize(new Dimension(400, 700));
		this.add(listaNavegador);
		
	}	

	public void seleccionarItemLista(int index) {
		this.listaNavegador.setSelectedIndex(index);		
	}


	public void setListaVariables(String[] lista) {
		this.listaVariables = lista;
	}
	
	

	public JList<String> getListaNavegador() {
		return listaNavegador;
	}

	public Modelo getModelo() {
		return modelo;
	}

	
	
	
	
	
	
	
	
	

}
