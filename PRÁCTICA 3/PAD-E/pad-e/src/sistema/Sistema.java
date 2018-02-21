package sistema;

import java.util.Collections;
import java.util.List;
import java.io.*;
import java.util.ArrayList;

import usuario.*;
import asignatura.Asignatura;
import asignatura.PeticionAdmision;
import ejercicio.EstadisticaEjercicio;
import es.uam.eps.padsof.emailconnection.*;

/**
* Contiene los atributos y métodos de la clase Estudiante.
*
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

public class Sistema implements Serializable{
	private Profesor p;
	private List<Asignatura> asignaturas;
	private List<Estudiante> estudiantes;
	private List<PeticionAdmision> peticiones;
	private List<EstadisticaEjercicio> estadisticas;
	private Usuario userActual;
	private static Sistema sistema;
	
	public Sistema(Profesor p) {
		this.p = p;
		this.asignaturas = new ArrayList<Asignatura>(100);
		this.estudiantes = new ArrayList<Estudiante>(2000);
		this.peticiones = new ArrayList<PeticionAdmision>();
		this.estadisticas = new ArrayList<EstadisticaEjercicio>();
	}
	
	/**
	 * Devuelve el usuario actual.
	 * 
	 * Este método se encarga de deolver el usuario actual.
	 * 
	 * @return el usuario actual.
	 */
	
	public Usuario getUserActual() {
		return this.userActual;
	}
	
	/**
	 * Modifica el usuario actual.
	 * 
	 * Este método modifica el usuario actual.
	 * 
	 * @param userActual es el nuevo usuario que vamos a introducir.
	 */

	public void setUserActual(Usuario userActual) {
		this.userActual = userActual;
	}
	
	/**
	 * Consigue el sistema.
	 * 
	 * Este método se encarga de conseguir el sistema.
	 * 
	 * @return el sistema.
	 */

	public static Sistema getSistema() {
		Profesor p;
		if(sistema == null) {
			p = new Profesor("admin", "admin");
			sistema = new Sistema(p);
		}
		return sistema;
	}
	
	
	/**
	 * Modifica el sistema.
	 * 
	 * Este método se encarga de modificar el sistema.
	 * 
	 * @param sistema que queremos guardar.
	 */
	
	
	public static void setSistema(Sistema sistema) {
		Sistema.sistema = sistema;
	}

	/**
	 * Crea una nueva asignatura.
	 * 
	 * Este método crea una nueva asignatura.
	 * 
	 * @param nombre de la nueva asignatura.
	 * @return la nueva asignatura.
	 */
	
	public Asignatura crearAsignatura (String nombre){
		Asignatura a = new Asignatura(nombre);
		this.asignaturas.add(a);
		return a;
	}
	
	
	/**
	 * Añade un nuevo estudiante.
	 * 
	 * Este método añade un nuevo estudiante.
	 * 
	 * @param nia del nuevo estudiante.
	 * @param contraseña del nuevo estudiante.
	 * @param nombre del nuevo estudiante.
	 * @param apellidos del nuevo estudiante.
	 * @param correo del nuevo estudiante.
	 * @return el nuevo estudiante.
	 */
	public Estudiante añadirEstudiante(int nia, String contraseña, String nombre, String apellidos, String correo) {
		Estudiante e = new Estudiante(Integer.toString(nia), contraseña, nombre, apellidos, nia, correo);
		this.estudiantes.add(e);
		return e;
	}
	
	/**
	 * Añade una nueva petición.
	 * 
	 * Este método añade una nueva petición de admisión.
	 * 
	 * @param pe es la nueva petición de admisión.
	 */
	
	public void añadirPeticion(PeticionAdmision pe) {
		this.peticiones.add(pe);
	}
	
	/**
	 * Elimina una petición de admisión.
	 * 
	 * Este método alimina una peticion de admisión de la lista de peticiones.
	 * 
	 * @param pe es la petición de admisión a eliminar.
	 */
	
	public void eliminarPeticion(PeticionAdmision pe) {
		this.peticiones.remove(pe);
	}
	
	/**
	 * Añade una estadística de ejercicio.
	 * 
	 * Este método añade una estadística de ejercicio.
	 * 
	 * @param estej es la estadística de ejercicio a añadir.
	 */
	
	public void añadirEstadisticas(EstadisticaEjercicio estej) {
		this.estadisticas.add(estej);
	}
	
	
	/**
	 * Manda una notificación.
	 * 
	 * Este método manda una notificación al estudiante.
	 * 
	 * @param e es el estudinate que recibre la notificación.
	 * @param subject es la asignatura de la cual se hace la petición de admisión.
	 * @param mensaje es el mensaje que va adjunto a la notificación mandada.
	 * @throws InvalidEmailAddressException lo devuelve si el email es inválido.
	 * @throws FailedInternetConnectionException lo devuelve si la conexión a Internet falla.
	 */
	
	public void mandarNotificacion (Estudiante e, String subject, String mensaje) throws InvalidEmailAddressException, FailedInternetConnectionException{
		EmailSystem.send(e.getCorreo(), subject, mensaje);
	}
	
	/**
	 * Devuelve la lista de asignaturas.
	 * 
	 * Este método devuelve la lista de asignaturas.
	 *  
	 * @return la lista de asignaturas.
	 */
	
	public List<Asignatura> getAsignaturas() {
		return Collections.unmodifiableList(asignaturas);
	}
	
	/**
	 * Devuelve la lista de estudiantes.
	 * 
	 * Este método devuelve la lista de estudiantes.
	 * 
	 * @return la lista de estudiantes.
	 */
	
	public List<Estudiante> getEstudiantes() {
		return Collections.unmodifiableList(estudiantes);
	}
	
	/**
	 * Devuelve la lista de peticiones de admisión.
	 * 
	 * Este método devuelve la lista de peticiones de admisión.
	 * 
	 * @return la lista de peticiones de admisión.
	 */
	
	
	public List<PeticionAdmision> getPeticiones() {
		return Collections.unmodifiableList(peticiones);
	}
	
	
	/**
	 * Devuelve la lista de estadisticas.
	 * 
	 * Este método devuelve la lista de estadisticas.
	 * 
	 * @return la lista de estadisticas.
	 */
	
	public List<EstadisticaEjercicio> getEstadisticas() {
		return Collections.unmodifiableList(estadisticas);
	}
	
	/**
	* Carga el fichero de los estudiantes.
	*
	* Este método carga el fichero de los estudiantes.
	*
	* @param file es el fichero de texto.
	* @throws IOException error al leer el archivo
	*/
	public void cargarAlumnos(String file) throws IOException {
		FileInputStream stream = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader buffer = new BufferedReader(reader);
		String linea;
		String nombre; String apellidos; String correo; String contrasena;
		int nia;
		nombre = "";
		apellidos= "";
		correo= "";
		contrasena= "";
		nia= 0;
		while((linea = buffer.readLine()) != null) {
			String split[] = linea.split(";");
			int i = 0;
			for(String n: split) {
				if(i == 0) {
					nombre = n;
				} else if(i == 1) {
					apellidos = n;
				} else if(i == 2) {
					correo = n;
				} else if(i == 3) {
					nia = Integer.parseInt(n);
				} else {
					contrasena = n;
					Sistema.sistema.añadirEstudiante(nia, contrasena, nombre, apellidos, correo);
				}
				i = (i+1)%5;
			}
		}
		stream.close();
	}
}
