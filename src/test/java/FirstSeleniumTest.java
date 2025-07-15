import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstSeleniumTest extends BaseTest {
	@Test
	public void checkPageTitle() {
		driver.get("https://practicesoftwaretesting.com");
		assertEquals("Practice Software Testing - Toolshop - v5.0", driver.getTitle());
	}

	@Test
	public void checkContactHeading() {
		driver.get("https://practicesoftwaretesting.com/contact");


		WebElement heading = driver.findElement(By.tagName("h3"));

		String headingText = heading.getText();

		assertEquals("Contact", headingText);

	}
}
