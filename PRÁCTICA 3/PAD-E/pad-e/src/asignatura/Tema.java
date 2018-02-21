package asignatura;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sistema.Sistema;
import ejercicio.Ejercicio;
import ejercicio.EstadisticaEjercicio;
import ejercicio.EstadisticaPregunta;
import ejercicio.Pregunta;


/**
* Contiene los atributos y métodos de la clase Tema.
*
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

public class Tema extends Contenido implements Serializable{
	private List<Contenido> contenidos;

	public Tema(String nombre, boolean visibilidad) {
		super(nombre, visibilidad);
		this.contenidos = new ArrayList<Contenido>();
	}
	
	
	/**
	 * Devuelve la lista de contenidos.
	 * 
	 * Este método devuelve la lista de contenidos del tema.
	 *  
	 * @return la lista de contenidos.
	 */

	public List<Contenido> getContenidos() {
		return Collections.unmodifiableList(contenidos);
	}
	
	/**
	 * Añade un ejercicio.
	 * 
	 * Este método permite que se añada un ejercicio en un tema.
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
	 * Añade un tema.
	 * 
	 * Este método permite que se pueda añadir un tema en un tema.
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
	 * Este método permite que se pueda eliminar un tema en un tema.
	 * 
	 * @param t es el tema que se va a eliminar.
	 */
	
	public void eliminarTema(Tema t){
		this.contenidos.remove(t);
	}
	
	/**
	 * Añade unos apuntes.
	 * 
	 * Este método sube (añade) unos apuntes al tema.
	 * 
	 * @param nombreApuntes es el nombre de los apuntes.
	 * @param texto es el texto que contienen los apuntes.
	 * @param visibilidad de los apuntes.
	 * @return Apuntes que han sido añadidos.
	 */
	
	public Apuntes subirApuntes(String nombreApuntes, String texto, boolean visibilidad){
		Apuntes a = new Apuntes(nombreApuntes, visibilidad, texto);
		this.contenidos.add(a);
		return a;
	}		
}
