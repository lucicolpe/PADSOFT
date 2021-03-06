package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import usuario.Estudiante;
import ejercicio.*;

public class PreguntaTestTest {

	Estudiante e1;
	PreguntaTest pt;
	
	
	@Before
	public void setUp() throws Exception {
		e1 = new Estudiante("123", "pass", "Carlos", "Gómez García", 123, "carlos.gomez@email.es");
		Respuesta r1 = new Respuesta("dos");
		Respuesta r2 = new Respuesta("tres");
		Respuesta r3 = new Respuesta("uno");
		List<Respuesta> rp1 = new ArrayList<Respuesta>(3);
		rp1.add(r1); rp1.add(r2); rp1.add(r3);
		List<Respuesta> rc1 = new ArrayList<Respuesta>(1);
		rc1.add(r2);
		pt = new PreguntaTest("¿Cuánto es uno más uno?",1, 1.0, -0.5, rp1, rc1);
		
	}

	@Test
	public void testResponderPregunta() {
		RespuestaPregunta rp = pt.responderPregunta(e1, "dos");
		assertEquals(rp.getRespuesta().getTexto(), "dos");
	}

}
