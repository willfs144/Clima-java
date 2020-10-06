package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;


public class VistaPrincipal extends JFrame {
	
	
	
	private JMenuBar menuBar;
	private JMenuItem menuItemNuevo;
	private JMenuItem menuItemAbrir;
	private JMenuItem menuItemGuardar;
	private JMenu menuArchivo;
	
	private VistaNavegador vistaNavegador;
	
	private Modelo modelo;
	private ControladorPrincipal controladorPrincipal;

	
	public VistaPrincipal(Modelo modelo) {
		this.modelo = modelo;
		this.controladorPrincipal = new ControladorPrincipal(this);
		this.setLayout(new BorderLayout());
		
		/*
		 * this.vistaDibujo = new VistaDibujo(modelo);
			this.getContentPane().add(vistaDibujo, BorderLayout.CENTER);
			this.vistaBotones = new VistaBotones(modelo);
			this.getContentPane().add(vistaBotones, BorderLayout.NORTH);
			this.vistaBotones.setLayout(new FlowLayout());	
		 */
		this.vistaNavegador = new VistaNavegador();
		this.getContentPane().add(vistaNavegador, BorderLayout.LINE_START);
		
		agregarArchivoMenuInterfaz();		
	}


	public VistaPrincipal() {
		// TODO Auto-generated constructor stub
	}


	private void agregarArchivoMenuInterfaz() {
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("Paint");
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
	




	


	
	
	
	
	
	
	
	

}
