package usuario;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import asignatura.*;
import ejercicio.*;
import sistema.Sistema;

/**
* Contiene los atributos y métodos de la clase Estudiante.
*
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

public class Estudiante extends Usuario implements Serializable{
	private String nombre;
	private String apellidos;
	private int nia;
	private String correo;
	private List<Asignatura> asignaturas;
	private List<CalificacionAsignatura> calificaciones;

	public Estudiante(String usuario, String contraseña, String nombre, String apellidos, int nia, String correo) {
		super(usuario, contraseña);
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nia = nia;
		this.correo = correo;
		this.asignaturas = new ArrayList<Asignatura>(30);
		this.calificaciones = new ArrayList<CalificacionAsignatura>(30);
	}
	
	/**
	 * Devuelve el nombre.
	 * 
	 * Este método devuelve el nombre del estudiante.
	 *  
	 * @return cadena que contiene el nombre del estudiante.
	 */

	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Modifica el nombre.
	 * 
	 * Este método permite cambiar el nombre del estudiante
	 * 
	 * @param nombre nuevo que queremos que el estudiante tenga. 
	 */
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Devuelve los apellidos.
	 * 
	 * Este método devuelve los apellidos del estudiante.
	 *  
	 * @return cadena que contiene los apellidos del estudiante.
	 */
	public String getApellidos() {
		return this.apellidos;
	}

	/**
	 * Modifica los apellidos.
	 * 
	 * Este método permite cambiar los apellidos del estudiante.
	 * 
	 * @param apellidos nuevos que queremos que el estudiante tenga. 
	 */
	
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Devuelve el nia.
	 * 
	 * Este método devuelve el nia del estudiante.
	 *  
	 * @return cadena que contiene el nia del estudiante.
	 */
	
	public int getNia() {
		return this.nia;
	}

	
	/**
	 * Modifica el nia.
	 * 
	 * Este método permite cambiar el nia del estudiante.
	 * 
	 * @param nia nuevo que queremos que el estudiante tenga. 
	 */
	
	
	public void setNia(int nia) {
		this.nia = nia;
	}

	/**
	 * Devuelve el correo electrónico.
	 * 
	 * Este método devuelve el correo electrónico del estudiante.
	 *  
	 * @return cadena que contiene el correo electrónico del estudiante.
	 */
	
	public String getCorreo() {
		return this.correo;
	}
	
	/**
	 * Modifica el correo electrónico.
	 * 
	 * Este método permite cambiar el correo electrónico del estudiante
	 * 
	 * @param correo nuevo que queremos que el estudiante tenga. 
	 */
	

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	/**
	 * Devuelve la lista de Asignaturas que tiene un estudiante.
	 * 
	 * Este método devuelve la lista de Asignaturas del estudiante y que,por tanto, estarán matriculados en ellos.
	 *  
	 * @return la lista de las aignaturas en las que el estudiante está matriculado.
	 */
	
	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	/**
	 * Modifica la lista de Asignaturas.
	 * 
	 * Este método permite modificar la lista de asignaturas del estudiante
	 * 
	 * @param asignaturas que queremos que el estudiante pueda modificar. 
	 */
	
	
	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	/**
	 * Añade una asignatura.
	 * 
	 * Este método permite al estudiante añadir una asignatura a su lista de asignaturas. 
	 * 
	 * @param a es la asignatura que el estudiante va a añadir a la lista
	 * @return true si consigue añadir la asignatura a la lista con éxito.
	 */

	public boolean añadirAsignatura(Asignatura a) {
		return this.asignaturas.add(a);
	}
	
	
	/**
	 * Elimina una asignatura.
	 * 
	 * Este método permite al estudiante eliminar una asignatura de su lista.
	 * 
	 * @param a es la asignautra que el estudiante va a eliminar de la lista.
	 * @return true si consigue añadir la asignatura a la lista con éxito.
	 */
	public boolean eliminarAsignatura(Asignatura a) {
		return this.asignaturas.remove(a);
	}
	
	/**
	 * Responde a una pregunta.
	 * 
	 * Este método permite al estudiante reponder una pregunta.
	 * 
	 * @param p es la pregunta a la que el estudiante va a contestar.
	 * @param respuesta que va a dar a la pregunta.
	 * @return RespuestaPregunta que es la respuesta de la pregunta.
	 */

	public RespuestaPregunta responderPregunta(Pregunta p, String respuesta) {
		Respuesta r = new Respuesta(respuesta);
		RespuestaPregunta rp = new RespuestaPregunta(r, p, this);
		EstadisticaPregunta estpreg =rp.getPregunta().getEstadistica(); 
		if(respuesta == null){
			estpreg.setNumSinContestar(estpreg.getNumSinContestar()+1);
		}else if (rp.comprobarRespuesta()){
			estpreg.setNumAciertos(estpreg.getNumAciertos()+1);
		}else{
			estpreg.setNumFallos(estpreg.getNumFallos()+1);
		}
		return rp;
	}
	
	/**
	 * Responde a una pregunta.
	 * 
	 * Este método permite al estudiante reponder una pregunta.
	 * 
	 * @param p es la pregunta a la que el estudiante va a contestar.
	 * @param respuestas que va a dar a la pregunta que es posile que sean más de una.
	 * @return RespuestaPregunta que es la respuesta de la pregunta.
	 */
	
	public RespuestaPregunta responderPregunta(Pregunta p, List<String> respuestas) {
		Respuesta r = new Respuesta(respuestas);
		RespuestaPregunta rp = new RespuestaPregunta(r, p, this);
		EstadisticaPregunta estpreg =rp.getPregunta().getEstadistica(); 
		if(respuestas == null){
			estpreg.setNumSinContestar(estpreg.getNumSinContestar()+1);
		}else if (rp.comprobarRespuesta()){
			estpreg.setNumAciertos(estpreg.getNumAciertos()+1);
		}else{
			estpreg.setNumFallos(estpreg.getNumFallos()+1);
		}
		
		return rp;
	}
	
	/**
	 * Responde a un ejercicio.
	 * 
	 * Este método permite al estudiante responder a un ejercicio.
	 * 
	 * @param e es el ejercicio al que va a responder el estudiante.
	 * @param respuestas lista de respuesta que da el estudiante para responder al ejercicio.
	 */
	
	public void responderEjercicio(Ejercicio e, List<RespuestaPregunta> respuestas){
		if(e.getFechaIni().toEpochDay() > LocalDate.now().toEpochDay() || e.getFechaFin().toEpochDay() < LocalDate.now().toEpochDay()) {
			return;
		}
		RespuestaEjercicio respuesta = new RespuestaEjercicio(this);
		int i;
		for(i = 0; i < e.getPreguntas().size(); i++) {
			respuesta.añadirRespuesta(respuestas.get(i));

		}
		e.añadirRespuesta(respuesta);
		respuesta.obtenerCalificacion();
	}
	
	/**
	 * Añade una calificacion al estudiante.
	 * 
	 * Este método permite al estudiante añadir una calificación a su lista de calificaciones.
	 * 
	 * @param a es la asignatura de la cual vamos a añadir una calificación.
	 */
	
	public void añadirCalificacion (Asignatura a){
		CalificacionAsignatura ca = new CalificacionAsignatura (a);
		this.calificaciones.add(ca);
		a.añadirCalificacion(ca);
	}
	
	/**
	 * Permite ver las calificaiones.
	 *
	 * Este método permite al estudiante ver la calificaión que tiene en una cierta asignatura.
	 * 
	 * @param a es la asignatura de la cual el estudante quiere ver su calificación.
	 * @return CalificacionAsignatura devuelve la calificación que el estudiante quería ver.
	 */
	
	public CalificacionAsignatura verCalificacion (Asignatura a){
		for (CalificacionAsignatura c: this.calificaciones) {
			if(c.getAsignatura() == a) {
				return c;
			}
		}
		return null;
	}
	
	/**
	 * Envia una peticion de admisión.
	 * 
	 * Este método permite al estudiante enviar una petición de admisión.
	 * 
	 * @param a es la asignatura de la cual se quiere enviar la petición.
	 * @param textoOpcional es un texto por si el etudiante quiere adjuntar un texto con la petición.
	 * @return PeticionAdmision es la petición que el estudiante envía.
	 */
	
	public PeticionAdmision enviarPeticionAdmision(Asignatura a, String textoOpcional){
		PeticionAdmision pe = new PeticionAdmision(textoOpcional, this, a);
		Sistema sistema = Sistema.getSistema();
		sistema.añadirPeticion(pe);
		return pe;
	}
	
	/**
	 * Permite ver los apuntes.
	 * 
	 * ESte método permite ver los apuntes de una asignatura por el estudiante.
	 * 
	 * @param a son los apuntes que el estudiante quiere ver.
	 * @return el texto de los apuntes.
	 */
	
	public String verApuntes(Apuntes a){
		return a.getTexto();
	}
	
	/**
	 * Permite ver la respuesta de un ejercicio.
	 * 
	 * Este método permite ver la respuesta de un ejercicio por parte de un estudiante.
	 * 
	 * @param e es el ejericio del cul se va a ver l respuesta.
	 * @return la respuesta del ejercicio.
	 */
	
	public RespuestaEjercicio verRespuesta(Ejercicio e){
		return e.verCalificacionEjercicio(this);
	}
	
	
	
}
