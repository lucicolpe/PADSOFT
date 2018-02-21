package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
/*import org.junit.Test;*/




import usuario.*;
import asignatura.PeticionAdmision;
import asignatura.Asignatura;
import sistema.Sistema;

public class ProfesorTest {

	Profesor p1;
	Estudiante e1;
	Asignatura a1;
	PeticionAdmision pet1;
	
	@Before
	public void setup(){
		p1 = new Profesor("admin","password");
		
	}
	@Test
	public void testProfesor() {
		assertNotNull (p1);
		
		assertEquals(p1.getUsuario(), "admin");
		assertEquals(p1.getContraseña(), "password");
	}

	@Test
	public void testAceptarPeticionAdmision() {
		e1 = new Estudiante("useractual", "pass", "Jose", "Pérez Pérez", 123, "jose.perez@email.es");
		a1 = new Asignatura("CIREL");
		pet1 = new PeticionAdmision("Solicitud de admision", e1, a1);
		List <PeticionAdmision> peticiones = new ArrayList<PeticionAdmision>();
		assertTrue(peticiones.add(pet1));
		p1.aceptarPeticionAdmision(pet1);		
		assertTrue (e1.getAsignaturas().contains(a1));
	}

	@Test
	public void testDenegarPeticionAdmision() {
		e1 = new Estudiante("useractual", "pass", "Jose", "Pérez Pérez", 123, "jose.perez@email.es");
		a1 = new Asignatura("CIREL");
		pet1 = new PeticionAdmision("Solicitud de admision", e1, a1);
		List <PeticionAdmision> peticiones = new ArrayList<PeticionAdmision>();
		assertTrue(peticiones.add(pet1));
		p1.denegarPeticionAdmision(pet1);		
		assertFalse(e1.getAsignaturas().contains(a1));
		assertTrue(e1.getAsignaturas().isEmpty());
	}

	@Test
	public void testBuscarAsignatura() {
		a1 = Sistema.getSistema().crearAsignatura("CIREL");
		assertEquals(p1.buscarAsignatura(a1.getNombre()), a1);
	}

}
