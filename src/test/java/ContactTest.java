import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactTest extends BaseTest {
	@Test
	public void testContactFormSubmit() {
		driver.get("https://practicesoftwaretesting.com/contact");

		ContactPage contactPagePom = new ContactPage(driver);

		//FillForm
		contactPagePom.fillForm();

		// Submit
		contactPagePom.submitForm();

		// Add explicit wait for the success alert to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement alert = wait.until(
			ExpectedConditions.visibilityOfElementLocated(contactPagePom.alertLoc)
		);
		String alertText = alert.getText().trim();

		assertEquals("Thanks for your message! We will contact you shortly.", alertText);
	}
}
