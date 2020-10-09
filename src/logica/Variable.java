package logica;

import java.util.List;
import persistencia.LeerArchivo;
import persistencia.VariableDAO;

public class Variable {
	
	private String url;
	private String nombre;
	private int [] forma;
	private String tipoDato;
	
	private Dimension dimension;
	private Atributo atributo;
	
	private LeerArchivo leerArchivo;
	private VariableDAO variableDAO;
			
	public Variable(String rutaArchivo) {
		this.leerArchivo = new LeerArchivo(rutaArchivo);
		this.variableDAO= new VariableDAO(leerArchivo.getNcfile());	
	}
	

	public Variable() {
	}

	public List consultar() {			
		return variableDAO.consultar();	
	}

	public List buscarDatos(String filtro) {
		return (List) variableDAO.buscarDatos(filtro);
	}
	
	
	public int [] buscarForma(String nombre) {
		return  variableDAO.buscarForma(nombre);
	}
	
	public String buscarTipoDato(String nombre) {
		return  variableDAO.buscarTipoDato(nombre);
	}
	
	
	public String buscarDimension(String nombre) {
		return  variableDAO.buscarDimension(nombre);
	}
	
	public String buscarDescripcion(String nombre) {
		return  variableDAO.buscarDescripcion(nombre);
	}
	
	public String buscarGrupo(String nombre) {
		return  variableDAO.buscarGrupo(nombre);
	}
	
	public String buscarUnidades(String nombre) {
		return  variableDAO.buscarUnidades(nombre);
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int[] getForma() {
		return forma;
	}

	public void setForma(int[] forma) {
		this.forma = forma;
	}

	public String getTipoDato() {
		return tipoDato;
	}

	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}
		
	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public Atributo getAtributo() {
		return atributo;
	}


	public void setAtributo(Atributo atributo) {
		this.atributo = atributo;
	}


	

}
