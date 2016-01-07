package test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class test1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://search.yahoo.com/";
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @Test
  public void test() throws Exception {
driver.get("http://cse.unl.edu/~mouna/WebApps/AddressBook/addressbookv3.3.5/index.php");
    driver.findElement(By.linkText("add new")).click();
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys("James");
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys("Pitt");
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys("44545 R street");
    driver.findElement(By.name("home")).clear();
    driver.findElement(By.name("home")).sendKeys("454545455");
    driver.findElement(By.name("mobile")).clear();
    driver.findElement(By.name("mobile")).sendKeys("454554555");
    driver.findElement(By.name("work")).clear();
    driver.findElement(By.name("work")).sendKeys("455455555");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("j.pitt@gmail.com");
    driver.findElement(By.name("email2")).clear();
    driver.findElement(By.name("email2")).sendKeys("jamespitt@hotmail.com");
    new Select(driver.findElement(By.name("bday"))).selectByVisibleText("7");
    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText("May");
    driver.findElement(By.name("byear")).clear();
    driver.findElement(By.name("byear")).sendKeys("1992");
  
   
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("home")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
