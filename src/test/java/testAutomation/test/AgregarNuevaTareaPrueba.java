package testAutomation.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pruebautomatizacion.ObjetosPaginas.PaginaAgregarTarea;
import pruebautomatizacion.ObjetosPaginas.VerificarTareaAgregada;
import testAutomation.testComponents.BasePruebas;

public class AgregarNuevaTareaPrueba extends BasePruebas{
	
	String usuarioEmail = "correo@gmail.com";
	String contraseña = "Camilo.880*";
	String nombreTarea ="prueba 5";
	
	@Test
	public void agregarNuevaTarea()
	{
		PaginaAgregarTarea paginaAgregarTarea = paginaInicio.paginaInicio(usuarioEmail, contraseña);
		VerificarTareaAgregada verificarTareaAgregada = paginaAgregarTarea.agregarTarea(nombreTarea);
		Assert.assertTrue(verificarTareaAgregada.verificarTarea(nombreTarea));


	}
	
}
