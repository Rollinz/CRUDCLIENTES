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
public class TestListarUnCliente {
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
	public void cuandoClienteExisteRetornaTrue() {
		Cliente cliente = this.dao.findById("1-1").get();
		assertTrue("Cuando el cliente no viene null retorna true", cliente != null);
	}
	
	@Test
	public void cuandoClienteNoExisteRetornaFalse() {
		Cliente cliente = this.dao.findById("1-8").orElse(new Cliente());
		assertFalse("Cuando el cliente no viene null retorna false", cliente==null);
	}
	
	@Test
	public void cuandoBuscaPorNombreYExisteRetornaTrue() {
		Cliente clienteOriginal = new Cliente("1-1", "Rolando Andres", "Aburto Olivares", "correo1@correo.cl", "123456789");
		Cliente cliente = this.dao.findByNombres("Rolando Andres");
		assertTrue("Si existe el cliente con ese nombre retorna true", clienteOriginal.equals(cliente));
	}
	
	@Test
	public void cuandoBuscaPorNombreYNoExisteEsNull() {
		Cliente cliente = this.dao.findByNombres("Esteban Efrain");
		assertNull("Cuando busca por nombre y no encuentra es null", cliente);
	}
}
