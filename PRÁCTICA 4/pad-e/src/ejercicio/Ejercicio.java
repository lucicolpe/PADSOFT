package ejercicio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import usuario.Estudiante;
import asignatura.Contenido;

/**
* Contiene los atributos y métodos de la clase Ejercicio.
*
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

public class Ejercicio extends Contenido implements Serializable{
	private int peso;
	private LocalDate fechaIni;
	private LocalDate fechaFin;
	private List<Pregunta> preguntas;
	private List<RespuestaEjercicio> respuestas;
	private boolean ordenAleatorio;
	private EstadisticaEjercicio estadisticas;
	
	public Ejercicio(String nombre, boolean visibilidad, int peso, LocalDate fechaIni,
			LocalDate fechaFin) {
		super(nombre, visibilidad);
		this.peso = peso;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.preguntas = new ArrayList<Pregunta>();
		this.respuestas = new ArrayList<RespuestaEjercicio>();
	}

	/**
	 * Devuelve el peso.
	 * 
	 * Este método devuelve el peso del ejercicio.
	 *  
	 * @return peso del ejercicio.
	 */

	
	public int getPeso() {
		return this.peso;
	}
	
	/**
	 * Modifica el peso.
	 * 
	 * Este método modifica el peso del ejercicio.
	 * 
	 * @param peso del ejercicio, el cual queremos modificar.  
	 */

	
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	/**
	 * Devuelve el orden aleatorio.
	 * 
	 * Este método devuelve el valor que va a determinar si es orden aleatorio o no.
	 *  
	 * @return boolean que es true si es orden aleatorio.
	 */
	
	public boolean isOrdenAleatorio() {
		return ordenAleatorio;
	}

	/**
	 * Modifica el orden aleatorio.
	 * 
	 * Este método modifica el valor que va a determinar si es orden aleatorio o no.
	 *  
	 * @param ordenAleatorio que va a modificar el orden aleatorio del ejercicio.
	 */
	
	
	public void setOrdenAleatorio(boolean ordenAleatorio) {
		this.ordenAleatorio = ordenAleatorio;
	}

	/**
	 * Devuelve la estadística del ejercicio.
	 * 
	 * Este método devuelve la estadística del ejercicio.
	 *  
	 * @return la estadística del ejercicio..
	 */
	
	public EstadisticaEjercicio getEstadisticas() {
		return estadisticas;
	}
	
	/**
	 * Modifica la estadística del ejercicio.
	 * 
	 * Este método modifica la estadística del ejercicio.
	 *  
	 * @param estadisticas que va a modificar la estadística del ejercicio.
	 */

	public void setEstadisticas(EstadisticaEjercicio estadisticas) {
		this.estadisticas = estadisticas;
	}
	
	/**
	 * Devuelve la fecha inicial del ejercicio.
	 * 
	 * Este método devuelve la fecha inicial del ejercicio.
	 *  
	 * @return la fecha inicial del ejercicio..
	 */

	public LocalDate getFechaIni() {
		return fechaIni;
	}

	/**
	 * Devuelve la fecha final del ejercicio.
	 * 
	 * Este método devuelve la fecha final del ejercicio.
	 *  
	 * @return la fecha final del ejercicio..
	 */
	
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	
	/**
	 * Añade una pregunta al ejercicio.
	 * 
	 * Este método añade una pregunta al ejercicio.
	 *
	 *  @param p es la pregunta que se va a añadir al ejercicio
	 */

	public void añadirPregunta(Pregunta p){
		this.preguntas.add(p);
	}
	
	/**
	 * Elimina una pregunta al ejercicio.
	 * 
	 * Este método elimina una pregunta al ejercicio.
	 *
	 *  @param p es la pregunta que se va a eliminar del ejercicio
	 */
	
	public void eliminarPregunta(Pregunta p){
		this.preguntas.remove(p);
	}
	
	/**
	 * Devuelve la lista de preguntas.
	 * 
	 * Este método devuelve la lista de preguntas que forman un ejercicio.
	 *  
	 * @return la lista de preguntas que forman el ejercicio..
	 */
	
	public List<Pregunta> getPreguntas() {
		return Collections.unmodifiableList(preguntas);
	}

	/**
	 * Añade una respuesta al ejercicio.
	 * 
	 * Este método añade una respuesta al ejercicio.  
	 * @param r es la respuesta del ejercicio a añadir.
	 */
	
	public void añadirRespuesta(RespuestaEjercicio r) {
		this.respuestas.add(r);
	}
	
	/**
	 * Devuelve la lista de respuestas al ejercicio.
	 * 
	 * Este método devuelve la lista de respuestas del ejercicio.
	 *  
	 * @return la lista respuestas del ejercicio.
	 */
	
	public List<RespuestaEjercicio> getRespuestasEjercicio() {
		return Collections.unmodifiableList(respuestas);
	}
	
	/**
	 * Permite ver la calificacion de un ejercicio.
	 * 
	 * Este método permite ver la respuesta a ejercicio y su calificacion.
	 *  
	 * @param e es el estudiante.
	 * @return la respuesta del ejercicio.
	 */
	
	public RespuestaEjercicio verCalificacionEjercicio(Estudiante e){
		for (RespuestaEjercicio re: this.respuestas) {
			if(re.getEstudiante() == e) {
				return re;
			}
		}
		return null;
	}
	
	/**
	 * Modifica la fecha de inicio del ejercicio.
	 * 
	 * Este método modifica la fecha de inicio del ejercicio.
	 *  
	 * @param fechaIni que va a modificar la fecha de inicio del ejercicio.
	 */
	
	public void modificarFechaIni(LocalDate fechaIni) {
		if(this.respuestas.size() == 0) {
			this.fechaIni = fechaIni;
		}
	}
	
	/**
	 * Modifica la fecha de fin del ejercicio.
	 * 
	 * Este método modifica la fecha de fin del ejercicio.
	 *  
	 * @param fechaFin que va a modificar la fecha de fin del ejercicio.
	 */
	
	public void modificarFechaFin(LocalDate fechaFin) {
		if(this.respuestas.size() > 0) {
			long dias = fechaFin.toEpochDay();
			long dias2 = this.fechaFin.toEpochDay();
			if(dias < dias2) {
				return;
			}
		}
		this.fechaFin = fechaFin;
	}
	
	/**
	 * Modifica la pregunta del ejercicio.
	 * 
	 * Este método modifica la pregunta del ejercicio.
	 *  
	 * @param numPregunta es el nuevo numero de la pregunta.
	 * @param enunciado es el nuevo enunciado de la pregunta.
	 * @param peso es el nuevo peso que va a tener la pregunta.
	 * @param penalizacion es la nueva penalización del ejercicio.
	 * @param opciones es la nueva lista de respuestas del ejercicio.
	 * @param correctas es la nueva lista de correctas del ejercicio.
	 */
	
	public void modificarPregunta(int numPregunta, String enunciado, int peso, int penalizacion, List<Respuesta> opciones,
			List<Respuesta> correctas) {
		
		if(this.respuestas.size() > 0) {
			return;
		}
		for(Pregunta p: this.preguntas) {
			if(p.getNumPregunta() == numPregunta) {
				p.setEnunciado(enunciado);
				p.setPeso(peso);
				p.setPenalizacion(penalizacion);
				p.setOpciones(opciones);
				p.setCorrectas(correctas);
			}
		}
	}
	
}
