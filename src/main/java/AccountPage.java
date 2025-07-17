import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
	private WebDriver driver;

	public AccountPage(WebDriver driver) { this.driver = driver; }

	By pageTitle = By.cssSelector("[data-test='page-title']");
}
