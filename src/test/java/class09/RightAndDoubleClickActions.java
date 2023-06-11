package class09;

import Utlis.CommonMethods;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RightAndDoubleClickActions extends CommonMethods {
    public static void main(String[] args) {
        String url = "http://demo.guru99.com/test/simple_context_menu.html";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);


//        find the element to be right click
        WebElement rightClickBtn = driver.findElement(By.xpath("//span[text()='right click me']"));

//        Action class
        Actions action=new Actions(driver);
//        perform the right click
//        right click is also called context click
        action.contextClick(rightClickBtn).perform();

//        find the element which is edit option
        WebElement editOpt = driver.findElement(By.xpath("//span[text()='Edit']"));
        action.click(editOpt).perform();

//        on clicking edit alert appears
//        in order to handle the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

//        find the webElement to double click on
        WebElement doubleClick = driver.findElement(By.xpath("//button[contains(text(),'Double-Click')]"));
        action.doubleClick(doubleClick).perform();

    }
}

