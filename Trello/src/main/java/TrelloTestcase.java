import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TrelloTestcase {
	@Test
	public void testcase() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D://driver//chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.get("https://trello.com/");
		driver.findElementByLinkText("Log in").click();
		driver.findElementById("user").sendKeys("sandipumap1996@gmail.com");
		driver.findElementById("login").click();
		Thread.sleep(5000);
		WebElement pass = driver.findElementByXPath("//input[@id='password']");
		System.out.println(pass.isDisplayed());
		pass.sendKeys("sandip@N1234");

		driver.findElementById("login-submit").click();

		driver.findElementByXPath("//div[@class='board-tile mod-add']").click();

		driver.findElementByXPath("//input[@class='nch-textfield__input Hj0IB7nx8rs7UO Hj0IB7nx8rs7UO ysTE7s-UXRkpYP']")
				.sendKeys("test");
		driver.findElementByXPath("//button[text()='Create']").click();
//			driver.findElementByXPath("//span[text()='Add a list']").click();
		driver.findElementByXPath("//input[@name='name']").sendKeys("ListA");
		driver.findElementByXPath("//input[@value='Add list']").click();
		driver.findElementByXPath("//input[@name='name']").sendKeys("ListB");
		driver.findElementByXPath("//input[@value='Add list']").click();
		List<WebElement> list = driver.findElementsByXPath("//div[@class='js-list list-wrapper']");
		for(WebElement a:list) {
			if(a.getText().contains("ListA")) {
				a.findElement(By.xpath("//span[text()='Add a card']")).click();
				driver.findElementByXPath("//textarea[@placeholder='Enter a title for this card…']").sendKeys("TestCard");
				driver.findElementByXPath("//input[@value='Add card']").click();
				WebElement card= driver.findElementByXPath("//span[text()='TestCard']");
				
		}
			else if(a.getText().contains("ListB")) {
				Actions act= new Actions(driver);
				WebElement card= driver.findElementByXPath("//span[text()='TestCard']");
				act.clickAndHold(card).moveToElement(a).release().build().perform();
				Thread.sleep(5000);
				WebElement car= driver.findElementByXPath("//span[text()='TestCard']");
				int x=car.getLocation().getX();
				int y=car.getLocation().getY();
				System.out.println("X coordinate of card" +":"+ x);
				System.out.println("Y coordinate of card" +":"+ y);
				
			}
			
	}
		driver.findElementByXPath("//span[@title='sandip (sandipumap1996)']").click();
		driver.findElementByXPath("//span[text()='Log out']").click();
		driver.findElementById("logout-submit").click();
	}

}
