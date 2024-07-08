package com.org.happyfox;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;



public class Testcase101 {
//Separate Page Classes: Move the BasePage, LoginPage, HomePage, and TablePage classes to their own files.
//    instead of throwing exceptions, these exceptions can be handled by try catch blocks
	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Johny\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://interview.supporthive.com/staff/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("id_username")).sendKeys("Agent");
		driver.findElement(By.id("id_password")).sendKeys("Agent@123");
		driver.findElement(By.id("btn-submit")).click();
		WebElement tickets = driver.findElement(By.id("ember29"));
		Actions action = new Actions(driver);
		action.moveToElement(tickets).build().perform();
		WebElement statuses = driver.findElement(By.linkText("Statuses"));
		statuses.click();
		driver.findElement(By.xpath("/html/body/div[3]/div/section/section/div/header/button")).click();
		driver.findElement(By.tagName("input")).sendKeys("Issue Created");
		WebElement statusColourSelect =
		          driver.findElement(By.xpath("//div[@class='sp-replacer sp-light']"));
		          statusColourSelect.click();
//code formatting can be done
		          WebElement statusColourEnter =
		          driver.findElement(By.xpath("//input[@class='sp-input']"));
//both should be in differents lines, code formatting is needed
		          statusColourEnter.clear(); statusColourEnter.sendKeys("#47963f");
//code formatting can be done
		          Robot r = new Robot();
		          r.keyPress(KeyEvent.VK_ESCAPE);
	
        WebElement firstElement = driver.findElement(By.xpath("//a[@id='first-link']"));
        firstElement.click();

       
        WebElement secondElement = driver.findElement(By.xpath("//a[@id='second-link']"));
        secondElement.click();
        

		
		driver.findElement(By.tagName("textarea")).sendKeys("Status when a new ticket is created in HappyFox");
		WebElement addCreate = driver.findElement(By.xpath("//button[@class ='hf-entity-footer_primary hf-primary-action ember-view']"));
//        code formatting is needed
	      addCreate.click();
//Instead of thread.sleep(), implicit, explicit or fluent wait can be used
	      Thread.sleep(3000);

	      WebElement moveTo = driver.findElement(By.xpath("//td[@class ='lt-cell align-center hf-mod-no-padding ember-view']"));
	      action.moveToElement(moveTo).build().perform();
	      moveTo.click();
//Instead of thread.sleep(), implicit, explicit or fluent wait can be used
	      Thread.sleep(9000);
	      
	      WebElement issue = driver.findElement(By.xpath("//div[contains(text(),'Issue Created')]"));
//code formatting can be done
			action.moveToElement(issue).build().perform();
			
			
	      WebElement make = driver.findElement(By.linkText("Make Default"));
	      make.click();
	      driver.findElement(By.linkText("Priorities")).click();
	      driver.findElement(By.xpath("//header/button[1]")).click();
	      driver.findElement(By.tagName("input")).sendKeys("Assistance required");
	      driver.findElement(By.tagName("textarea")).sendKeys("Priority of the newly created tickets");
	      WebElement button = driver.findElement(By.cssSelector("button[data-test-id='add-priority']"));
	      button.click();

//Instead of thread.sleep(), implicit, explicit or fluent wait can be used
Thread.sleep(9000);
//code formatting can be done
WebElement tickets2 = driver.findElement(By.id("ember29"));
action.moveToElement(tickets2).build().perform();
WebElement priorities2 = driver.findElement(By.linkText("Priorities"));
priorities2.click();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//instead of using relative xpath, please use xpath by using class, id or other components
driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/section[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[9]/td[2]")).click();
driver.findElement(By.linkText("Delete")).click();
WebElement delete = driver.findElement(By.cssSelector("button[data-test-id='delete-dependants-primary-action']"));
delete.click();

//Instead of thread.sleep(), implicit, explicit or fluent wait can be used
Thread.sleep(9000);
//instead of using relative xpath, please use xpath by using class, id or other components
driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/header[1]/div[2]/nav[1]/div[7]/div[1]/div[1]")).click();
driver.findElement(By.linkText("Logout")).click();
//close brackets are not present for the prevoious class


//        close bracket for this class is missing
public class PagesforAutomationAssignment {
//    Proper Exception Handling: Use try-catch-finally blocks to handle exceptions and ensure the WebDriver is properly closed.
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.happyfox.com");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("username", "password");

        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();

        driver.quit();
    }

    static class BasePage {
        protected WebDriver driver;

        public BasePage(WebDriver driver) {
            this.driver = driver;
        }
    }

    static class LoginPage extends BasePage {
        public LoginPage(WebDriver driver) {
            super(driver);
        }

        public void login(String username, String password) {

            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.id("loginButton")).click();
        }

        public void forgotPassword() {
            driver.findElement(By.linkText("Forgot password?")).click();
        }
    }

    static class HomePage extends BasePage {
        public HomePage(WebDriver driver) {
            super(driver);
        }

        public void verifyHomePage() {
            if (!driver.getCurrentUrl().equals("https://www.happyfox.com/home")) {
                throw new IllegalStateException("Not on the home page");
            }
        }

        public void navigateToProfile() {
            driver.findElement(By.id("profileLink")).click();
        }

    public class TablePage extends BasePage {

    private By rowLocator = By.xpath("//table[@id='dataTable']/tbody/tr");

    public TablePage(WebDriver driver) {
        super(driver);
    }

    public void retrieveRowTexts() {
        List<WebElement> rows = driver.findElements(rowLocator);

        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            String rowText = row.getText();
            System.out.println("Row " + i + " Text: " + rowText);
        }
    }




	}

}