import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstSeleniumTest {
	@Test
	public void checkPageTitle() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://practicesoftwaretesting.com");

		assertEquals("Practice Software Testing - Toolshop - v5.0", driver.getTitle());

		driver.quit();
	}

	@Test
	public void checkContactHeading() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://practicesoftwaretesting.com/contact");

		WebElement heading = driver.findElement(By.tagName("h3"));

		String headingText = heading.getText();

		assertEquals("Contact", headingText);

		driver.quit();
	}
}
