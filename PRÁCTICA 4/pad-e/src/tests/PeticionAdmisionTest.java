package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asignatura.PeticionAdmision;
import sistema.Sistema;
import usuario.Estudiante;
import asignatura.Asignatura;

public class PeticionAdmisionTest {

	PeticionAdmision pe;
	Estudiante e1;
	Asignatura a1;
	
	@Before
	public void setUp() throws Exception {
		e1 = new Estudiante("123", "pass", "Carlos", "Gómez García", 123, "carlos.gomez@email.es");
		a1 = new Asignatura("SOPER");
		pe = new PeticionAdmision("Solicitude de admision", e1, a1);

	}

	@Test
	public void testAceptarPeticionAdmision() {
		pe.aceptarPeticionAdmision();
		assertTrue(e1.getAsignaturas().contains(a1));
		assertFalse(a1.getExpulsados().contains(e1));
	}

	@Test	public void testResolverPeticionAdmision() {
		Sistema.getSistema().añadirPeticion(pe);
		pe.resolverPeticionAdmision();
		assertFalse(Sistema.getSistema().getPeticiones().contains(pe));
	}

}
