package ejercicio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import usuario.Estudiante;

/**
* Contiene los atributos y métodos de la clase Estudiante.
*
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/


public class RespuestaEjercicio implements Serializable{
	private double nota;
	private Estudiante estudiante;
	private List<RespuestaPregunta> respuestas;

	public RespuestaEjercicio(Estudiante e) {
		this.nota = -1;
		this.estudiante = e;
		this.respuestas = new ArrayList<RespuestaPregunta>();
	}
	
	/**
	 * Devuelve la nota.
	 * 
	 * Este método devuelve la nota.
	 *  
	 * @return la nota.
	 */

	public double getNota() {
		return this.nota;
	}
	
	/**
	 * Modifica la nota.
	 * 
	 * Este método modifica la nota.
	 * 
	 * @param nota que es la nueva nota.
	 */

	public void setNota(double nota) {
		this.nota = nota;
	}
	
	/**
	 * Devuelve el estudiante.
	 * 
	 * Este método devuelve el estudiante.
	 *  
	 * @return el estudiante.
	 */
	
	public Estudiante getEstudiante() {
		return this.estudiante;
	}
	
	/**
	 * Añade una respuesta a la lista de respuestas del ejercicio.
	 * 
	 * Este método añade una respuesta a la lista de respuestas del ejercicio.
	 * 
	 * @param respuesta que se va a añadir.
	 */
	
	public void añadirRespuesta(RespuestaPregunta respuesta) {
		this.respuestas.add(respuesta);
	}
	
	/**
	 * Devuelve la lista de respuestas a las pregunta.
	 * 
	 * Este método devuelve la lista de respuestas a la pregunta.
	 *  
	 * @return la lista de respuestas a la pregunta.
	 */

	public List<RespuestaPregunta> getRespuestas() {
		return respuestas;
	}
	
	/**
	 * Obtiene la calificación de un ejercicio.
	 * 
	 * Este método obtiene la calificación de un ejercicio.
	 *  
	 * @return la calificación del ejercicio.
	 */

	public double obtenerCalificacion(){
		double nota = 0;
		double peso = 0;
		for(RespuestaPregunta re: this.respuestas) {
			peso += re.getPregunta().getPeso();
			if(re.comprobarRespuesta() == true)  {
				nota += re.getPregunta().getPeso();
			} else {
				nota -= re.getPregunta().getPenalizacion();
			}
		}
		nota = 10*nota/peso;
		if(nota < 0) {
			return 0;
		}
		this.nota = nota;
		return nota;
	}
}
