package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ejercicio.Ejercicio;
import ejercicio.Pregunta;
import ejercicio.PreguntaTest;
import ejercicio.Respuesta;
import ejercicio.RespuestaEjercicio;
import ejercicio.RespuestaPregunta;
import usuario.Estudiante;
import asignatura.Asignatura;
import asignatura.CalificacionAsignatura;
import asignatura.Tema;

public class CalificacionAsignaturaTest {
	
	Asignatura a1;
	Estudiante e1;
	Pregunta p1, p2;
	Ejercicio ej1,ej2;
	RespuestaEjercicio re;
	List<Respuesta> rp1;
	List<Respuesta> rc2;
	CalificacionAsignatura ca;
	Tema t;
	
	@Before
	public void setUp() throws Exception {
		a1 = new Asignatura("Calculo numerico");
		e1 = new Estudiante("123", "pass", "Carlos", "Gómez García", 123, "carlos.gomez@email.es");
		Respuesta r1 = new Respuesta("dos");
		Respuesta r2 = new Respuesta("tres");
		Respuesta r3 = new Respuesta("uno");
		List<Respuesta> rp1 = new ArrayList<Respuesta>(3);
		rp1.add(r1); rp1.add(r2); rp1.add(r3);
		List<Respuesta> rc1 = new ArrayList<Respuesta>(1);
		rc1.add(r1); 
		List<Respuesta> rc2 = new ArrayList<Respuesta>(1);
		rc2.add(r2);
		Pregunta preg1 = new PreguntaTest("¿Cuánto es uno más uno?", 1, 1, 0.5, rp1, rc1);
		Pregunta preg2 = new PreguntaTest("¿Cuánto es uno más dos?", 2, 1, 0.5, rp1, rc2);
		
		Respuesta l1 = new Respuesta("dos");
		RespuestaPregunta rp = new RespuestaPregunta (l1,preg1,e1);
		Respuesta l2 = new Respuesta("tres");
		RespuestaPregunta rp2 = new RespuestaPregunta (l2,preg2,e1);
		List<Pregunta> preg3 = new ArrayList<Pregunta>(2);
		preg3.add(preg1); preg3.add(preg2);
		List<RespuestaPregunta> respreg = new ArrayList<RespuestaPregunta>();
		respreg.add(rp); respreg.add(rp2); 
		ej1 = a1.añadirEjercicio("Ejercicio1", 1, LocalDate.now().minusDays(2), LocalDate.now().plusDays(3), preg3);
		e1.responderEjercicio(ej1, respreg);
		
		t = a1.añadirTema("Cálculo numérico");
		List<Pregunta> preg4 = new ArrayList<Pregunta>(2);
		preg4.add(preg1); preg4.add(preg2);
		ej2 = t.añadirEjercicio("Ejercicio1", 1, LocalDate.now().minusDays(2), LocalDate.now().plusDays(3), preg4);
		e1.responderEjercicio(ej2, respreg);

		ca = new CalificacionAsignatura(a1);
	}

	@Test
	public void testCalcularNota() {
		ca.calcularNota(e1);
		assertEquals(ca.getNota(), 10, 0.000001);
	}

}
