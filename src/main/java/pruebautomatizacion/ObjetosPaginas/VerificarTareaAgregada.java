package pruebautomatizacion.ObjetosPaginas;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerificarTareaAgregada {

	WebDriver driver;	
	
	public VerificarTareaAgregada(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="div[class='task_content']")
	List<WebElement> nombreTareas;	
	
	public Boolean verificarTarea(String nomTarea)
	{
		Boolean macth = nombreTareas.stream().anyMatch(listTarea -> listTarea.getText().equalsIgnoreCase(nomTarea));
		return macth;
	}
	
	
}
