package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import java.util.List;





public class dropdown {
	
	@Test
	public void selectDropdown() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
		WebElement dayDropdown = driver.findElement(By.id("select-demo"));
		Select sel = new Select(dayDropdown);
		sel.selectByVisibleText("Friday");
		WebElement firstSelectedOption = sel.getFirstSelectedOption();
		System.out.println("Select dropdown value: "+firstSelectedOption.getText());
		//sel.selectByIndex(2);
	    //sel.selectByValue("Sunday"); qr
		//multiple function
		WebElement multiDropdown = driver.findElement(By.id("multi-select"));
		Select countries = new Select(multiDropdown);
		countries.selectByIndex(4);
		countries.selectByVisibleText("New York");
		countries.selectByValue("Texas");
		List<WebElement> allSelectedOptions = countries.getAllSelectedOptions();
		for (WebElement country : allSelectedOptions) {
			System.out.println("selected options are: "+country.getText());
		}
		
		//button
		WebElement button = driver.findElement(By.id("printMe"));
		button.click();
		WebElement button1 = driver.findElement(By.id("printAll"));
		button1.click();
		
		driver.close();
		
	}

}
