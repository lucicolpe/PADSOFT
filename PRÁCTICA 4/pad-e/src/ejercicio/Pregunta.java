package ejercicio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
* Contiene los atributos y métodos de la clase Estudiante.
*
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

public abstract class Pregunta implements Serializable{
	 private String enunciado;
	 private int numPregunta;
	 private double peso;
	 private double penalizacion;
	 private List<Respuesta> opciones;
	 private List<Respuesta> correctas;
	 private List<RespuestaPregunta> respuestas;
	 private EstadisticaPregunta estadistica;


	public Pregunta(String enunciado, int numPregunta, double peso, double penalizacion, List<Respuesta> opciones,
			List<Respuesta> correctas) {
		this.enunciado = enunciado;
		this.numPregunta = numPregunta;
		this.peso = peso;
		this.penalizacion = penalizacion;
		this.opciones = opciones;
		this.correctas = correctas;
		this.respuestas = new ArrayList<RespuestaPregunta>();
	}
	
	/**
	 * Devuelve el enunciado de la pregunta.
	 * 
	 * Este método devuelve el enunciado de la pregunta.
	 *  
	 * @return el enunciado de la pregunta.
	 */


	public String getEnunciado() {
		return this.enunciado;
	} 
	
	/**
	 * Modifica el enunciado de la pregunta.
	 * 
	 * Este método modifica el enunciado de la pregunta.
	 * 
	 * @param enunciado es el nuevo enunciado que se quiere introducir en la pregunta.
	 */

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	
	/**
	 * Devuelve el número de la pregunta.
	 * 
	 * Este método devuelve el número de la pregunta.
	 *  
	 * @return el número de la pregunta.
	 */

	public int getNumPregunta() {
		return this.numPregunta;
	}
	
	/**
	 * Modifica el número de la pregunta.
	 * 
	 * Este método modifica el número de la pregunta.
	 * 
	 * @param numPregunta es el nuevo número que se quiere introducir en la pregunta.
	 */

	public void setNumPregunta(int numPregunta) {
		this.numPregunta = numPregunta;
	}

	/**
	 * Devuelve el peso de la pregunta.
	 * 
	 * Este método devuelve el peso de la pregunta.
	 *  
	 * @return el peso de la pregunta.
	 */
	
	public double getPeso() {
		return this.peso;
	}

	/**
	 * Modifica el peso de la pregunta.
	 * 
	 * Este método modifica el peso de la pregunta.
	 * 
	 * @param peso es el nuevo peso que se quiere introducir en la pregunta.
	 */
	
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	/**
	 * Devuelve la penalización de la pregunta.
	 * 
	 * Este método devuelve la penalización de la pregunta.
	 *  
	 * @return la penalización de la pregunta.
	 */
	

	public double getPenalizacion() {
		return this.penalizacion;
	}
	
	/**
	 * Modifica la penalización de la pregunta.
	 * 
	 * Este método modifica la penalización de la pregunta.
	 * 
	 * @param penalizacion es la nueva penalización que se quiere introducir en la pregunta.
	 */

	public void setPenalizacion(int penalizacion) {
		this.penalizacion = penalizacion;
	}
	
	/**
	 * Devuelve la lista de respuestas que son opciones de la pregunta.
	 * 
	 * Este método devuelve la lista de respuestas que son opciones de la pregunta.
	 *  
	 * @return la lista de respuestas que son opciones de la pregunta.
	 */

	public List<Respuesta> getOpciones() {
		return this.opciones;
	}
	
	/**
	 * Modifica la lista de respuestas que son opciones de la pregunta.
	 * 
	 * Este método modifica la lista de respuestas que son opciones de la pregunta.
	 * 
	 * @param opciones es la nueva lista de respuestas que son opciones de la pregunta.
	 */

	public void setOpciones(List<Respuesta> opciones) {
		this.opciones = opciones;
	}
	
	/**
	 * Devuelve la lista de respuestas que son correctas de la pregunta.
	 * 
	 * Este método devuelve la lista de respuestas que son correctas de la pregunta.
	 *  
	 * @return la lista de respuestas que son correctas de la pregunta.
	 */

	public List<Respuesta> getCorrectas() {
		return this.correctas;
	}
	
	/**
	 * Modifica la lista de respuestas que son correctas de la pregunta.
	 * 
	 * Este método modifica la lista de respuestas que son correctas de la pregunta.
	 * 
	 * @param correctas es la nueva lista de respuestas que son correctas de la pregunta.
	 */

	public void setCorrectas(List<Respuesta> correctas) {
		this.correctas = correctas;
	}
	
	/**
	 * Devuelve la lista de respuestas de la pregunta.
	 * 
	 * Este método devuelve la lista de respuestas de la pregunta.
	 *  
	 * @return la lista de respuestas de la pregunta.
	 */

	public List<RespuestaPregunta> getRespuestas() {
		return this.respuestas;
	}
	
	/**
	 * Modifica la lista de respuestas de la pregunta.
	 * 
	 * Este método modifica la lista de respuestas de la pregunta.
	 * 
	 * @param respuestas es la nueva lista de respuestas de la pregunta.
	 */

	public void setRespuestas(List<RespuestaPregunta> respuestas) {
		this.respuestas = respuestas;
	}
	
	/**
	 * Devuelve la estadistica de la pregunta.
	 * 
	 * Este método devuelve la estadistica de la pregunta.
	 *  
	 * @return la estadistica de la pregunta.
	 */
	
	public EstadisticaPregunta getEstadistica() {
		return estadistica;
	}
	
	/**
	 * Modifica la estadistica de la pregunta.
	 * 
	 * Este método modifica la estadistica de la pregunta.
	 * 
	 * @param estadistica es la nueva estadistica de la pregunta.
	 */

	public void setEstadistica(EstadisticaPregunta estadistica) {
		this.estadistica = estadistica;
	}
	 
}
