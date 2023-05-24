package class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSdemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver =new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.facebook.com/");

//        click on create new account
        WebElement createNewAccount = driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']"));
        createNewAccount.click();
//        becuase the DOM doesnt have firstName by default
//        it only shows up after click on create new account
//        and the code takes some time to appear in DOM for firstName
//        so we must add a sleep here
        Thread.sleep(2000);

//        enter the first name
        WebElement fname = driver.findElement(By.cssSelector("input[name='firstname']"));
        fname.sendKeys("moazzam");

    }
}
