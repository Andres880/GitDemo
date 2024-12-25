package testAutomation.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pruebautomatizacion.ObjetosPaginas.EditarTarea;
import pruebautomatizacion.ObjetosPaginas.PaginaAgregarTarea;
import testAutomation.testComponents.BasePruebas;

public class ModificarTareaPrueba extends BasePruebas {
	
	String usuarioEmail = "correo@gmail.com";
	String contraseña = "Camilo.880*";
	String nombreTarea ="prueba 1";
	String nuevaTareaEdit = "prueba 0";
	@Test
	public void modificarTareaPrueba()
	{
		//Metodo el cual edita una tarea
	PaginaAgregarTarea paginaAgregarTarea = paginaInicio.paginaInicio(usuarioEmail, contraseña);
	EditarTarea editarTarea =  paginaAgregarTarea.botonEditarTarea();
	Assert.assertTrue(editarTarea.editTarea(nombreTarea, nuevaTareaEdit));
	}
}
