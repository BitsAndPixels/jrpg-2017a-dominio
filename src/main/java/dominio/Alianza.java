package dominio;

import java.util.LinkedList;


/**
 * <P> Permite establecer las alianzas entre los personajes gestionando 
 * el listado de personajes que se encuentran aliados.
 * 	+ Permite agregar personajes a la alianza
 * 	+ Eliminar personajes de la alianza
 *  Un mismo personaje puede pertenecer a varias alianzas y una alianza puede tener varios
 *  personajes
 */

public class Alianza {

	String nombre;
	LinkedList<Personaje> aliados;

	public Alianza(String nombre) {
		this.nombre = nombre;
		this.aliados = new LinkedList <Personaje>();
	}

	public LinkedList<Personaje> getAliados() {
		return aliados;
	}
	
	/**
	 * Este método permite establecer una lista que viene por parametro de personajes 
	 * que se encuentran aliados
	 * @param aliados -> Perteneciente a la Clase LinkedList 
	 */
	public void setAliados(LinkedList<Personaje> aliados) {
		this.aliados = aliados;
	}

	public String obtenerNombre(){
		return nombre;
	}
	
	
	/**
	 * 	A través del paramétro perteneciente a la clase Personaje se puede eliminar el 
	 * 	mismo de la lista de aliados
	 * 	@param pj
	 */
	public void eliminarPersonaje(Personaje pj){
		aliados.remove(pj);
	}
	
	public void añadirPersonaje(Personaje pj){
		aliados.add(pj);
	}
}
