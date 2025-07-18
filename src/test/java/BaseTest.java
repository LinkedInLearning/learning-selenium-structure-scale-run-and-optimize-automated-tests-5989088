import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@ExtendWith(ScreenShooterExtension.class)
public class BaseTest {
	protected WebDriver driver;

	@BeforeEach
	public void setUp() throws IOException {
		ChromeOptions chromeOptions = new ChromeOptions();

		// Create temp profile dir
		Path tempProfile = Files.createTempDirectory("chrome-profile");
		chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
		chromeOptions.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.6478.57 Safari/537.36");

		chromeOptions.addArguments("--user-data-dir=" + tempProfile.toAbsolutePath().toString());

		// Headless (optional)
		chromeOptions.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");

		Configuration.browser = "chrome";
		Configuration.browserCapabilities = chromeOptions;


		com.codeborne.selenide.Selenide.open("about:blank");
		driver = WebDriverRunner.getWebDriver();
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}
}
