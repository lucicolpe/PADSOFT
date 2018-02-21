package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import sistema.Sistema;
import ejercicio.Ejercicio;
import ejercicio.Pregunta;
import ejercicio.PreguntaTest;
import ejercicio.Respuesta;
import asignatura.Apuntes;
import asignatura.Tema;

public class TemaTest {

	Tema t;
	
	@Before
	public void setUp() throws Exception {
		t = new Tema("Tema 1", true);
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
		List<Pregunta> preg = new ArrayList<Pregunta>();
		preg.add(preg1); preg.add(preg2);

		Ejercicio e = t.añadirEjercicio("Ejercicio", 1, LocalDate.now().minusDays(2), LocalDate.now().plusDays(3), preg);
		assertTrue (t.getContenidos().contains(e));
		assertFalse(Sistema.getSistema().getEstadisticas().isEmpty());

	}

	@Test
	public void testAñadirTema() {
		Tema subt = t.añadirTema("Subtema 1");
		assertTrue(t.getContenidos().contains(subt));	
	}
	
	@Test
	public void testEliminarTema() {
		Tema subt = t.añadirTema("Subtema 1");
		assertTrue(t.getContenidos().contains(subt));
		t.eliminarTema(subt);
		assertFalse(t.getContenidos().contains(subt));
	}


	@Test
	public void testSubirApuntes() {
		Apuntes ap = t.subirApuntes("Apuntes tema 1", "aprende a sumar", true);
		assertTrue(t.getContenidos().contains(ap));
	}

}
