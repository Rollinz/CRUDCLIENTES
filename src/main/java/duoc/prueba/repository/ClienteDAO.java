package duoc.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import duoc.prueba.modelo.Cliente;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente, String> {
	public Cliente findByNombres(String nombre);
}
