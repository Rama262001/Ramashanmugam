package cart;



import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;



public class AddingCart {
	public static String generateUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
	@Test
	public void cart() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[text()='Women']")).click();
		driver.findElement(By.xpath("//img[@alt='Radiant Tee']")).click();
		driver.findElement(By.xpath("//div[text()='M']")).click();
		driver.findElement(By.xpath("//div[@option-label='Blue']")).click();
		WebElement qtyInput = driver.findElement(By.id("qty"));
		qtyInput.clear();
		qtyInput.sendKeys("5");
		driver.findElement(By.xpath("//span[text()='Add to Cart']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class='action showcart']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Proceed to Checkout']")).click();
		Thread.sleep(7000);
		String randomUUID = generateUUID();
		driver.findElement(By.xpath("(//input[@id='customer-email'])[1]")).sendKeys(randomUUID + "abc@gmail.com");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Sam");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("vishal");
		driver.findElement(By.xpath("//input[@name='company']")).sendKeys("xyz company");
		driver.findElement(By.xpath("//input[@name='street[0]']")).sendKeys("33, Gandhi street");
		driver.findElement(By.xpath("//input[@name='street[1]']")).sendKeys("kodambakkam");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("chennai");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("600024");
		Select countrydropdown = new Select(driver.findElement(By.xpath("//select[@name='country_id']")));
		countrydropdown.selectByVisibleText("India");
		WebElement selectdropdown = driver.findElement(By.xpath("(//select)[1]"));
		Select dropdown = new Select(selectdropdown);
		Thread.sleep(10000);
		dropdown.selectByIndex(3);
		driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys("9005693020");
		driver.findElement(By.xpath("//input[@type='radio']")).click();
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//button[@title='Place Order']")).click();
		Thread.sleep(7000);
		String orderno = driver.findElement(By.xpath("//div[@class='checkout-success']//p//span")).getText();
		System.out.println("your order Id is:"+orderno);
        driver.quit();
	}
	

}
