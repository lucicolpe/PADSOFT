package tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import ejercicio.EstadisticaEjercicio;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import asignatura.Asignatura;
import asignatura.PeticionAdmision;
import sistema.Sistema;
import usuario.Estudiante;

public class SistemaTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCrearAsignatura() {
		Asignatura a = Sistema.getSistema().crearAsignatura("Calculo Numerico");
		assertTrue(Sistema.getSistema().getAsignaturas().contains(a));
	}

	@Test
	public void testAñadirEstudiante() {
		Estudiante e = Sistema.getSistema().añadirEstudiante(123, "pass", "Carlos", "Gomez Garcia", "carlos.gomez@email.es");
		assertTrue(Sistema.getSistema().getEstudiantes().contains(e));
	}

	@Test
	public void testAñadirPeticion() {
		Estudiante e = Sistema.getSistema().añadirEstudiante(123, "pass", "Carlos", "Gomez Garcia", "carlos.gomez@email.es");
		Asignatura a = Sistema.getSistema().crearAsignatura("Calculo Numerico");
		PeticionAdmision pe = new PeticionAdmision("Solicitud de admision", e, a);
		Sistema.getSistema().añadirPeticion(pe);
		assertTrue(Sistema.getSistema().getPeticiones().contains(pe));
	}

	@Test
	public void testAñadirEstadistica() {
		EstadisticaEjercicio estej = new EstadisticaEjercicio(30, 22);
		Sistema.getSistema().añadirEstadisticas(estej);
		assertTrue(Sistema.getSistema().getEstadisticas().contains(estej));
	}
	
	@Test
	public void testEliminarPeticion() {
		Estudiante e = Sistema.getSistema().añadirEstudiante(123, "pass", "Carlos", "Gomez Garcia", "carlos.gomez@email.es");
		Asignatura a = Sistema.getSistema().crearAsignatura("Calculo Numerico");
		PeticionAdmision pe = new PeticionAdmision("Solicitud de admision", e, a);
		Sistema.getSistema().añadirPeticion(pe);
		assertTrue(Sistema.getSistema().getPeticiones().contains(pe));
		Sistema.getSistema().eliminarPeticion(pe);
		assertFalse(Sistema.getSistema().getPeticiones().contains(pe));
	}

	@Test(expected = InvalidEmailAddressException.class)
	public void testMandarNotificacion1() throws FailedInternetConnectionException, InvalidEmailAddressException{
		Estudiante e = Sistema.getSistema().añadirEstudiante(123, "pass", "Carlos", "Gomez Garcia", "carlos.gomez=email.es");
		Sistema.getSistema().mandarNotificacion(e, "Calculo Numerico", "Solicito la admision");
	}
	
	@Test
	public void testMandarNotificacion2() throws FailedInternetConnectionException, InvalidEmailAddressException{
		Estudiante e = Sistema.getSistema().añadirEstudiante(123, "pass", "Carlos", "Gomez Garcia", "carlos.gomez@email.es");
		Sistema.getSistema().mandarNotificacion(e, "Calculo Numerico", "Solicito la admision");
	}

	@Test
	public void testCargarAlumnos() throws IOException{
		Sistema.getSistema().cargarAlumnos("datos.txt");
		assertTrue(Sistema.getSistema().getEstudiantes().size()>0);
	}

}
