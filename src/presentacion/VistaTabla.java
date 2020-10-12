package presentacion;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import logica.Variable;

public class VistaTabla extends JInternalFrame{
	
	private JTable tabla;
	private JScrollPane scrollpanel;
	private JPopupMenu popupMenu;
	private JMenuItem menuItemDeclaracion;
	private JMenuItem menuItemNcML;
	private JMenuItem menuItemDatos;
	private JMenuItem menuItemTabla;
	
	
	private String [][] datos = null;
	private String [] titulos = new String[] {"nombre", "descripcion", "dimensiones", "tipodato", "grupo", "forma", "unidades"};
	
	private Modelo modelo;
	private ControladorVistaTabla controladorVistaTabla;
	
	public VistaTabla(Modelo modelo) {
		this.modelo = modelo;
		this.controladorVistaTabla = new ControladorVistaTabla(this);
		
		this.setTitle("Tabla Variables Datos: ");
		this.scrollpanel = new JScrollPane();
		this.add(scrollpanel);
		scrollpanel.setBounds(40,20,540,420);
		{			
			TableModel modeloTabla = new DefaultTableModel(null, titulos);
			this.tabla = new JTable();
			this.tabla.setModel(modeloTabla);			
			this.tabla.getAutoResizeMode();
			this.scrollpanel.setViewportView(tabla);
			TableRowSorter<TableModel> ordenador = new TableRowSorter<TableModel>(modeloTabla);
			tabla.setRowSorter(ordenador);			
		}
		
		{
			this.popupMenu = new JPopupMenu();
			this.setComponentPopupMenu(popupMenu);
			{
				menuItemDeclaracion = new JMenuItem();
				popupMenu.add(menuItemDeclaracion);
				menuItemDeclaracion.setText("Mostrar Declaración");
			}
			{
				menuItemNcML = new JMenuItem();
				popupMenu.add(menuItemNcML);
				menuItemNcML.setText("Mostrar NcML");
			}
			{
				menuItemDatos = new JMenuItem();
				popupMenu.add(menuItemDatos);
				menuItemDatos.setText("Mostrar Datos");
			}
			{
				menuItemTabla = new JMenuItem();
				popupMenu.add(menuItemTabla);
				menuItemTabla.setText("Mostrar tabla de datos");
			}
			this.popupMenu.addMouseListener(controladorVistaTabla);
		}
		
		this.setVisible(true);
	}



	public void mostrarDatosVariables(String[][] variables) {
		
		TableModel modeloTabla = new DefaultTableModel(variables, titulos) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		this.tabla = new JTable();
		this.tabla.setModel(modeloTabla);			
		this.tabla.getAutoResizeMode();
		this.scrollpanel.setViewportView(tabla);
		TableRowSorter<TableModel> ordenador = new TableRowSorter<TableModel>(modeloTabla);
		tabla.setRowSorter(ordenador);
		this.tabla.addMouseListener(controladorVistaTabla);
		
	}

	public Modelo getModelo() {
		return modelo;
	}



	public void seleccionarFilaTabla(int fila) {		
		this.tabla.setRowSelectionInterval(fila, fila);		
	}



	public JTable getTabla() {
		return tabla;
	}



	public void mostrarMenu(int posicionX, int posicionY) {
		this.popupMenu.show(this.getParent(), posicionX, posicionY);
	}
	
	
	
	
	
	
	

}
