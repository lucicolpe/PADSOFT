package asignatura;

import java.io.Serializable;

/**
* Contiene los atributos y métodos de la clase Contenido.
*
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

public abstract class Contenido implements Serializable {
	private String nombre;
	private boolean visibilidad;
	
	public Contenido(String nombre, boolean visibilidad) {
		this.nombre = nombre;
		this.visibilidad = visibilidad;
	}
	
	/**
	 * Devuelve el nombre.
	 * 
	 * Este método devuelve el nombre del contenido.
	 *  
	 * @return cadena que contiene el nombre del contenido.
	 */

	public String getNombre() {
		return nombre;
	}

	/**
	 * Modifica el nombre.
	 * 
	 * Este método permite cambiar el nombre del contenido
	 * 
	 * @param nombre nuevo que queremos que el contenido tenga. 
	 */
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Devuelve la visibilidad.
	 * 
	 * Este método devuelve la visibilidad del contenido.
	 *  
	 * @return visibilidad del contenido.
	 */
	
	public boolean isVisible() {
		return visibilidad;
	}
	
	/**
	 * Hace visible un contenido.
	 * 
	 * Este método permite hacer visible un contenido.
	 */

	public void hacerVisible(){
		this.visibilidad = true;
	}
	
	/**
	 * Hace invisible un contenido.
	 * 
	 * Este método permite hacer invisible un contenido.
	 */

	
	public void hacerInvisible(){
		this.visibilidad = false;
	}
	
	
}
