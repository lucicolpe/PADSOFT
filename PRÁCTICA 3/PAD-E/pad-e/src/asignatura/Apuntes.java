package asignatura;

import java.io.*;


/**
* Contiene los atributos y métodos de la clase Estudiante.
*
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

public class Apuntes extends Contenido implements Serializable{
	private String texto;

	public Apuntes(String nombre, boolean visibilidad, String texto) {
		super(nombre, visibilidad);
		this.texto = texto;
	}

	/**
	 * Devuelve el texto.
	 * 
	 * Este método devuelve el texto de los apuntes.
	 *  
	 * @return cadena que contiene el texto de los apuntes.
	 */
	
	public String getTexto() {
		return texto;
	}

	/**
	 * Modifica el texto.
	 * 
	 * Este método permite cambiar el texto de los apuntes.
	 * 
	 * @param texto nuevo que queremos que contengan los apuntes. 
	 */
	
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
