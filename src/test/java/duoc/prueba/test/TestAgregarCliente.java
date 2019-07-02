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
public class TestAgregarCliente {
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
	public void cuandoIntentaAgregarYNoExisteRetornaTrue() {
		boolean estado = false;
		Cliente cliente = new Cliente("1-9", "Mauricio Andres", "Inyelco Aguilera", "correo9@correo.cl", "1325467894"); 
		if (!this.dao.existsById(cliente.getRut())) {
			this.dao.save(cliente);
			estado = true;
		} else {
			estado = false;
		}
		assertTrue("Retorna True si agrega el cliente", estado);
	}

	@Test
	public void cuandoIntentaAgregarYExisteRetornaFalse() {
		boolean estado = false;
		Cliente cliente = new Cliente("1-9", "Mauricio Andres", "Inyelco Aguilera", "correo9@correo.cl", "1325467894"); 
		if (this.dao.existsById(cliente.getRut())) {
			this.dao.save(cliente);
			estado = true;
		} else {
			estado = false;
		}
		assertFalse("Retorna false si no agrega el cliente", estado);
	}
	
	@SuppressWarnings("unused")
	@Test
	public void cuandoIntentaAgregarUnObjetoNullRetornaFalse() {
		boolean estado = false;
		Cliente cliente = null;
		if (cliente == null) {
			estado = false;
		} else {
			this.dao.delete(cliente);
			estado = true;
		}
		assertFalse(estado);
	}
	
	@Test
	public void cuandoIntentaAgregarConUnCampoNullRetornaFalse() {
		boolean estado = false;
		Cliente cliente = new Cliente();
		if (cliente.getRut() != null 
			&& cliente.getNombres() != null
			&& cliente.getApellidos() != null
			&& cliente.getEmail() != null
			&& cliente.getCelular() != null
			&& !this.dao.existsById(cliente.getRut())) {
			this.dao.save(cliente);
			estado = true;
		} else {
			estado = false;
		}
		assertFalse("Cuando intenta agregar con un campo null entonces retorna false", estado);
	}
}
