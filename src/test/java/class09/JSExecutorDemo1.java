package class09;

import Utlis.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSExecutorDemo1 extends CommonMethods {
    public static void main(String[] args) {

        String url = " http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);
//        find the text box
        WebElement userNameTxtBox = driver.findElement(By.xpath("//input[@id='txtUsername']"));

//        JSExecutor
        JavascriptExecutor js= (JavascriptExecutor) driver;
//        script
//        the script should draw a border around the WebElement
//        js.executeScript("arguments[0].style.backgroundColor='green'",userNameTxtBox);
            js.executeScript("arguments[0].style.border='5px solid green'",userNameTxtBox);

    }
}
