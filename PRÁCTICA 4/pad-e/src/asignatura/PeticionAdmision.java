package asignatura;
import java.io.Serializable;

import sistema.Sistema;
import usuario.Estudiante;

/**
* Contiene los atributos y métodos de la clase PeticionAdmision.
*
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

public class PeticionAdmision implements Serializable{
	private String textoOpcional;
	private Estudiante estudiante;
	private Asignatura asignatura;

	public PeticionAdmision(String textoOpcional, Estudiante estudiante, Asignatura asignatura) {
		super();
		this.textoOpcional = textoOpcional;
		this.estudiante = estudiante;
		this.asignatura = asignatura;
	}
	
	/**
	 * Devuelve el texto opcional.
	 * 
	 * Este método devuelve el texto opcional de la peticion de admision.
	 *  
	 * @return cadena que contiene el texto opcional de la peticion de admision.
	 */

	public String getTextoOpcional() {
		return this.textoOpcional;
	}
	
	/**
	 * Modifica el texto opcional.
	 * 
	 * Este método permite cambiar el texto opcional de la peticion de admision.
	 * 
	 *@param textoOpcional es el texto nuevo que queremos que la peticion de admision tenga. 
	 */

	public void setTextoOpcional(String textoOpcional) {
		this.textoOpcional = textoOpcional;
	}
	
	/**
	 * Devuelve el estudiante.
	 * 
	 * Este método devuelve el estudiante de la peticion de admision.
	 *  
	 * @return Estudiante de la peticion de admision.
	 */
	
	public Estudiante getEstudiante() {
		return estudiante;
	}
	
	/**
	 * Devuelve la asignatura.
	 * 
	 * Este método devuelve la asignatura de la peticion de admision.
	 *  
	 * @return Asignatura de la peticion de admision.
	 */

	public Asignatura getAsignatura() {
		return asignatura;
	}
	
	/**
	 * Acepta la peticion de admision.
	 * 
	 * Este método acepta la peticion de admision de un estudiante.
	 */

	public void aceptarPeticionAdmision(){
		this.asignatura.darDeAlta(this.estudiante);
		this.resolverPeticionAdmision();
	}
	
	/**
	 * Resuelve la peticion de admision.
	 * 
	 * Este método resuelve una peticion eliminandla del sistema.
	 */
	
	
	public void resolverPeticionAdmision(){
		Sistema sistema = Sistema.getSistema();
		sistema.eliminarPeticion(this);
	}
}
