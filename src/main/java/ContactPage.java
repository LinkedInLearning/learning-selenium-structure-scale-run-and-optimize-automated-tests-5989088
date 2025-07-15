import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ContactPage {
	private WebDriver driver;

	public ContactPage(WebDriver driver) { this.driver = driver; }

	By firstNameLoc = By.id("first_name");
	By lastNameLoc = By.id("last_name");
	By emailLoc = By.id("email");
	By subjectLoc = By.id("subject");
	By messageLoc = By.id("message");
	By btnSubmitLoc = By.className("btnSubmit");

	By alertLoc = By.className("alert");

	public void fillForm(String firstName, String lastName, String email, String subject, String message){
		//FillForm
		driver.findElement(firstNameLoc).sendKeys(firstName);
		driver.findElement(lastNameLoc).sendKeys(lastName);
		driver.findElement(emailLoc).sendKeys(email);

		Select subjectSelect = new Select(driver.findElement(subjectLoc));
		subjectSelect.selectByValue(subject);

		driver.findElement(messageLoc).sendKeys(message);
	}

	public void submitForm() {
		driver.findElement(btnSubmitLoc).click();
	}
}
