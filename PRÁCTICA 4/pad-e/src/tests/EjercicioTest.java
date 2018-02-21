package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import usuario.Estudiante;
import ejercicio.Ejercicio;
import ejercicio.Pregunta;
import ejercicio.PreguntaTest;
import ejercicio.Respuesta;
import ejercicio.RespuestaEjercicio;

public class EjercicioTest {

	Pregunta p1, p2;
	Ejercicio e;
	RespuestaEjercicio re;
	Estudiante e1;
	List<Respuesta> rp1;
	List<Respuesta> rc2;
	
	@Before
	public void setUp() throws Exception {
		Respuesta r1 = new Respuesta("dos");
		Respuesta r2 = new Respuesta("tres");
		Respuesta r3 = new Respuesta("uno");
		rp1 = new ArrayList<Respuesta>(3);
		rp1.add(r1); rp1.add(r2); rp1.add(r3);
		List<Respuesta> rc1 = new ArrayList<Respuesta>(1);
		rc1.add(r2); 
		
		rc2 = new ArrayList<Respuesta>(1);
		rc1.add(r3);
		
		List<Respuesta> rc3 = new ArrayList<Respuesta>(1);
		rc3.add(r1); 
		
		p1 = new PreguntaTest("¿Cuánto es uno más uno?", 1, 1, -0.5, rp1, rc3);
		p2 = new PreguntaTest("¿Cuánto es uno más dos?", 2, 1, -0.5, rp1, rc1);
		
		e = new Ejercicio ("Ejercicio1", true, 1, LocalDate.now().minusDays(2), LocalDate.now().plusDays(3));
		
		e1 = new Estudiante("123", "pass", "Carlos", "Gómez García", 123, "carlos.gomez@email.es");
		re = new RespuestaEjercicio(e1);
	}

	@Test
	public void testAñadirPregunta() {
		e.añadirPregunta(p1);
		assertTrue(e.getPreguntas().contains(p1));
	}

	@Test
	public void testEliminarPregunta() {
		e.añadirPregunta(p1);
		assertTrue(e.getPreguntas().contains(p1));
		e.eliminarPregunta(p1);
		assertFalse(e.getPreguntas().contains(p1));
	}

	@Test
	public void testAñadirRespuesta() {
		e.añadirRespuesta(re);
		assertTrue(e.getRespuestasEjercicio().contains(re));
	}

	@Test
	public void testVerCalificacionEjercicio() {
		e.añadirRespuesta(re);
		assertEquals(e.verCalificacionEjercicio(e1), re);
	}

	@Test
	public void testModificarFechaIni() {
		e.modificarFechaIni(LocalDate.now().minusDays(1));
		assertEquals(e.getFechaIni(), LocalDate.now().minusDays(1));
		e.añadirRespuesta(re);
		e.modificarFechaIni(LocalDate.now().plusDays(2));
		assertFalse(e.getFechaIni().equals(LocalDate.now().plusDays(2)));
	}

	
	@Test
	public void testModificarFechaFin() {
		e.modificarFechaFin(LocalDate.now().plusDays(1));
		assertEquals(e.getFechaFin(), LocalDate.now().plusDays(1));
		e.añadirRespuesta(re);
		e.modificarFechaFin(LocalDate.now().minusDays(2));
		assertFalse(e.getFechaFin().equals(LocalDate.now().minusDays(2)));
	}

	@Test
	public void testModificarPregunta() {
		e.añadirPregunta(p1); e.añadirPregunta(p2);
		e.modificarPregunta(2, "¿Cuánto es dos menos uno?", 1, -1, rp1, rc2);
		assertEquals(e.getPreguntas().get(1).getEnunciado(), "¿Cuánto es dos menos uno?");
		e.modificarFechaIni(LocalDate.now().minusDays(1));
		assertEquals(e.getFechaIni(), LocalDate.now().minusDays(1));
		e.añadirRespuesta(re);
		e.modificarFechaIni(LocalDate.now().plusDays(2));
		assertFalse(e.getFechaIni().equals(LocalDate.now().plusDays(2)));
	}

}
