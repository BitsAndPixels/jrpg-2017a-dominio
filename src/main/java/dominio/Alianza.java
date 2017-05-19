package dominio;

import java.util.LinkedList;

/**
 * <P>
 * Permite establecer las alianzas entre los personajes gestionando el listado
 * de personajes que se encuentran aliados. + Permite agregar personajes a la
 * alianza + Eliminar personajes de la alianza Un mismo personaje puede
 * pertenecer a varias alianzas y una alianza puede tener varios personajes.
 * 
 * @version 1.0
 * @author BitsAndPixels
 */
public class Alianza {

	/**
	 * Nombre Alianza.
	 */
	private String nombre;
	/**
	 * Personajes que incluye.
	 */
	private LinkedList<Personaje> aliados;

	/**
	 * @param nombre
	 *            alianza.
	 */
	public Alianza(final String nombre) {
		this.nombre = nombre;
		this.aliados = new LinkedList<Personaje>();
	}

	/**
	 * @return aliados.
	 * @see Alianza.copiaListaPersonaje
	 */
	public final LinkedList<Personaje> getAliados() {
		return Alianza.copiaListaPersonaje(aliados);
	}
	
	private static LinkedList<Personaje> copiaListaPersonaje(LinkedList<Personaje> lista){
		LinkedList<Personaje> listaRetorno = new LinkedList<>();
		for(int i = 0; i < lista.size(); i ++)
		listaRetorno.add(lista.get(i));
		return listaRetorno;
	}

	/**
	 * @return nombre.
	 */
	public final String obtenerNombre() {
		return nombre;
	}

	/**
	 * A través del paramétro perteneciente a la clase Personaje se puede
	 * eliminar el mismo de la lista de aliados.
	 * 
	 * @param pj
	 *            personaje a eliminar.
	 */
	public void eliminarPersonaje(final Personaje pj) {
		aliados.remove(pj);
	}

	/**
	 * @param pj
	 *            personaje a agregar.
	 */
	public void añadirPersonaje(final Personaje pj) {
		aliados.add(pj);
	}
}
