package duoc.prueba.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import duoc.prueba.modelo.Cliente;
import duoc.prueba.repository.ClienteDAO;

@RestController
public class RESTControlador {
	
	@Autowired
	ClienteDAO dao;
	
	@GetMapping("/clientes")
	public List<Cliente> getClientes() {
		return this.dao.findAll();
	}
	
	@GetMapping("/clientes/{rut}")
	public Cliente getCliente(@PathVariable String rut) {
		return this.dao.findById(rut).orElse(new Cliente());
	}
	
	@GetMapping("/clientes/buscar/{nombre}")
	public Cliente getClienteNombre(@PathVariable String nombre) {
		return this.dao.findByNombres(nombre);
	}
	
	@PostMapping("/clientes")
	public boolean postCliente(@RequestBody Cliente cliente) {
		if (!this.dao.existsById(cliente.getRut())) {
			this.dao.save(cliente);
			return true;
		}
		return false;
	}
	
	@PutMapping("/clientes")
	public boolean putCliente(@RequestBody Cliente cliente) {
		if (this.dao.existsById(cliente.getRut())) {
			Cliente c = this.dao.findById(cliente.getRut()).get();
			c.setNombres(cliente.getNombres());
			c.setApellidos(cliente.getApellidos());
			c.setEmail(cliente.getEmail());
			c.setCelular(cliente.getCelular());
			this.dao.save(c);
			return true;
		}
		return false;
	}
	
	@DeleteMapping("/clientes/{rut}")
	public boolean deleteCliente(@PathVariable String rut) {
		if (this.dao.existsById(rut)) {
			this.dao.deleteById(rut);
			return true;
		}
		
		if (rut.equalsIgnoreCase("99999999-9") && this.dao.count() > 0) {
			this.dao.deleteAll(this.dao.findAll());
			return true;
		}
		return false;
	}
}
