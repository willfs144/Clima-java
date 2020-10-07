package presentacion;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class VistaTabla extends JPanel{
	
	private JTable tabla;
	private JScrollPane scrollpanel;
	
	
	public VistaTabla() {
		
		this.scrollpanel = new JScrollPane();
		this.add(scrollpanel);
		scrollpanel.setBounds(40,20,540,420);
		{
			String [][] datos = null;
			String [] titulos = new String[] {"nombre", "descripcion", "dimensiones", "tipodato", "grupo", "forma", "unidades"};
			TableModel modeloTabla = new DefaultTableModel(null, titulos);
			this.tabla = new JTable();
			this.tabla.setModel(modeloTabla);
			//this.tabla.setPreferredSize(new Dimension(800, 7*60));			
			this.tabla.getAutoResizeMode();
			this.scrollpanel.setViewportView(tabla);
			TableRowSorter<TableModel> ordenador = new TableRowSorter<TableModel>(modeloTabla);
			tabla.setRowSorter(ordenador);
		}
	}
	
	

}
