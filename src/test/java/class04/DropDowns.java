package class04;

import Utlis.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDowns extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {

        String url="https://www.facebook.com/";
        String browser="chrome";
        openBrowserAndLaunchApplication(url,browser);
///        click on create new account
        WebElement createNewAccount = driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']"));
        createNewAccount.click();
//        becuase the DOM doesnt have firstName by default
//        it only shows up after click on create new account
//        and the code takes some time to appear in DOM for firstName
//        so we must add a sleep here
        Thread.sleep(2000);
//     1.   find the element associate with the dropdown
        WebElement days = driver.findElement(By.xpath("//select[@id='day']"));
//        2.create an object of the select class and pass in the parameters the element dropdown
        Select sel = new Select(days);

//        3.use method provided in select class to select the option that u desire
        sel.selectByVisibleText("8");
//       for observation
        Thread.sleep(2000);
//        another method
        sel.selectByValue("26");
//       for observation
        Thread.sleep(2000);
//        another method
        sel.selectByIndex(0);

    }
}

