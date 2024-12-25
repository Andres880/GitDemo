package pruebautomatizacion.Componentes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pruebautomatizacion.ObjetosPaginas.DeleteTask;
import pruebautomatizacion.ObjetosPaginas.EditarTarea;

public class Componentes {

	WebDriver driver;
	
	public Componentes(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForElementToAppear(By findBy )
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement findBy)
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitForElementToDesappear(By element) 
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	//Funcion el cual tiene objeto para editar tarea
	public EditarTarea botonEditarTarea()
	{
		EditarTarea editarTarea = new EditarTarea(driver);
		return editarTarea;
	}
	public DeleteTask deletTask()
	{
		DeleteTask delTask = new DeleteTask(driver);		
		return delTask;	
	}
	
}
