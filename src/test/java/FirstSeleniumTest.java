import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstSeleniumTest extends BaseTest {
	@Test
	public void testContactFormSubmit() {
		driver.get("https://practicesoftwaretesting.com/contact");

		WebElement firstName = driver.findElement(By.id("first_name"));
		WebElement lastName = driver.findElement(By.id("last_name"));
		WebElement email = driver.findElement(By.id("email"));
		WebElement subject = driver.findElement(By.id("subject"));
		WebElement message = driver.findElement(By.id("message"));
		WebElement btnSubmit = driver.findElement(By.className("btnSubmit"));

		//FillForm
		firstName.sendKeys("John");
		lastName.sendKeys("Smith");
		email.sendKeys("john.smith@example.com");

		Select subjectSelect = new Select(subject);
		subjectSelect.selectByValue("webmaster");

		message.sendKeys("Hello My name is John Smith, Please make sure we have got 50 characters in this message.");

		// Submit
		btnSubmit.click();

		// Add explicit wait for the success alert to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement alert = wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.className("alert"))
		);
		String alertText = alert.getText().trim();

		assertEquals("Thanks for your message! We will contact you shortly.", alertText);
	}
}
