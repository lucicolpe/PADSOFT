package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ejercicio.*;
import sistema.Sistema;
import usuario.Estudiante;
import asignatura.*;


public class AsignaturaTest {

	Asignatura a1;
	Estudiante e1;
	
	@Before
	public void setUp() throws Exception {
		a1 = new Asignatura("Calculo numerico");
		e1 = new Estudiante("123", "pass", "Carlos", "Gómez García", 123, "carlos.gomez@email.es");

	}

	@Test
	public void testDarDeAlta() {
		a1.darDeAlta(e1);
		assertTrue(e1.getAsignaturas().contains(a1));
		assertFalse(a1.getExpulsados().contains(e1));
	}

	@Test
	public void testDarDeBaja() {
		a1.darDeAlta(e1);
		a1.darDeBaja(e1);
		assertFalse(e1.getAsignaturas().contains(a1));
		assertTrue(a1.getExpulsados().contains(e1));
	}
	

	@Test
	public void testAñadirTema() {
		Tema t = a1.añadirTema("Tema 1");
		assertTrue (a1.getcontenidos().contains(t));
	}

	@Test
	public void testEliminarTema() {
		Tema t = a1.añadirTema("Tema 1");
		assertTrue (a1.getcontenidos().contains(t));
		a1.eliminarTema(t);
		assertFalse (a1.getcontenidos().contains(t));
	}
	
	@Test
	public void testAñadirEjercicio() {
		Respuesta r1 = new Respuesta("dos");
		Respuesta r2 = new Respuesta("tres");
		Respuesta r3 = new Respuesta("uno");
		List<Respuesta> rp1 = new ArrayList<Respuesta>(3);
		rp1.add(r1); rp1.add(r2); rp1.add(r3);
		List<Respuesta> rc1 = new ArrayList<Respuesta>(1);
		rc1.add(r2); 
		Pregunta preg1 = new PreguntaTest("¿Cuánto es uno más uno?", 1, 1, -0.5, rp1, rc1);
		Pregunta preg2 = new PreguntaTest("¿Cuánto es uno más dos?", 2, 1, -0.5, rp1, rc1);
		List<Pregunta> lp = new ArrayList<Pregunta>(2);
		lp.add(preg1); lp.add(preg2);
		Ejercicio e = a1.añadirEjercicio("Matematicas basicas", 2, LocalDate.now(), LocalDate.now().plusDays(3), lp);
		assertTrue(a1.getcontenidos().contains(e));
		assertFalse(Sistema.getSistema().getEstadisticas().isEmpty());
	}

	
	@Test
	public void testAñadirCalificacion() {
		CalificacionAsignatura ca = new CalificacionAsignatura(a1);
		a1.añadirCalificacion(ca);
		assertTrue(a1.getCalificacionAsignatura().contains(ca));
	}
	
	

}
