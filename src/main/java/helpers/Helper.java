package helpers;

import org.openqa.selenium.WebDriver;

public class Helper {
	private WebDriver driver;
	
	public Helper(WebDriver driver) {
		this.driver = driver;
	}
	
	//esperar una determinada cantidad de segundos
		public void esperar(int segundos) {
			try {
				Thread.sleep(segundos*1000);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

}
