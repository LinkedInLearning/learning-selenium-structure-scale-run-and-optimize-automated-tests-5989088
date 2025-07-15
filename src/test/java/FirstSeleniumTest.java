import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstSeleniumTest {
	@Test
	public void checkPageTitle() {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://practicesoftwaretesting.com");

		assertEquals("Practice Software Testing - Toolshop - v5.0", driver.getTitle());

		driver.quit();
	}

	@Test
	public void checkContactHeading() {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://practicesoftwaretesting.com/contact");


		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));

		WebElement heading = wait.until(d-> driver.findElement(By.tagName("h3")));

		String headingText = heading.getText();

		assertEquals("Contact", headingText);

		driver.quit();
	}
}
