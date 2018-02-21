package ejercicio;

import java.io.Serializable;
import java.util.List;

import usuario.Estudiante;

/**
* Contiene los atributos y métodos de la clase Estudiante.
*
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

public class PreguntaTest extends Pregunta implements Serializable{
	private boolean ordenAleatorioRespuestas;
	
	public PreguntaTest(String enunciado, int numPregunta, double peso, double penalizacion, List<Respuesta> opciones,
			List<Respuesta> correctas) {
		super(enunciado, numPregunta, peso, penalizacion, opciones, correctas);
	}
	
	/**
	 * Devuelve si el orden de las posibles respuestas es aleatorio.
	 * 
	 * Este método devuelve si el orden de las posibles respuestas es aleatorio.
	 * 
	 * @return boolean que nos dice si el orden de las posibles respuestas es aleatorio.
	 */
	
	
	public boolean getordenAleatorioRespuestas() {
		return ordenAleatorioRespuestas;
	}
	
	/**
	 * Modifica el orden de las posibles respuestas es aleatorio.
	 * 
	 * Este método modifica el orden de las posibles respuestas es aleatorio.
	 * 
	 * @param ordenAleatorioRespuestas boolean que nos dice si el orden de las posibles respuestas es aleatorio.
	 */


	public void setOrdenAleatorioRespuestas(boolean ordenAleatorioRespuestas) {
		this.ordenAleatorioRespuestas = ordenAleatorioRespuestas;
	}
	
	/**
	 * Responde a una pregunta.
	 * 
	 * Este método se encarga de que un estudiante pueda responder a una pregunta.
	 * 
	 * @param e es el estudiante que va a responder a la pregunta.
	 * @param respuesta es la respuesta que ha realizado el estudiante.
	 * @return la respuesta de la pregunta.
	 */

	public RespuestaPregunta responderPregunta(Estudiante e, String respuesta) {
		Respuesta r = new Respuesta(respuesta);
		RespuestaPregunta rp = new RespuestaPregunta(r, this, e);
		return rp;
	}
	
	
}
