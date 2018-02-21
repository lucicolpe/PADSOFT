package asignatura;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import usuario.Estudiante;
import ejercicio.Ejercicio;
import ejercicio.RespuestaEjercicio;

/**
* Contiene los atributos y métodos de la clase CalificacionAsignatura.
*
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

public class CalificacionAsignatura implements Serializable{
	private double nota;
	private Asignatura asignatura;

	public CalificacionAsignatura(Asignatura a) {
		this.asignatura = a;
	}

	/**
	 * Devuelve la nota.
	 * 
	 * Este método devuelve la nota de la calificación de la asignatura.
	 *  
	 * @return nota de la calificación de la asignatura.
	 */
	
	public double getNota() {
		return this.nota;
	}
	
	/**
	 * Calucula la nota.
	 * 
	 * Este método calcula la nota de la calificación de la asignatura.
	 * 
	 * @param e es el estudiante del que se quiere calcular la nota.
	 */

	public void calcularNota(Estudiante e) {
		List<Double> aux = calcularNotaContenido(e, this.asignatura.getcontenidos());
		double notaTotal = aux.get(0);
		double pesoTotal = aux.get(1);
		this.nota = notaTotal / pesoTotal;
	}
	
	/**
	 * Calcula la nota de los ejercicios de un Tema.
	 * 
	 * Este método calcula la nota de los ejercicios de un Tema.
	 * 
	 * @param e es el estudiante.
	 * @param contenidos es la lista de contenidos del tema o asignatura.
	 * @return una lista con dos elementos: la nota totl y el peso total.
	 */
	
	private List<Double> calcularNotaContenido(Estudiante e, List<Contenido> contenidos) {
		double notaTotal = 0, pesoTotal = 0;
		double nota = 0;
		for(Contenido c: contenidos) {
			if(c instanceof Ejercicio) {
				Ejercicio ej = (Ejercicio) c;
				double peso = ej.getPeso();
				for(RespuestaEjercicio re: ej.getRespuestasEjercicio()) {
					if(re.getEstudiante() == e) {
						nota = re.getNota();
						break;
					}
				}
				if(nota != -1) {
					notaTotal += peso*nota;
					pesoTotal += peso;
					nota = -1; //Para asegurar que entre si un ejercicio posterior no tiene respuesta
				}
			} else if(c instanceof Tema) {
				Tema t = (Tema) c;
				List<Double> aux = calcularNotaContenido(e, t.getContenidos());
				notaTotal += aux.get(0);
				pesoTotal += aux.get(1);
			}
		}
		List<Double> l = new ArrayList<Double>(2);
		l.add(notaTotal); l.add(pesoTotal);
		return l;
	}
	
	/**
	 * Devuelve la asignatura.
	 * 
	 * Este método devuelve la asignatura de la calificacion.
	 *  
	 * @return asignatura de la calificación.
	 */

	public Asignatura getAsignatura() {
		return this.asignatura;
	}
	
	/**
	 * Modifica la asignatura.
	 * 
	 * Este método modifica la asignatura de la caificación.
	 * 
	 * @param asignatura nueva que se quiere guardar.
	 */

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	
	
}
