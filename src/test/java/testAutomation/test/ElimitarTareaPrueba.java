package testAutomation.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pruebautomatizacion.ObjetosPaginas.DeleteTask;
import pruebautomatizacion.ObjetosPaginas.PaginaAgregarTarea;
import testAutomation.testComponents.BasePruebas;

public class ElimitarTareaPrueba extends BasePruebas{

	String usuarioEmail = "correo@gmail.com";
	String contraseña = "Camilo.880*";
	String nombreTarea ="prueba 4";
	
	@Test
	public void eliminaTarea()
	{
		//Metodo para iniciar sesión
		PaginaAgregarTarea pat = paginaInicio.paginaInicio(usuarioEmail, contraseña);
		DeleteTask dt = pat.deletTask();
		Assert.assertTrue(dt.taskDelete(nombreTarea));
		
		
	}
	
	
}
