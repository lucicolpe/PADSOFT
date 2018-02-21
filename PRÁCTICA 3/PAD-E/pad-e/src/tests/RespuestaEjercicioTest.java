package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import usuario.Estudiante;
import ejercicio.Pregunta;
import ejercicio.PreguntaAbierta;
import ejercicio.Respuesta;
import ejercicio.RespuestaEjercicio;
import ejercicio.RespuestaPregunta;

public class RespuestaEjercicioTest {

	Estudiante e1;
	RespuestaEjercicio re;
	RespuestaPregunta rp, rp2;
	
	
	@Before
	public void setUp() throws Exception {
		e1 = new Estudiante("123", "pass", "Carlos", "Gómez García", 123, "carlos.gomez@email.es");
		Respuesta r = new Respuesta("dos");
		Respuesta r1 = new Respuesta("dos");
		Respuesta r2 = new Respuesta("tres");
		Respuesta r3 = new Respuesta("uno");
		List<Respuesta> rp1 = new ArrayList<Respuesta>(3);
		rp1.add(r1); rp1.add(r2); rp1.add(r3);
		List<Respuesta> rc1 = new ArrayList<Respuesta>(1);
		rc1.add(r1);
		List<Respuesta> rc2 = new ArrayList<Respuesta>(1);
		rc2.add(r2);
		re = new RespuestaEjercicio(e1);
		Pregunta pr = new PreguntaAbierta("¿Cuánto es uno más uno?",1, 1.0, 0.5, rp1, rc1);
		rp = new RespuestaPregunta(r,pr,e1);
		Pregunta pr2 = new PreguntaAbierta("¿Cuánto es uno más dos?",1, 1.0, 0.5, rp1, rc2);
		rp2 = new RespuestaPregunta(r,pr2,e1);
		
	}

	@Test
	public void testAñadirRespuesta() {
		re.añadirRespuesta(rp);
		assertTrue(re.getRespuestas().contains(rp));
	}

	@Test
	public void testObtenerCalificacion() {
		re.añadirRespuesta(rp);
		assertTrue(re.getRespuestas().contains(rp));
		re.añadirRespuesta(rp2);
		assertTrue(re.getRespuestas().contains(rp2));
		double not = re.obtenerCalificacion();
		assertEquals(not, 2.5, 0.00000000000000001);
	}

}
