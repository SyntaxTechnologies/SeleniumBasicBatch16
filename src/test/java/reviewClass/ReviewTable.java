package reviewClass;

import Utlis.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ReviewTable extends CommonMethods {
    public static void main(String[] args) {
        String url = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);
        WebElement userName=driver.findElement(By.id("ctl00_MainContent_username"));
        userName.sendKeys("Tester", Keys.TAB);
        WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test",Keys.ENTER);


//        check all the checkboxes which have the product "My money"

//        get the column product in the list
        List<WebElement> products = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
        for(int i=0;i<products.size();i++){
            String product = products.get(i).getText();
            if(product.equals("MyMoney")){
                System.out.println("click the check box on row number"+i);
                String checkBoxXpath="//table/tbody/tr["+(i+2)+"]/td[1]";
                driver.findElement(By.xpath(checkBoxXpath)).click();

            }

        }
    }
}
