package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ejercicio.EstadisticaEjercicio;
import ejercicio.EstadisticaPregunta;
import ejercicio.Pregunta;
import ejercicio.PreguntaTest;
import ejercicio.Respuesta;

public class EstadisticaEjercicioTest {

	EstadisticaEjercicio ee;
	EstadisticaPregunta ep;
	Pregunta p1;
	List<Respuesta> rp1;
	
	@Before
	public void setUp() throws Exception {
		Respuesta r1 = new Respuesta("dos");
		Respuesta r2 = new Respuesta("tres");
		Respuesta r3 = new Respuesta("uno");
		rp1 = new ArrayList<Respuesta>(3);
		rp1.add(r1); rp1.add(r2); rp1.add(r3);
		
		
		List<Respuesta> rc = new ArrayList<Respuesta>(1);
		rc.add(r1); 
		
		p1 = new PreguntaTest("¿Cuánto es uno más uno?", 1, 1, -0.5, rp1, rc);
		ee = new EstadisticaEjercicio(20, 35);
		ep = new EstadisticaPregunta(p1);
	}

	@Test
	public void testAñadirEstadisticaPregunta(){
		ee.añadirEstadisticaPregunta(ep);
		assertTrue(ee.getEstpreg().contains(ep));
	}
	
	@Test
	public void testGenerarGrafica() {
		ee.añadirEstadisticaPregunta(ep);
		assertTrue(ee.getEstpreg().contains(ep));
		List<Integer> l1 = ee.generarGrafica();
		assertSame(ep.getNumAciertos(), l1.get(0));
		assertSame(ep.getNumFallos(), l1.get(1));
		assertSame(ep.getNumSinContestar(), l1.get(2));
		
	}

}
