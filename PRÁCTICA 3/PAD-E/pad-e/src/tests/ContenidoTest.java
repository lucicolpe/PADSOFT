package tests;

import static org.junit.Assert.*;
import asignatura.*;

import org.junit.Before;
import org.junit.Test;

public class ContenidoTest {

	Tema t;
	Apuntes ap;
	
	@Before
	public void setUp() throws Exception {
		t = new Tema("Tema 1", true);
		ap =  new Apuntes("Clases y objetos", false, "Repasar tema 1");
	}

	@Test
	public void testIsVisible() {
		assertTrue(t.isVisible());
		assertFalse(ap.isVisible());
	}

	@Test
	public void testHacerVisible() {
		ap.hacerVisible();
		assertTrue(ap.isVisible());
	}

	@Test
	public void testHacerInvisible() {
		t.hacerInvisible();
		assertFalse(t.isVisible());
	}

}
