package windowAndFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class WindowHandling {
	@Test
	public void windows() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");
		System.out.println("Parent window: "+driver.getTitle());
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		/*driver.findElement(By.linkText("Follow On Twitter")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		String title = driver.getTitle();
		System.out.println("child window: "+title);
		System.out.println(title);*/
		driver.findElement(By.linkText("Like us On Facebook")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> windows1 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(windows1.get(1));
		String title1 = driver.getTitle();
		System.out.println("child window1: "+driver.getTitle());
		System.out.println(title1);
		//switch to parent window
		driver.switchTo().window(parentWindow);
		System.out.println("Back to first page: "+driver.getTitle());
		driver.quit();
	}

}
