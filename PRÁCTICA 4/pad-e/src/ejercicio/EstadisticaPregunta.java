package ejercicio;

import java.io.Serializable;

/**
* Contiene los atributos y métodos de la clase Ejercicio.
*
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

public class EstadisticaPregunta implements Serializable{
	private int numAciertos;
	private int numFallos;
	private int numSinContestar;
	private Pregunta pregunta;
	
	public EstadisticaPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
		this.numAciertos = 0;
		this.numFallos = 0;
		this.numSinContestar = 0;
	}

	/**
	 * Devuelve la pregunta.
	 * 
	 * Este método devuelve la pregunta.
	 *  
	 * @return la pregunta.
	 */
	
	public Pregunta getPregunta() {
		return pregunta;
	}

	/**
	 * Devuelve el número de aciertos.
	 * 
	 * Este método devuelve el número de aciertos.
	 *  
	 * @return el número de aciertos.
	 */

	
	public int getNumAciertos() {
		return this.numAciertos;
	}
	
	/**
	 * Modifica el número de aciertos.
	 * 
	 * Este método modifica el número de aciertos.
	 *  
	 * @param numAciertos es el nuevo número de aciertos.
	 */

	public void setNumAciertos(int numAciertos) {
		this.numAciertos = numAciertos;
	}
	
	/**
	 * Devuelve el número de fallos.
	 * 
	 * Este método devuelve el número de fallos.
	 *  
	 * @return el número de fallos.
	 */

	public int getNumFallos() {
		return this.numFallos;
	}

	/**
	 * Modifica el número de fallos.
	 * 
	 * Este método modifica el número de fallos.
	 *  
	 * @param numFallos es el nuevo número de fallos.
	 */
	
	public void setNumFallos(int numFallos) {
		this.numFallos = numFallos;
	}
	
	/**
	 * Devuelve el número de preguntas sin contestar.
	 * 
	 * Este método devuelve el número de preguntas sin contestar.
	 *  
	 * @return el número de preugntas sin contestar.
	 */

	public int getNumSinContestar() {
		return this.numSinContestar;
	}
	
	/**
	 * Modifica el número de preguntas sin contestar.
	 * 
	 * Este método modifica el número de preguntas sin contestar.
	 *  
	 * @param numSinContestar es el nuevo número de preguntas sin contestar.
	 */

	public void setNumSinContestar(int numSinContestar) {
		this.numSinContestar = numSinContestar;
	}
	
	
	
	
}
