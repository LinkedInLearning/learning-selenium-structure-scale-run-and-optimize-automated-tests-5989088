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

	public void fillForm(){
		//FillForm
		driver.findElement(firstNameLoc).sendKeys("John");
		driver.findElement(lastNameLoc).sendKeys("Smith");
		driver.findElement(emailLoc).sendKeys("john.smith@example.com");

		Select subjectSelect = new Select(driver.findElement(subjectLoc));
		subjectSelect.selectByValue("webmaster");

		driver.findElement(messageLoc).sendKeys("Hello My name is John Smith, Please make sure we have got 50 characters in this message.");
	}

	public void submitForm() {
		driver.findElement(btnSubmitLoc).click();
	}
}
