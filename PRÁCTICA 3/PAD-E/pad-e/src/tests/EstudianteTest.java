package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ejercicio.*;
import asignatura.*;
import sistema.Sistema;
import usuario.Estudiante;

public class EstudianteTest {
	
	Estudiante e1, e2;
	Asignatura a1, a2;
	Ejercicio e;
	
	@Before
	public void setUp(){
		e1 = new Estudiante("123", "pass", "Carlos", "Gómez García", 123, "carlos.gomez@email.es");
		e2 = new Estudiante("125", "passw", "Maria", "López Sainz", 125, "maria.lopez@email.es");
		a1 = new Asignatura("SOPER");
		a2 = new Asignatura("Analisis y Diseño de Software");
		e = new Ejercicio("Ejercicio1", true, 1, LocalDate.now().minusDays(2), LocalDate.now().plusDays(3));

	}
	
	@Test
	public void testEStudiante() {
		assertNotNull(e1);
		assertNotNull(e2);
		
		assertEquals(e1.getNombre(), "Carlos");
		assertEquals(e2.getNombre(), "Maria");
		assertEquals(e1.getApellidos(), "Gómez García");
		assertEquals(e2.getApellidos(), "López Sainz");
		assertEquals(e1.getCorreo(), "carlos.gomez@email.es");
		assertEquals(e2.getCorreo(), "maria.lopez@email.es");
		assertEquals(e1.getNia(), 123);
		assertEquals(e2.getNia(), 125);
		assertEquals(e1.getContraseña(), "pass");
		assertEquals(e2.getContraseña(), "passw");
	}
	
	@Test
	public void testAñadirAsignatura() {
		assertTrue (e1.añadirAsignatura(a1));
		assertTrue (e1.añadirAsignatura(a2));
		assertTrue (e2.añadirAsignatura(a1));
	}

	@Test
	public void testEliminarAsignatura() {
		
		e1.añadirAsignatura(a1);
		e2.añadirAsignatura(a1);
		e1.añadirAsignatura(a2);
		
		assertTrue (e1.eliminarAsignatura(a1));
		assertTrue (e1.eliminarAsignatura(a2));
		assertTrue (e2.eliminarAsignatura(a1));
	}

	@Test
	public void testResponderPreguntaPreguntaString() {
		Respuesta r1 = new Respuesta("dos");
		Respuesta r2 = new Respuesta("tres");
		List<Respuesta> rp1 = new ArrayList<Respuesta>(2);
		rp1.add(r1); rp1.add(r2);
		List<Respuesta> rc1 = new ArrayList<Respuesta>(1);
		rc1.add(r2);
		Pregunta preg1 = new PreguntaTest("¿Cuánto es uno más dos?", 1, 1, -0.5, rp1, rc1);
		RespuestaPregunta res1 = new RespuestaPregunta (r2,preg1,e1);
		EstadisticaPregunta estpreg = new EstadisticaPregunta(preg1);
		preg1.setEstadistica(estpreg);
		assertEquals(e1.responderPregunta(preg1, "tres"), res1);
		assertTrue(preg1.getEstadistica().getNumAciertos() == 1);
		assertTrue(preg1.getEstadistica().getNumFallos() == 0);
		assertTrue(preg1.getEstadistica().getNumSinContestar() == 0);
		
	}

	@Test
	public void testResponderPreguntaPreguntaListOfString() {
		List<String> rpl = new ArrayList<String>(3);
		rpl.add("dos"); rpl.add("tres");
		Respuesta rc = new Respuesta(rpl);
		Respuesta r1 = new Respuesta("dos");
		Respuesta r2 = new Respuesta("tres");
		Respuesta r3 = new Respuesta("uno");
		
		List<Respuesta> rp1 = new ArrayList<Respuesta>(3);
		rp1.add(r1); rp1.add(r2); rp1.add(r3);
		List<Respuesta> rc1 = new ArrayList<Respuesta>(1);
		rc1.add(rc); 
		List<String> res1 = new ArrayList<String>();
		res1.add("uno");
		res1.add("dos"); 		
		Pregunta preg1 = new PreguntaRespMultiple("¿Cuánto es uno más dos y uno más uno?", 2, 1, -0.5, rp1, rc1);
		Respuesta r = new Respuesta(res1);
		RespuestaPregunta rp = new RespuestaPregunta (r,preg1,e1);
		EstadisticaPregunta estpreg = new EstadisticaPregunta(preg1);
		preg1.setEstadistica(estpreg);
		assertEquals(e1.responderPregunta(preg1, res1), rp);
		assertTrue(preg1.getEstadistica().getNumAciertos() == 0);
		assertTrue(preg1.getEstadistica().getNumFallos() == 1);
		assertTrue(preg1.getEstadistica().getNumSinContestar() == 0);
	}
	
