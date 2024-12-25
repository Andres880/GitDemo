package pruebautomatizacion.ObjetosPaginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pruebautomatizacion.Componentes.Componentes;

public class PaginaAgregarTarea extends Componentes {

	WebDriver driver;	
	
	public PaginaAgregarTarea(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[class*=vZhNClH]")
	WebElement submitAgregar;
	
	@FindBy(css="div[class*='content_field'] p")
	WebElement agregarText;
	
	@FindBy(css="button[data-testid*='submit']")
	WebElement submitAñadir;
	
	
	By botonTarea = By.cssSelector("[class*=vZhNClH]");
	
	public WebElement botonAgregarTarea()
	{
		waitForElementToAppear(botonTarea);
		return submitAgregar;
	}	
	
	public VerificarTareaAgregada agregarTarea(String nombreTarea)
	{
		botonAgregarTarea().click();
		agregarText.sendKeys(nombreTarea);
		submitAñadir.click();
		VerificarTareaAgregada verificaTarea = new VerificarTareaAgregada(driver);
		return verificaTarea;		
	}
	
}
