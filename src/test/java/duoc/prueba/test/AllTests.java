package duoc.prueba.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAgregarCliente.class, TestEliminarUnCliente.class, TestListarTodosClientes.class,
		TestListarUnCliente.class, TestModificarUnCliente.class })
public class AllTests {

}
