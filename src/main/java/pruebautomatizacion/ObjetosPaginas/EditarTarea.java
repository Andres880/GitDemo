package pruebautomatizacion.ObjetosPaginas;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pruebautomatizacion.Componentes.Componentes;

public class EditarTarea extends Componentes{
	WebDriver driver;
	int count = 0;
	public EditarTarea(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
		
		PageFactory.initElements(driver, this);		
	}

	@FindBy(css=".MIKYuSS")
	List<WebElement> tareas;	
	@FindBy(css="li[data-testid ='task_list_editor_wrapper']")
	WebElement editTarea;
			
	By tareasBy = By.cssSelector(".MIKYuSS");
	By nombresTareas = By.cssSelector(".task_content");
	By botonBy = By.cssSelector("div[class*='YjMLlDP'] button:first-of-type");
	By touch = By.cssSelector("div[class='task_list_item__body']");
	By tareaEdit = By.cssSelector("div[class='task_editor__content_field no-focus-marker'] p");
	By submitTarea = By.cssSelector("button[data-testid*='submit']");

	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(tareasBy);
		return tareas;
	}
	
	public Boolean editTarea(String nombreTarea, String NuevaTarea)
	{
		Boolean result = false;
		WebElement elements = getProductList().stream().filter(ListTarea 
		-> ListTarea.findElement(nombresTareas).getText().equalsIgnoreCase(nombreTarea)).findFirst().orElseThrow();
	
		try {
			WebElement el = elements.findElement(touch);
			 Actions a = new Actions(driver);
			 a.moveToElement(el).build().perform();		 
			 waitForElementToAppear(botonBy);
			 elements.findElement(botonBy).click();
			 
			 waitForWebElementToAppear(editTarea);
			 editTarea.findElement(tareaEdit).clear();
			 editTarea.findElement(tareaEdit).sendKeys(NuevaTarea);
			 editTarea.findElement(submitTarea).click();
			 
			 result = true;
			
		} catch (Exception ex) {
			ex.printStackTrace();
            result = false;
		}
		
		return result;
	
	}
}
