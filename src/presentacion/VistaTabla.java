package presentacion;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import logica.Variable;

public class VistaTabla extends JInternalFrame{
	
	private JTable tabla;
	private JScrollPane scrollpanel;
	
	String [][] datos = null;
	String [] titulos = new String[] {"nombre", "descripcion", "dimensiones", "tipodato", "grupo", "forma", "unidades"};
	
	
	public VistaTabla() {
		
		this.scrollpanel = new JScrollPane();
		this.add(scrollpanel);
		scrollpanel.setBounds(40,20,540,420);
		{
			
			TableModel modeloTabla = new DefaultTableModel(null, titulos);
			this.tabla = new JTable();
			this.tabla.setModel(modeloTabla);
			//this.tabla.setPreferredSize(new Dimension(800, 7*60));			
			this.tabla.getAutoResizeMode();
			this.scrollpanel.setViewportView(tabla);
			TableRowSorter<TableModel> ordenador = new TableRowSorter<TableModel>(modeloTabla);
			tabla.setRowSorter(ordenador);
		}
		this.setTitle("Tabla Variables Datos: ");
		this.setVisible(true);
	}


	public void mostrarDatosVariables(String[][] variables) {
		
		TableModel modeloTabla = new DefaultTableModel(variables, titulos);
		this.tabla = new JTable();
		this.tabla.setModel(modeloTabla);
		//this.tabla.setPreferredSize(new Dimension(800, 7*60));			
		this.tabla.getAutoResizeMode();
		this.scrollpanel.setViewportView(tabla);
		TableRowSorter<TableModel> ordenador = new TableRowSorter<TableModel>(modeloTabla);
		tabla.setRowSorter(ordenador);
		
	}
	
	

}
