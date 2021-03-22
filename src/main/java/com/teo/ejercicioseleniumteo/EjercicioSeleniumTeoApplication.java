package com.teo.ejercicioseleniumteo;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import helpers.Helper;

@SpringBootApplication
public class EjercicioSeleniumTeoApplication {

	public static void main(String[] args) {
		
		//Inicializando el chrome driver y el helper y maximizando la ventana de chrome
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		Helper helper = new Helper(driver);
		
		//Ingresando a la página de consultorpía global
		driver.navigate().to("https://www.consultoriaglobal.com.ar/cgweb/");
		
		System.out.println("Ingresando a www.consultoriaglobal.com.ar...");
		
		helper.esperar(1);
		
		//Obteniendo el hiperlink "contáctenos" y accionando un evento "click"
		By contactUsHLink = By.xpath("//*[@id=\"menu-item-1364\"]/a");
		
		driver.findElement(contactUsHLink).click();
		
		System.out.println("Pulsando el hyperlink 'Contáctenos'...");
		
		helper.esperar(1);
		
		//Obteniendo los campos de texto a rellenar y el boton de envío del formulario
		WebElement nameTField = driver.findElement(By.name("your-name"));
		
		WebElement emailTField = driver.findElement(By.name("your-email"));
		
		WebElement subjetctTField = driver.findElement(By.name("your-subject"));
		
		WebElement messageTField = driver.findElement(By.name("your-message"));
		
		WebElement submitBttn = driver.findElement(By.xpath("//*[@id=\"wpcf7-f1297-p370-o1\"]/form/p[7]/input"));
		
		//Rellenando los campos de texto e intentando enviar el formulario
		nameTField.sendKeys("Teo Alejandro Costa");
		
		System.out.println("Rellenando el textfield de nombre...");
		
		emailTField.sendKeys("Email inválido");
		
		System.out.println("Rellenando el textfield de mail...");
		
		subjetctTField.sendKeys("Ejercicio de automatización");

		System.out.println("Rellenando el textfield de asunto...");
		
		messageTField.sendKeys("Este es un ejercicio de automatización realizado con Java y Selenium.");

		System.out.println("Rellenando el textfield mensaje...");
		
		submitBttn.submit();

		System.out.println("Pulsando el boton de envío del formulario...");
		
		//Esperando a que se dispare la alerta y se recargue el dom
		helper.esperar(3);
		
		//Obteniendo el span de la alerta
		WebElement alerta = driver.findElement(By.xpath("//*[@id=\"wpcf7-f1297-p370-o1\"]/form/p[2]/span/span"));
		
		System.out.println("En la página imprimió la alerta: '" + alerta.getText() + "'");
		
		helper.esperar(1);
		
		System.out.println("Cerrando la página...");
		
		//Cerrando el chrome driver
		driver.close();
	}
	
	
}
