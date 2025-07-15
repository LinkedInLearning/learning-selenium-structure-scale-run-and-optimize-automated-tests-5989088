import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) { this.driver = driver; }

	By emailLoc = By.id("email");
	By passwordLoc = By.id("password");
	By btnSubmitLoc = By.className("btnSubmit");

	public void loginAs(String username, String password){
		driver.findElement(emailLoc).sendKeys(username);
		driver.findElement(passwordLoc).sendKeys(password);
		driver.findElement(btnSubmitLoc).click();
	}

}
