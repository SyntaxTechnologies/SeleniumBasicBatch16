package class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateCommand {
    public static void main(String[] args) throws InterruptedException {
//        create instance
        WebDriver driver=new ChromeDriver();

//        goto google.com
        driver.get("https://www.google.com");
//        slow down
        Thread.sleep(2000);
//        navigate to facebook.com
        driver.navigate().to("https://www.facebook.com/");
//        slow down
        Thread.sleep(2000);
//        refresh the page
        driver.navigate().refresh();
//        slow down
        Thread.sleep(1000);
//        goback to previous page
        driver.navigate().back();
//        slow down
        Thread.sleep(2000);
//        go forward
        driver.navigate().forward();

//        close the current tab
        driver.close();

    }
}

//8:14