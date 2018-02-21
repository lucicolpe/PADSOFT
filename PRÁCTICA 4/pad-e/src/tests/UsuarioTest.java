package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sistema.Sistema;
import usuario.*;

public class UsuarioTest {

	Estudiante e1;
	Profesor p1;

	
	@Before
	public void setUp() throws Exception {
		e1 = new Estudiante("123", "pass", "Carlos", "Gómez García", 123, "carlos.gomez@email.es");
		p1 = new Profesor("admin","password");

	}

	@Test
	public void testHacerLoginCorrecto() {
		e1.hacerLogin("123", "pass");
		assertSame (e1, Sistema.getSistema().getUserActual());	
	}
	
	public void testHacerLoginErroneo(){
		e1.hacerLogin("125", "pass");
		assertNull (Sistema.getSistema().getUserActual());	
		e1.hacerLogin("123", "password");
		assertNull (Sistema.getSistema().getUserActual());	
	}

	@Test
	public void testHacerLogout() {
		e1.hacerLogin("123", "pass");
		assertSame (e1, Sistema.getSistema().getUserActual());	
		e1.hacerLogout();
		assertNull (Sistema.getSistema().getUserActual());	
		
		p1.hacerLogin("admin", "password");
		e1.hacerLogout();
		assertSame (p1, Sistema.getSistema().getUserActual());
		
	}

}
