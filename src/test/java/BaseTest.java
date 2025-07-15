import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseTest {
	protected WebDriver driver;

	@BeforeEach
	public void setUp() {
		String browser = System.getProperty("browser", "firefox").toLowerCase();

		switch(browser) {
			case "chrome":
				driver = new ChromeDriver(new ChromeOptions());
				break;
			case "firefox":
				driver = new FirefoxDriver(new FirefoxOptions());
				break;
			default:
				driver = new ChromeDriver(new ChromeOptions());
				break;
		}

	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}
}
