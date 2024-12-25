package pruebautomatizacion.ObjetosPaginas;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pruebautomatizacion.Componentes.Componentes;

public class DeleteTask extends Componentes {

	WebDriver driver;
	
	public DeleteTask(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".MIKYuSS")
	List<WebElement> tareas;
	@FindBy(css="div[role='menuitem']")
	WebElement contOption;
	@FindBy(css="div[class*='_45139719']")
	WebElement contDelete;
	
	
	By tareasBy = By.cssSelector(".MIKYuSS");
	By nombresTareas = By.cssSelector(".task_content");
	By touch = By.cssSelector("div[class='task_list_item__body']");
	By butOption = By.cssSelector("div[class*='YjMLlDP'] button:last-of-type");
	By butDeleteBy = By.xpath("//div[text()='Eliminar']");
	By butDeletSubmit = By.cssSelector("button[type='submit']");
	
	public List<WebElement> getTaskList()
	{
		waitForElementToAppear(tareasBy);
		return tareas;
	}
		
	public Boolean taskDelete(String nombreTarea)
	{
		Boolean result = false;
		WebElement elements = getTaskList().stream().filter(ListTarea 
		-> ListTarea.findElement(nombresTareas).getText().equalsIgnoreCase(nombreTarea)).findFirst().orElseThrow();
		
		try {
			WebElement el = elements.findElement(touch);
			 Actions a = new Actions(driver);
			 a.moveToElement(el).build().perform();			
			 elements.findElement(butOption).click();
			 
			 waitForWebElementToAppear(contOption);
			 contOption.findElement(butDeleteBy).click();
			 
			 waitForWebElementToAppear(contDelete);
			 contDelete.findElement(butDeletSubmit).click();
			 
			 result = true;
			 
		} catch (Exception e) {
			
			e.printStackTrace();
			result= false;
		}
		
		return result;
	}	
	
}
