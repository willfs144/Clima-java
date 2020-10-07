package presentacion;



import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

public class VistaNavegador extends JPanel{
	
	private JList<String> listaNavegador;
	private DefaultListModel<String> modeloLista;
	private String[] listaVariables;
	
	
	public VistaNavegador() {
			
		//this.modeloLista = new DefaultListModel<String>();
		//this.modeloLista.add(0 , "Vamos");
		//this.listaNavegador = new JList(modeloLista);
		//listaNavegador.setBounds(40, 30, 80, 150);
		//this.add(listaNavegador);
		
		
	}
	
	public void cargarListaNavegar() {
		ListModel<String> modelLista = new DefaultComboBoxModel<String>(listaVariables);
		this.listaNavegador= new JList<String>();
		this.listaNavegador.setModel(modelLista);
		listaNavegador.setBounds(12, 12,410, 510);
		listaNavegador.setSize(new Dimension(400, 700));
		this.add(listaNavegador);
		
		//JScrollPane scroll = new JScrollPane();
		//scroll.setBounds(12, 12,410, 510);
		//scroll.setViewportView(listaNavegador);
		//this.add(scroll);	
	}

	public void setListaVariables(String[] lista) {
		this.listaVariables = lista;
	}

	
	
	
	
	
	
	
	

}
