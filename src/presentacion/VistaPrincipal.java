package presentacion;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Insets;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;


public class VistaPrincipal extends JFrame {
	
	private JMenuBar menuBar;
	private JMenuItem menuItemNuevo;
	private JMenuItem menuItemAbrir;
	private JMenuItem menuItemGuardar;
	private JMenu menuArchivo;
	
	private String url;
	
	private VistaTabla vistaTabla;
	private VistaNavegador vistaNavegador;
	
	private Modelo modelo;
	private ControladorPrincipal controladorPrincipal;

	
	public VistaPrincipal(Modelo modelo) {
		this.modelo = modelo;
		this.controladorPrincipal = new ControladorPrincipal(this);
		this.setLayout(new BorderLayout());
		this.vistaNavegador = new VistaNavegador(modelo);
		this.vistaTabla = new VistaTabla(modelo);
		this.getContentPane().add(vistaTabla, BorderLayout.CENTER);
		agregarArchivoMenuInterfaz();		
	}




	private void agregarArchivoMenuInterfaz() {
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("Clima");
		{
			this.menuBar= new JMenuBar();
			this.setJMenuBar(menuBar);
			{
				this.menuArchivo = new JMenu();
				this.menuBar.add(menuArchivo);
				this.menuArchivo.setText("Archivo");
				{
					this.menuItemNuevo = new JMenuItem();
					this.menuArchivo.add(menuItemNuevo);
					this.menuItemNuevo.setText("Nuevo");
					this.menuItemNuevo.addActionListener(controladorPrincipal);
				}
				{
					this.menuItemAbrir = new JMenuItem();
					this.menuArchivo.add(menuItemAbrir);
					this.menuItemAbrir.setText("Abrir");
					this.menuItemAbrir.addActionListener(controladorPrincipal);
				}
				{
					this.menuItemGuardar = new JMenuItem();
					this.menuArchivo.add(menuItemGuardar);
					this.menuItemGuardar.setText("Guardar");
					this.menuItemGuardar.addActionListener(controladorPrincipal);
				}
			}
		}
		
			
	}
	
	public void showDialogAbrir() {					
		JFileChooser ventana = new JFileChooser();
		int seleccion = ventana.showOpenDialog(null);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			File file = ventana.getSelectedFile();
			url = file.getPath();			
			System.out.println(url);
		}
	}
	
	public void listarVariables(String[] listaVariables) {		
		vistaNavegador.setListaVariables(listaVariables);
		vistaNavegador.cargarListaNavegar();
		this.getContentPane().add(vistaNavegador, BorderLayout.LINE_START);
		this.setVisible(true);		
	}
	
	public void mostrarVentanaResultados(String resultado) {
		JFrame jframe = new JFrame();
		jframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		jframe.setLayout(new BorderLayout());
		jframe.setSize(580, 500);		
		jframe.setResizable(true);
		
		Font fuente = new Font("Dialog", Font.BOLD, 12);		
		JTextArea texto = new JTextArea();		
		texto.setText(resultado);		
		texto.setWrapStyleWord(true);		
		texto.setFont(fuente);
		texto.setMargin(new Insets(10,10,10,10));
		texto.setEditable(false);
		
		
		JScrollPane scroll = new JScrollPane (texto, 
			    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
	
		
		jframe.add(scroll); 
		jframe.setTitle("Resultados: ");
		jframe.setVisible(true);
	}

	public void mostarTabla(String [][] listaDatosTabla) {
		this.vistaTabla.mostrarDatosVariables(listaDatosTabla);
		
	}
	
	public void mostrarMensaje(String msg, String titulo) {
		JOptionPane.showMessageDialog(this, msg, titulo,JOptionPane.ERROR_MESSAGE);	
	}
	

	public String getUrl() {
		return url;
	}

	public JMenuItem getMenuItemAbrir() {
		return menuItemAbrir;
	}

	public JMenuItem getMenuItemGuardar() {
		return menuItemGuardar;
	}

	public JMenuItem getMenuItemNuevo() {
		return menuItemNuevo;
	}

	public Modelo getModelo() {		
		return modelo;
	}

	public VistaTabla getVistaTabla() {
		return vistaTabla;
	}

	public VistaNavegador getVistaNavegador() {
		return vistaNavegador;
	}


	
	

	



	
	




	


	
	
	
	
	
	
	
	

}
