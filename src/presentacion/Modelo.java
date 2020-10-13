package presentacion;

import java.util.Arrays;
import logica.Sistema;

public class Modelo {
	
	
	private VistaTabla vistaTabla;
	private VistaNavegador vistaNavegador;
	
	private VistaPrincipal vistaPrincipal;
	private Sistema sistema;
	
public void iniciar() {		
	this.vistaPrincipal = new VistaPrincipal(this);
	this.vistaTabla = vistaPrincipal.getVistaTabla();
	this.vistaNavegador = vistaPrincipal.getVistaNavegador();
	this.vistaPrincipal.setSize(980, 700);
	this.vistaPrincipal.setVisible(true);		
	}
	
	public void abrir() {
		this.vistaPrincipal.showDialogAbrir();
		String  urlArchivo =  vistaPrincipal.getUrl();
		if (urlArchivo != null) {
			this.sistema = new Sistema(urlArchivo);
			this.vistaPrincipal.listarVariables(sistema.consultarVariables());
			this.vistaPrincipal.mostarTabla(sistema.consultarDatosVariables());
		}
		this.vistaPrincipal.setTitle("Clima: "+urlArchivo);
		
	}

	public void seleccionarFilaTabla() {
		int seleccionListaNavegador = vistaNavegador.getListaNavegador().getSelectedIndex();
		this.vistaTabla.seleccionarFilaTabla(seleccionListaNavegador);
	}

	public void seleccionarItemNavegador() {
		int filaTabla= vistaTabla.getTabla().getSelectedRow();
		this.vistaNavegador.seleccionarItemLista(filaTabla);		
	}

	public void mostrarMenuTablaDatos(int posicionX, int posicionY) {
		this.vistaTabla.mostrarMenu(posicionX, posicionY);
		
	}

	public void mostrarResultadoDeclaracion() {
		String seleccion = seleccionItemVariable();
		if (seleccion != null) {
			String resultado = sistema.consultarItemDeclaracion(seleccion);
			this.vistaPrincipal.mostrarVentanaResultados(resultado);
		}		
	}

	public void mostrarResultadoNcML() {		
		String seleccion = seleccionItemVariable();
		if (seleccion != null) {
			String resultado = sistema.consultarItemNcML(seleccion);
			this.vistaPrincipal.mostrarVentanaResultados(resultado);
		}
	}	

	public void mostrarResultadoDatos() {
		String seleccion = seleccionItemVariable();
		if (seleccion != null) {
			String resultado = sistema.consultarItemDatosVariable(seleccion);
			String resultados []= resultado.split(" ");
			this.vistaPrincipal.mostrarVentanaResultados(seleccion+" = "+Arrays.toString(resultados));
		}
		
	}

	public void mostrarResultadoTabla() {
		// TODO Auto-generated method stub
		
	}
	
	private String seleccionItemVariable() {
		String seleccion = vistaNavegador.getListaNavegador().getSelectedValue();
		if (seleccion != null) 
			return seleccion;
		else {
			this.vistaPrincipal.mostrarMensaje("Debe seleccionar una variable", "Aviso");
			return null;
		}
			
		
		
	}

}
