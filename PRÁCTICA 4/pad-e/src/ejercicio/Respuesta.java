package ejercicio;

import java.io.Serializable;
import java.util.List;

/**
* Contiene los atributos y métodos de la clase Estudiante.
*
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/


public class Respuesta implements Serializable{
	private String texto;
	private List<String> textoMultiples;
	private boolean multiples;

	public Respuesta(String texto) {
		this.texto = texto;
		this.multiples = false;
	}
	
	public Respuesta(List<String> textoMultiples) {
		this.textoMultiples = textoMultiples;
		this.multiples = true;
	}

	/**
	 * Devuelve el texto de la respuesta.
	 * 
	 * Este método devuleve el texto de la respuesta.
	 *  
	 * @return el texto de la respuesta.
	 */
	
	public String getTexto() {
		return texto;
	}

	/**
	 * Modifica el texto de la respuesta.
	 * 
	 * Este método modifica el texto de la respuesta.
	 * 
	 * @param texto que es el nuevo texto de la respuesta.
	 */
	
	public void setTexto(String texto) {
		if(this.multiples == false) {
			this.texto = texto;
		}
	}
	
	/**
	 * Devuelve los textos de las posibles respuestas a una pregunta.
	 * 
	 * Este método devuleve los textos de las posibles respuestas a una pregunta.
	 *  
	 * @return los textos de las posibles respuestas a una pregunta.
	 */

	public List<String> getTextoMultiples() {
		return textoMultiples;
	}
	
	/**
	 * Modifica los textos de las posibles respuestas a una pregunta.
	 * 
	 * Este método modifica los textos de las posibles respuestas a una pregunta.
	 * 
	 * @param textoMultiples son los textos de las posibles respuestas a una pregunta.
	 */

	public void setTextoMultiples(List<String> textoMultiples) {
		if(this.multiples == true) {
			this.textoMultiples = textoMultiples;
		}
	}
	
	/**
	 * Comprueba si una respuesta es de múltiples opciones o no.
	 * 
	 * Este método comprueba si una respuesta es de múltiples opciones o no.
	 * 
	 * @return si es múltiple o no.
	 */
	public boolean isMultiples() {
		return multiples;
	}
	
	/**
	 * Compara dos respuestas.
	 * 
	 * @param obj es la respuesta a comparar.
	 * @return true si son iguales, false en caso contrario.
	 */

	public boolean equals(Object obj){
		if(obj instanceof Respuesta){
			Respuesta res = (Respuesta) obj;
			if (this.multiples == false && res.multiples == false){
				return this.texto.equals(res.texto);				
			}else if(this.multiples == true && res.multiples == true){
				return this.textoMultiples.equals(res.textoMultiples);
			}
		}
		return false;
	}
	
}
