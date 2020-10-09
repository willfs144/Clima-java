package presentacion;



import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

public class VistaNavegador extends JInternalFrame{
	
	private JList<String> listaNavegador;
	private DefaultListModel<String> modeloLista;
	private String[] listaVariables;
	
	
	public VistaNavegador() {
		this.setTitle("Navegar Variables");
		this.setVisible(true);
	}
	
	public void cargarListaNavegar() {
		ListModel<String> modelLista = new DefaultComboBoxModel<String>(listaVariables);
		this.listaNavegador= new JList<String>();
		this.listaNavegador.setModel(modelLista);
		listaNavegador.setBounds(12, 12,410, 510);
		listaNavegador.setSize(new Dimension(400, 700));
		this.add(listaNavegador);
		
	}

	public void setListaVariables(String[] lista) {
		this.listaVariables = lista;
	}

	
	
	
	
	
	
	
	

}