	@Test
	public void testResponderEjercicio() {
		Respuesta r1 = new Respuesta("dos");
		Respuesta r2 = new Respuesta("tres");
		Respuesta r3 = new Respuesta("uno");
		List<Respuesta> rp1 = new ArrayList<Respuesta>(3);
		rp1.add(r1); rp1.add(r2); rp1.add(r3);
		List<Respuesta> rc1 = new ArrayList<Respuesta>(1);
		rc1.add(r2); 
		Pregunta preg1 = new PreguntaTest("¿Cuánto es uno más uno?", 1, 1, -0.5, rp1, rc1);
		Pregunta preg2 = new PreguntaTest("¿Cuánto es uno más dos?", 2, 1, -0.5, rp1, rc1);
		
		Respuesta l1 = new Respuesta("uno");
		RespuestaPregunta rp = new RespuestaPregunta (l1,preg1,e1);
		Respuesta l2 = new Respuesta("dos");
		RespuestaPregunta rp2 = new RespuestaPregunta (l2,preg2,e1);
		
		List<RespuestaPregunta> respreg = new ArrayList<RespuestaPregunta>();
		respreg.add(rp); respreg.add(rp2); 
		
		e.añadirPregunta(preg1); e.añadirPregunta(preg2);
		e1.responderEjercicio(e, respreg);
		assertFalse(e.getRespuestasEjercicio().isEmpty());

	}
	
	@Test
	public void testañadirCalificacion (){
		e1.añadirAsignatura(a1);
		e1.añadirCalificacion(a1);
		assertFalse(a1.getCalificacionAsignatura().isEmpty());
		assertTrue(a1.getCalificacionAsignatura().contains(e1.verCalificacion(a1)));
	}

	@Test
	public void testVerCalificacion() {
		e1.añadirAsignatura(a1);
		assertTrue(e1.getAsignaturas().get(0) == a1);
		e1.añadirCalificacion(a1);
 		assertTrue(e1.verCalificacion(a1).getAsignatura() == a1);
	}

	@Test
	public void testEnviarPeticionAdmision() {
		String textoOpcional = "Peticion de admision en SOPER";
		PeticionAdmision pe = e1.enviarPeticionAdmision(a1, textoOpcional);
		assertTrue(Sistema.getSistema().getPeticiones().contains(pe));
	}

	@Test
	public void testVerApuntes() {
	    Apuntes ap = new Apuntes("Clases y objetos", true, "Repasar tema 1");
	    assertEquals (e1.verApuntes(ap), ap.getTexto());
	}

	@Test
	public void testVerRespuesta() {
		Respuesta r1 = new Respuesta("dos");
		Respuesta r2 = new Respuesta("tres");
		Respuesta r3 = new Respuesta("uno");
		List<Respuesta> rp1 = new ArrayList<Respuesta>(3);
		rp1.add(r1); rp1.add(r2); rp1.add(r3);
		List<Respuesta> rc1 = new ArrayList<Respuesta>(1);
		rc1.add(r2); 
		Pregunta preg1 = new PreguntaTest("¿Cuánto es uno más uno?", 1, 1, -0.5, rp1, rc1);
		Pregunta preg2 = new PreguntaTest("¿Cuánto es uno más dos?", 2, 1, -0.5, rp1, rc1);
		
		Respuesta l1 = new Respuesta("uno");
		RespuestaPregunta rp = new RespuestaPregunta (l1,preg1,e1);
		Respuesta l2 = new Respuesta("dos");
		RespuestaPregunta rp2 = new RespuestaPregunta (l2,preg2,e1);
		
		List<RespuestaPregunta> respreg = new ArrayList<RespuestaPregunta>();
		respreg.add(rp); respreg.add(rp2); 
		
		e.añadirPregunta(preg1); e.añadirPregunta(preg2);
		e1.responderEjercicio(e, respreg);	
		RespuestaEjercicio respej = e1.verRespuesta(e);
		assertNotNull(respej);
		assertEquals(e1, respej.getEstudiante());
		assertEquals(respej.getRespuestas(), respreg);
		
	}

}
