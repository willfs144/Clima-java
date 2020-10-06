package presentacion;


import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

public class VistaNavegador extends JPanel{
	
	private JList listaNavegador;
	private DefaultListModel modeloLista;
	
	
	public VistaNavegador() {
		this.listaNavegador = new JList();
		this.modeloLista = new DefaultListModel();
		
	}
	
	public void cargarListaNavegar() {		
		modeloLista.addElement("Hola mundo");
		listaNavegador.setModel(modeloLista);
		this.add(listaNavegador);
	}
	
	
	
	

}
