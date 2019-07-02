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
public class TestListarTodosClientes {
	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	ClienteDAO dao;

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test finalizado");
	}

	@Test
	public void cuandoListaSizeEs6RetornaTrue() {
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
		
		int largo = this.dao.findAll().size();
		assertTrue("Retorna True cuando el largo es 6", largo == 6);
	}
	
	@Test
	public void cuandoListaSizeEsCeroRetornaTrue() {
		int largo = this.dao.findAll().size();
		assertTrue("Retorna True cuando el largo es 0", largo == 0);
	}

}
