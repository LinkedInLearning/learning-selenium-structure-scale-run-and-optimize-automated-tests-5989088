import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest {

	@ParameterizedTest
	@Tag("smoke")
	@CsvFileSource(resources = "/login-data.csv", numLinesToSkip = 0)
	public void testLoginWithMultipleUsers(String username, String password) {
		driver.get("https://practicesoftwaretesting.com/auth/login");

		LoginPage loginPagePom = new LoginPage(driver);
		loginPagePom.loginAs(username, password);

		AccountPage accountPage = new AccountPage(driver);

		// Add explicit wait for the page title to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement alert = wait.until(
			ExpectedConditions.visibilityOfElementLocated(accountPage.pageTitle)
		);
		String pageTitle = driver.findElement(accountPage.pageTitle).getText().trim();

		assertEquals("My account", pageTitle);
	}
}
