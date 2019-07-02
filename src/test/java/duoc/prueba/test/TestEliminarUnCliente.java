package duoc.prueba.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import duoc.prueba.modelo.Cliente;
import duoc.prueba.repository.ClienteDAO;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestEliminarUnCliente {
	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	ClienteDAO dao;
	
	@Before
	public void setUp() throws Exception {
		Cliente cliente = new Cliente("1-1", "Rolando Andres", "Aburto Olivares", "correo1@correo.cl", "123456789");
		entityManager.persist(cliente);
		
		cliente = new Cliente("1-2", "Andrea Elizabeth", "Quintrilef Almuna", "correo2@correo.cl", "789456123");
		entityManager.persist(cliente);
		
		cliente = new Cliente("1-3", "Oscar Andres", "Garcia Maldonado", "correo3@correo.cl", "987654321");
		entityManager.persist(cliente);
		
		cliente = new Cliente("1-4", "Patricia Macarena", "Quintrilef Almuna", "correo4@correo.cl", "123789456");
		entityManager.persist(cliente);
		
		cliente = new Cliente("1-5", "Paulina Andrea Del Pilar", "Castillo Flores", "correo5@correo.cl", "789654123");
		entityManager.persist(cliente);
		
		cliente = new Cliente("1-6", "Jose Isaias", "Varas Bravo", "correo6@correo.cl", "321456987");
		entityManager.persist(cliente);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test finalizado");
	}

	@Test
	public void cuandoIntentaBorrarYExisteRetornaTrue() {
		boolean estado = false;
		if (this.dao.existsById("1-1")) {
			this.dao.deleteById("1-1");
			estado = true;
		} else {
			estado = false;
		}
		assertTrue("Retorna True si modifica el cliente", estado);
	}

	@Test
	public void cuandoIntentaBorrarYNoExisteRetornaTrue() {
		boolean estado = false;
		if (!this.dao.existsById("1-8")) {
			estado = true;
		} else {
			this.dao.deleteById("1-1");
			estado = false;
		}
		assertTrue("Retorna False si modifica el cliente", estado);
	}
	
	@Test
	public void cuandoIntentaBorrarTodoRetornaTrue() {
		boolean estado = false;
		if (!this.dao.existsById("99999999-9") && this.dao.count() > 0) {
			this.dao.deleteAll();
			estado = true;
		} else {
			estado = false;
		}
		assertTrue("Retorna True si modifica el cliente", estado);
	}
	
	@Test
	public void cuandoIntentaBorrarTodoYNoHayNadaRetornaFalse() {
		this.dao.deleteAll();
		boolean estado = false;
		if (!this.dao.existsById("99999999-9") && this.dao.count() > 0) {
			this.dao.deleteAll();
			estado = true;
		} else {
			estado = false;
		}
		assertFalse("Retorna True si modifica el cliente", estado);
	}
}
