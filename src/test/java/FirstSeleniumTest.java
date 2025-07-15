import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstSeleniumTest {
	@Test
	public void checkPageTitle() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://practicesoftwaretesting.com/contact");



		assertEquals("", By.tagName("h3"));

		driver.quit();
	}
}
