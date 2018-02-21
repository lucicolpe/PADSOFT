package ejercicio;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import usuario.Estudiante;

/**
* Contiene los atributos y métodos de la clase Estudiante.
*
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

public class RespuestaPregunta implements Serializable{
	private Respuesta respuesta;
	private int nota;
	private Pregunta pregunta;
	private Estudiante estudiante;
	
	public RespuestaPregunta(Respuesta respuesta, Pregunta pregunta, Estudiante estudiante) {
		this.respuesta = respuesta;
		this.pregunta = pregunta;
		this.estudiante = estudiante;
	}
	
	/**
	 * Devuelve la respuesta a la pregunta.
	 * 
	 * Este método devuelve la respuesta a la pregunta.
	 *  
	 * @return la lista de respuesta a la pregunta.
	 */

	public Respuesta getRespuesta() {
		return this.respuesta;
	}
	
	/**
	 * Modifica la respuesta a la pregunta.
	 * 
	 * Este método modifica la respuesta a la pregunta.
	 * 
	 * @param respuesta nueva que queremos introducir.
	 */

	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}
	
	/**
	 * Devuelve la nota.
	 * 
	 * Este método devuelve la nota.
	 *  
	 * @return la nota.
	 */

	public int getNota() {
		return this.nota;
	}
	
	/**
	 * Modifica la nota.
	 * 
	 * Este método modifica la nota.
	 * 
	 * @param nota que es la nueva nota.
	 */

	public void setNota(int nota) {
		this.nota = nota;
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
	 * Devuelve el estudiante.
	 * 
	 * Este método devuelve el estudiante.
	 * 
	 * @return el estudiante.
	 */

	public Estudiante getEstudiante() {
		return estudiante;
	}
	
	/**
	 * Comprueba si la respuesta es correcta.
	 * 
	 * Este método comprueba si la respuesta es correcta o no.
	 * 
	 * @return boolean definiendo si es correcta o incorrecta la respuesta a la pregunta.
	 */

	public boolean comprobarRespuesta(){
		List<Respuesta> correctas = this.pregunta.getCorrectas();
		for(Respuesta r: correctas) {
			if(!r.isMultiples()) {
				if(this.respuesta.getTexto().equals(r.getTexto())) {
					return true;
				}
			} else {
				List<String> l = this.getRespuesta().getTextoMultiples();
				List<String> c = r.getTextoMultiples();
				Collections.sort(l);
				Collections.sort(c);
				if(l.equals(c)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean equals (Object obj){
		if (obj instanceof RespuestaPregunta){
			RespuestaPregunta rp = (RespuestaPregunta) obj;
			if(this.pregunta == rp.pregunta && this.estudiante == rp.estudiante){
				return this.respuesta.equals(rp.respuesta);
			}
		}
		return false;
	}

}
