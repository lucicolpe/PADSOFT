package asignatura;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sistema.Sistema;
import usuario.Estudiante;
import ejercicio.Ejercicio;
import ejercicio.EstadisticaEjercicio;
import ejercicio.EstadisticaPregunta;
import ejercicio.Pregunta;


/**
* Contiene los atributos y métodos de la clase Asignatura.
*
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

public class Asignatura implements Serializable {
	
	private String nombre;
	private int numEstudiantes;
	private List<Contenido> contenidos;
	private List<Estudiante> expulsados;
	private List<CalificacionAsignatura> calificaciones;
	
	public Asignatura(String nombre) {
		this.nombre = nombre;
		this.contenidos = new ArrayList<Contenido>();
		this.expulsados = new ArrayList<Estudiante>();
		this.calificaciones = new ArrayList<CalificacionAsignatura>();
	}
	
	/**
	 * Devuelve el nombre.
	 * 
	 * Este método devuelve el nombre de la asignatura.
	 *  
	 * @return cadena que contiene el nombre de la asignatura.
	 */

	public String getNombre() {
		return this.nombre;
	}
	
	/**
	 * Modifica el nombre.
	 * 
	 * Este método permite cambiar el nombre de la asignatura.
	 * 
	 * @param nombre nuevo que queremos que tenga la asignatura. 
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Devuelve el número de estudiantes.
	 * 
	 * Este método devuelve el número de estudiantes de la asignatura.
	 *  
	 * @return número de estudiantes de la asignatura.
	 */

	public int getNumEstudiantes() {
		return this.numEstudiantes;
	}
	
	/**
	 * Devuelve la lista de contenidos.
	 * 
	 * Este método devuelve la lista de contenidos de la asignatura.
	 *  
	 * @return la lista de contenidos de la asignatura que no se pueda modificar.
	 */
	
	public List<Contenido> getcontenidos() {
		return Collections.unmodifiableList(contenidos);
	}
	
	/**
	 * Devuelve la lista de expulsados.
	 * 
	 * Este método devuelve la lista de expulsados de la asignatura.
	 *  
	 * @return la lista de expulsados de la asignatura que no se pueda modificar.
	 */
	
	public List<Estudiante> getExpulsados() {
		return Collections.unmodifiableList(expulsados);
	}

	/**
	 * Da de alta en una asignatura.
	 * 
	 * Este método permite que se dé de alta a un estudiante en una asignatura.
	 * 
	 * @param e es el estudiante al cual se va a dar de alta en dicha asignatura.
	 */
	
	public void darDeAlta (Estudiante e){
		e.añadirAsignatura(this);
		this.numEstudiantes++;
		e.añadirCalificacion(this);
		if(this.expulsados.contains(e)) {
			this.expulsados.remove(e);
		}
	}
	
	/**
	 * Da de baja en una asignatura.
	 * 
	 * Este método permite que se dé de baja a un estudiante en una asignatura.
	 * 
	 * @param e es el estudiante al cual se va a dar de baja en dicha asignatura.
	 */
	
	public void darDeBaja (Estudiante e){
		e.eliminarAsignatura(this);
		this.numEstudiantes--;
		this.expulsados.add(e);
	}
	
	/**
	 * Añade un tema.
	 * 
	 * Este método permite que se pueda añadir un tema en una asignautura.
	 * 
	 * @param nombre del tema que se va a añadir.
	 * @return Tema que se añade.
	 */
	
	public Tema añadirTema(String nombre){
		Tema t = new Tema(nombre, false);
		this.contenidos.add(t);
		return t;
	}
	
	/**
	 * Elimina un tema.
	 * 
	 * Este método permite que se pueda eliminar un tema en una asignatura.
	 * 
	 * @param t es el tema que se va a eliminar.
	 */
	

	public void eliminarTema(Tema t){
		this.contenidos.remove(t);
	}
	
	/**
	 * Añade un ejercicio.
	 * 
	 * Este método permite que se añada un ejercicio en una asignatua.
	 *  
	 * @param nombre del ejercicio a añadir.
	 * @param peso del ejercicio a añadir.
	 * @param fechaIni que será la fecha de inicio del ejercicio.
 	 * @param fechaFin que será la fecha de fin del ejercicio.
	 * @param preguntas es la lista de preguntas de las que va a estar formado el ejercicio.
	 * @return Ejercicio que se añade.
	 */
	
	public Ejercicio añadirEjercicio(String nombre, int peso, LocalDate fechaIni, LocalDate fechaFin, List<Pregunta> preguntas){
		Ejercicio e = new Ejercicio(nombre, false, peso, fechaIni, fechaFin);
		EstadisticaEjercicio estej = new EstadisticaEjercicio (0, 0);
		for(Pregunta p: preguntas) {
			EstadisticaPregunta estpreg = new EstadisticaPregunta (p);
			e.añadirPregunta(p);
			estej.añadirEstadisticaPregunta(estpreg);
			p.setEstadistica(estpreg);
		}
		Sistema.getSistema().añadirEstadisticas(estej);
		this.contenidos.add(e);
		return e;
	}
	
	/**
	 * Añade una calificación.
	 * 
	 * Este método permite añadir una calificaión a la lista de calificaciones. 
	 * 
	 * @param ca es la calificación de asignatura que queremos añadir.
	 */
	
	public void añadirCalificacion (CalificacionAsignatura ca){
		this.calificaciones.add(ca);
	}
	
	/**
	 * Devuelve la lista de calificaiones.
	 * 
	 * Este méodo permite obtener la lista de calificaciones.
	 * 
	 * @return la lista de calificaciones.
	 */
	
	public List<CalificacionAsignatura> getCalificacionAsignatura(){
		return this.calificaciones;
	}
	
}
