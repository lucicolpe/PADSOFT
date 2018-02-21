package usuario;

import java.io.Serializable;
import java.util.List;

import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import sistema.Sistema;
import asignatura.*;

/**
* Contiene los atributos y métodos de la clase Profesor.
*
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

public class Profesor extends Usuario implements Serializable{

	public Profesor(String usuario, String contraseña) {
		super(usuario, contraseña);
	}
	
	/**
	 * Acepta una petición de admisión.
	 * 
	 * Este método permite que el profesor acepte una petición y que el sistema envíe una notificación de ello al estudiante que la solicitó.
	 * 
	 * @param p Peticion de Admisión enviada por el estudiante. 
	 */
	
	public void aceptarPeticionAdmision(PeticionAdmision p){
		p.aceptarPeticionAdmision();
		try{
			Sistema.getSistema().mandarNotificacion(p.getEstudiante(), "Petición aceptada.", "Tu petición de entrada a la asignatura ha sido aceptada.");
		} catch(FailedInternetConnectionException ex) {
			System.out.println("Error, no hay conexion.");
		} catch (InvalidEmailAddressException exe) {
			System.out.println("Email erroneo.");
		}
		
	}
	
	/**
	 * Deniega una peticion de admisión.
	 * 
	 * Este método permite que el profesor deniegue una petición y que el sistema envíe una notificación de ello al estudiante que la solicitó.
	 * 
	 * @param p Peticion de Admisión enviada por el estudiante.
	 */
	
	public void denegarPeticionAdmision(PeticionAdmision p){
		try{
			Sistema.getSistema().mandarNotificacion(p.getEstudiante(), "Petición denegada.", "Tu petición de entrada a la asignatura ha sido denegada.");
		}catch(FailedInternetConnectionException ex) {
			System.out.println("Error, no hay conexion.");
		} catch (InvalidEmailAddressException exe) {
			System.out.println("Email erroneo.");
		}
		p.resolverPeticionAdmision();

	}
	
	
	/**
	 * Permite buscar una asignatura.
	 * 
	 * Este método permite que el profesor pueda buscar una asignatura en la lista de todas las asignaturas de las que dispone el sistema.
	 * 
	 * @param nombre El nombre de la asignatura que el profesor quiere buscar.
	 * 
	 * @return Asignatura que ha sido buscada.
	 */
	
	public Asignatura buscarAsignatura(String nombre) {
		List<Asignatura> asignaturas = Sistema.getSistema().getAsignaturas();
		for(Asignatura a: asignaturas) {
			if(a.getNombre().equals(nombre)) {
				return a;
			}
		}
		return null;
	}
}

