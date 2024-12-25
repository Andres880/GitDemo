package testAutomation.testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pruebautomatizacion.ObjetosPaginas.PaginaInicio;

public class BasePruebas{	

	WebDriver driver;
	public PaginaInicio paginaInicio;

	public WebDriver inicializarDriver() throws IOException
	{
		String datoGlobal= "C:/Users/alder/eclipse-workspace/SeleniumFrameworkTask/src/main/java/pruebautomatizacion/recursos/DatosGlobales.Datos";
		
		Properties pro = new Properties();
		File f = new File(datoGlobal);
		FileInputStream fis = new FileInputStream(f);
		pro.load(fis);
		
		//Trae todas las propiedades de los motores de busqueda
		String browserName = pro.getProperty("Browser");
		
		
		if (browserName.equalsIgnoreCase("Chrome"))
		{
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();			
		}else if (browserName.equalsIgnoreCase("FireFox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//La el metodo maximize ampliara la ventana del navegador
		driver.manage().window().maximize();
		
		return driver;
	}
	
	@BeforeMethod
	public PaginaInicio lanzarAplicacion() throws IOException
	{
		driver = inicializarDriver();
		paginaInicio = new PaginaInicio(driver);
		paginaInicio.linkInicio();
		return paginaInicio;
	}
	
//	@AfterMethod
//	public void cerrarPaginas()
//	{
//		driver.close();
//	}
	
	
	
}
