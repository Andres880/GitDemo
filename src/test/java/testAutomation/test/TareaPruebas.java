package testAutomation.test;

import org.testng.annotations.Test;

import pruebautomatizacion.ObjetosPaginas.PaginaAgregarTarea;
import testAutomation.testComponents.BasePruebas;

public class TareaPruebas extends BasePruebas{

	String usuarioEmail = "correo@gmail.com";
	String contraseña = "Camilo.880*";
	String nombreTarea ="prueba tarea 1";

	@Test
	public void tarea()
	{
		//Metodo de inicio de sesión de pagina de inicio
		paginaInicio.paginaInicio(usuarioEmail, contraseña);
		
		
	}
}
