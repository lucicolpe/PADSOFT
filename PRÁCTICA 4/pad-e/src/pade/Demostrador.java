package pade;

import sistema.Sistema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import asignatura.*;
import usuario.*;
import ejercicio.*;

import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import panels.PanelLogin;

import java.awt.Container;
import java.awt.FlowLayout;
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.ObjectInputStream;  
import java.io.ObjectOutputStream; 

/**
* Contiene los atributos y métodos de la clase Ejercicio.
*
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

public class Demostrador {
	
	/**
	 * Guarda el objeto que se le pasa como parámetro en un fichero.
	 * 
	 * @param pade es el sistema que quremos que guarde.
	 */
	
	public static void serializable(Sistema pade){
		try (FileOutputStream ficheroSalida = new FileOutputStream("Sistema.getSistema().ser");	
			ObjectOutputStream salida = new ObjectOutputStream (ficheroSalida)){
			
			salida.writeObject(Sistema.getSistema());
			salida.close();
			
		}catch(IOException ioException){
			ioException.printStackTrace();
		}
		
	}
	
	/**
	 * Carga el objeto que ha sido guardado en un fichero y lo carga con todos los daos que fueron guardados.
	 * 
	 * @return el sistema que habíamos guardado en el fichero.
	 */
	
	public static Sistema deserializable(){
		Sistema pade;
		try (FileInputStream ficheroEntrada = new FileInputStream("Sistema.getSistema().ser");
				ObjectInputStream entrada = new ObjectInputStream (ficheroEntrada)){
				
			pade = (Sistema)entrada.readObject();
			entrada.close();
			ficheroEntrada.close();
			
		}catch(IOException | ClassNotFoundException ioException){
			ioException.printStackTrace();
			return null;
		}
		
		return Sistema.getSistema();
	}





	public static void main(String[] args) {
		Estudiante e;
		Asignatura a;
		Tema t;
		Apuntes ap;
		Profesor p;
		Ejercicio ej;
		List<Asignatura> asignaturascurso;
		List<PeticionAdmision> peticiones;
		List<Contenido> contenidos;
		
		System.out.println("Aplicación comenzando.");
		
		
		try { 
			Sistema.getSistema().cargarAlumnos("datos.txt"); 
		}
		catch (NumberFormatException | IOException exception){
			exception.printStackTrace();
		}
		
		serializable(Sistema.getSistema());
		System.out.println("Los usuarios han sido cargados desde el archivo y la aplicación serializada");
		
		Sistema.setSistema(deserializable());
		System.out.println("Pad-e iniciándose.");
		System.out.println("Inicializa como un profesor");
		
		p = new Profesor("admin@admin.es","admin");
		p.hacerLogin("admin@admin.es", "admin");
		
		
		a = Sistema.getSistema().crearAsignatura("Cálculo numérico");
		System.out.println("Asignatura creada:" + a.getNombre());
		
		t = a.añadirTema("Tema 1");	
		
		System.out.println("El profesor añade un ejercicio al tema " + t.getNombre());
		
		
		
		System.out.println("Añade una pregunta tipo test al ejercicio");
		
		List<Pregunta> pre = new ArrayList<Pregunta>(3);
		Respuesta r1 = new Respuesta("Sí");
		Respuesta r2 = new Respuesta("No");
		List<Respuesta> rp1 = new ArrayList<Respuesta>(2);
		rp1.add(r1); rp1.add(r2); 
		List<Respuesta> rc1 = new ArrayList<Respuesta>(1);
		rc1.add(r1);
		Pregunta p1 = new PreguntaTest("¿Es uno más uno igual a dos?", 1, 1, 0.5, rp1, rc1);

		
		
		System.out.println("Añade una pregunta tipo abierta al ejercicio");
		
		Respuesta r3 = new Respuesta("Igualdad entre dos expresiones que contiene una o más variables");
		List<Respuesta> rc2 = new ArrayList<Respuesta>(1);
		rc2.add(r3);
		Pregunta p2 = new PreguntaAbierta("¿Cúal es la definición de ecuación?", 1, 1, 0.5, null, rc2);

		
		
		System.out.println("Añade una pregunta tipo respuesta múltiple al ejercicio");

		Respuesta r4 = new Respuesta("dos");
		Respuesta r5 = new Respuesta("menos dos");
		Respuesta r6 = new Respuesta("cuatro");
		List<Respuesta> rp3 = new ArrayList<Respuesta>(3);
		rp3.add(r4); rp3.add(r5); rp3.add(r6);
		List<String> rc3 = new ArrayList<String>(2);
		rc3.add("dos"); rc3.add("menos dos");
		Respuesta rc4 = new Respuesta(rc3);
		List<Respuesta> rc5 = new ArrayList<Respuesta>(1);
		rc5.add(rc4);
		Pregunta p3 = new PreguntaRespMultiple("¿Cuánto vale la x en x^2-4=0?", 1, 1, 0.5, rp3, rc5);
		
		pre.add(p1); pre.add(p2); pre.add(p3);
		ej = t.añadirEjercicio("Nociones básicas", 1, LocalDate.now(), LocalDate.now().plusDays(1), pre);
		
		System.out.println("Añade unos apuntes al " + t.getNombre());
		ap = t.subirApuntes("Definiciones", "Ecuación : igualdad entre dos expresiones que contiene una o más variables" , true);
		
		System.out.println("Cerrando sesión...");
		p.hacerLogout();
		
		System.out.println("Guardando pad-e...");
		serializable(Sistema.getSistema());
		Sistema.setSistema(deserializable());
		
		System.out.println("Pad-e iniciándose.");
		System.out.println("Pad-e reiniciándose.Entrando como Ana Cordero.");
		
		e = new Estudiante("Ana.Cordero@esdu.es", "Coero", "Ana", "Cordero", 1297,"Ana.Cordero@esdu.es");
		e.hacerLogin("1297", "Coero");
		
		asignaturascurso = Sistema.getSistema().getAsignaturas();
				
		System.out.println("Ana solicita la admisión en una asignatura");
		e.enviarPeticionAdmision(asignaturascurso.get(0), "Solicito ser aceptada en la asignatura");

		System.out.println("Cerrando sesión...");
		e.hacerLogout();
		
		System.out.println("Guardando pad-e...");
		serializable(Sistema.getSistema());
		Sistema.setSistema(deserializable());

		
		System.out.println("Pad-e iniciándose.");
		System.out.println("Inicializa como un profesor");
		
		p.hacerLogin("admin@admin.es", "admin");

		peticiones = Sistema.getSistema().getPeticiones();
		
		try {
			System.out.println("Acepta la petición.");
			peticiones.get(0).aceptarPeticionAdmision();
			e.añadirAsignatura(a);
			Sistema.getSistema().mandarNotificacion(e, e.getAsignaturas().get(0).getNombre(), "Ha sido admitido");
		} catch (InvalidEmailAddressException |
				FailedInternetConnectionException e1) {
			e1.printStackTrace();
		} 
		
		System.out.println("Cerrando sesión...");
		p.hacerLogout();
		
		System.out.println("Guardando pad-e...");
		serializable(Sistema.getSistema());
		Sistema.setSistema(deserializable());
		
		System.out.println("Pad-e iniciándose.");
		System.out.println("Pad-e reiniciándose.Entrando como Ana Cordero.");
		
		e.hacerLogin("1297", "Coero");

		asignaturascurso = e.getAsignaturas();
		a = e.getAsignaturas().get(0);
		System.out.println("La estudiante " + e.getNombre()+ " " + e.getApellidos() + " ha sido matriculada en la asignatura " + e.getAsignaturas().get(0).getNombre());
		
		
		contenidos = a.getcontenidos();
		t = (Tema)contenidos.get(0);
		t.getContenidos().get(0);
		
		int i = 0;
		if((contenidos.get(i).getNombre() != t.getNombre()) && i<contenidos.size()){
			i++;
		}else{
			t = (Tema)contenidos.get(0);
		}
		 
		System.out.println("La estudiante " + e.getNombre() + " " + e.getApellidos() + " está contestando al ejercicio " + ej.getNombre());
		
		RespuestaPregunta res1 = e.responderPregunta(p1, "Sí");
		
		RespuestaPregunta res2 = e.responderPregunta(p2, "Igualdad entre dos expresiones que contiene una o más variables");
		
		List<String> l = new ArrayList<String>(2);
		l.add("dos"); l.add("menos dos");
		RespuestaPregunta res3 = e.responderPregunta(p3, l);
		List<RespuestaPregunta> l1 = new ArrayList<RespuestaPregunta>();
		l1.add(res1); l1.add(res2); l1.add(res3);
		e.responderEjercicio(ej, l1);
		
		System.out.println(e.getNombre() + " " + e.getApellidos() + " termina el ejercicio.");
		
		System.out.println("La estudiante " + e.getNombre() + " " + e.getApellidos() + " ha obtenido una calificación de " + ej.getRespuestasEjercicio().get(0).obtenerCalificacion());
		e.añadirCalificacion(a);
		a.getCalificacionAsignatura().get(0).calcularNota(e);
		System.out.println("La estudiante " + e.getNombre() + " " + e.getApellidos() + " ha obtenido una calificación de " + a.getCalificacionAsignatura().get(0).getNota() + " en la asignatura " + a.getNombre());
		
		System.out.println("Cerrando sesión...");
		e.hacerLogout();
		
		System.out.println("Guardando pad-e...");
		serializable(Sistema.getSistema());
		System.out.println("Cerrando pad-e");
		
		
		System.out.println("Pad-e iniciándose.");
		System.out.println("Inicializa como un profesor");
		
		p.hacerLogin("admin@admin.es", "admin");
		
		System.out.println("Estadísticas del ejercicio: ");
		List<Integer> grafica = Sistema.getSistema().getEstadisticas().get(0).generarGrafica();
		System.out.println("Número de aciertos: " + grafica.get(0));
		System.out.println("Número de fallos: " + grafica.get(1));
		System.out.println("Número sin contestar: " + grafica.get(2));
		
		System.out.println("Cerrando sesión...");
		p.hacerLogout();
		
		System.out.println("Guardando pad-e...");
		serializable(Sistema.getSistema());
		System.out.println("Cerrando pad-e");
		
	}
		
}
