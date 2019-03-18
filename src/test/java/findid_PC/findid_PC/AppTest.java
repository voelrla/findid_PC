package findid_PC.findid_PC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

import java.awt.AWTException;

import com.codeborne.selenide.WebDriverRunner;

public class AppTest extends pushbullet_login {
	public static WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		WebDriverRunner.setWebDriver(driver);
	}

	@Test
	public void findID() throws Exception {
		open("https://front.wemakeprice.com/user/find/id");
		Mclick();

		$(By.xpath("//span[contains(.,'확인')]")).click();

		$(By.id("_name")).sendKeys("테스트");
		$(By.id("_phone")).sendKeys("01026989109");

		$(By.xpath("//span[contains(.,'인증번호 발송')]")).click();
		Pb();
		$(By.xpath("//span[contains(.,'확인')]")).click();

	}

	@AfterMethod
	public void end() {
		screenshot("account");
	}
}
