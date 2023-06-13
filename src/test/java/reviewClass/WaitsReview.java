package reviewClass;

import Utlis.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitsReview extends CommonMethods {
    public static void main(String[] args) {
        String url = "https://the-internet.herokuapp.com/dynamic_controls";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

//        find the checkbox and click on it
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkbox.click();

//        get the button and click on it
        WebElement removeButton = driver.findElement(By.xpath("//button[text()='Remove']"));
        removeButton.click();

//        we have to verify that the text it's gone appears up
        WebElement text = driver.findElement(By.xpath("//button[text()='Add']/following-sibling::p"));
        System.out.println(text.getText());


//        get the button enable
        WebElement enableBtn = driver.findElement(By.xpath("//form[@id='input-example']/child::button"));
        enableBtn.click();
//explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait until
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='input-example']/child::input")));
//   now send some text
        WebElement textBox = driver.findElement(By.xpath("//form[@id='input-example']/child::input"));
        System.out.println(textBox.isEnabled());
    }
}
