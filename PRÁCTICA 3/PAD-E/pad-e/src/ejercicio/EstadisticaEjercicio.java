package ejercicio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* Contiene los atributos y métodos de la clase Ejercicio.
*
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

public class EstadisticaEjercicio implements Serializable{
	private int numAlumnos;
	private int numRespuestas;
	private Ejercicio ejercicio;
	private List<EstadisticaPregunta> estpreg;
	
	public EstadisticaEjercicio(int numAlumnos, int numRespuestas) {
		this.numAlumnos = numAlumnos;
		this.numRespuestas = numRespuestas;
		this.estpreg = new ArrayList<EstadisticaPregunta>();
	}
	
	/**
	 * Devuelve el número de alumnos.
	 * 
	 * Este método devuelve el número de alumnos.
	 *  
	 * @return el número de alumnos.
	 */

	public int getNumAlumnos() {
		return this.numAlumnos;
	}
	
	/**
	 * Modifica el número de alumnos.
	 * 
	 * Este método modifica el número de alumnos.
	 *  
	 * @param numAlumnos es el nuevo número de alumnos.
	 */

	public void setNumAlumnos(int numAlumnos) {
		this.numAlumnos = numAlumnos;
	}
	
	/**
	 * Devuelve el número de respuestas.
	 * 
	 * Este método devuelve el número de respuestas.
	 *  
	 * @return el número de respuestas.
	 */

	public int getNumRespuestas() {
		return this.numRespuestas;
	}
	
	/**
	 * Modifica el número de respuestas.
	 * 
	 * Este método modifica el número de respuestas.
	 *  
	 * @param numRespuestas es el nuevo número de respuestas.
	 */

	public void setNumRespuestas(int numRespuestas) {
		this.numRespuestas = numRespuestas;
	}
	
	/**
	 * Devuelve la lista de estadísticas de las preguntas.
	 * 
	 * Este método devuelve el la lista de estadísticas de las preguntas.
	 *  
	 * @return la lista de estadísticas de las preguntas.
	 */
	
	public List<EstadisticaPregunta> getEstpreg() {
		return Collections.unmodifiableList(estpreg);
	}
	
	/**
	 * Añade una estadística de una pregunta.
	 * 
	 * Este método añade una estadística nueva de una pregunta a la lista de estadísticas de preguntas. 
	 * 
	 * @param ep es la nueva estadística de la pregunta.
	 */
	
	public void añadirEstadisticaPregunta(EstadisticaPregunta ep){
		this.estpreg.add(ep);		
	}
	
	/**
	 * Genera una gráfica.
	 * 
	 * Este método genera una gráfica obtenida a partir de la estadística de cada pregunta.
	 * 
	 * @return la lista de enteros obtenidos en la estadística de cada ejercicio.
	 */

	public List<Integer> generarGrafica(){
		int acertadas = 0;
		int falladas = 0;
		int noRespondidas = 0;
		for(EstadisticaPregunta e: estpreg) {
			acertadas += e.getNumAciertos();
			falladas += e.getNumFallos();
			noRespondidas += e.getNumSinContestar();
		}
		List<Integer> l = new ArrayList<Integer>(3);
		l.add(acertadas); l.add(falladas); l.add(noRespondidas);
		return l;
	}
	
}
