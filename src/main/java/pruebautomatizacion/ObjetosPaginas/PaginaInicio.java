package pruebautomatizacion.ObjetosPaginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
	
	WebDriver driver;

	public PaginaInicio(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="element-0")
	WebElement usuarioEmail;
	
	@FindBy(id="element-3")
	WebElement contraseña;
	
	@FindBy(css="[class*=rWfXb]")
	WebElement submitSesion;
	
	public PaginaAgregarTarea paginaInicio(String Usuario, String Contraseña)
	{
		usuarioEmail.sendKeys(Usuario);
		contraseña.sendKeys(Contraseña);
		submitSesion.click();
		PaginaAgregarTarea pat = new PaginaAgregarTarea(driver);
		return pat;
		}
	
	public void linkInicio()
	{
		driver.get("https://app.todoist.com/auth/login");
	}
}
