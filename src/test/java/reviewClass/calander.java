package reviewClass;

import Utlis.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

import java.util.List;

public class calander extends CommonMethods {
    public static void main(String[] args) {
        openBrowserAndLaunchApplication("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login", "chrome");
        WebElement userName=driver.findElement(By.id("txtUsername"));
        userName.sendKeys("admin");
        WebElement pass=driver.findElement(By.id("txtPassword"));
        pass .sendKeys("Hum@nhrm123");
        WebElement logIn= driver.findElement(By.id("btnLogin"));
        logIn .click();
        //click on recruitment
        WebElement recruitment=driver.findElement(By.xpath("//a[@id='menu_recruitment_viewRecruitmentModule']"));
        recruitment.click();

        driver.findElement(By.xpath("//input[@id='candidateSearch_fromDate']/following-sibling::img")).click();


        WebElement mmDD = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select sel=new Select(mmDD);
        sel.selectByVisibleText("Sep");

        WebElement year = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select select=new Select(year);
        select.selectByVisibleText("1923");

//get the table
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));

        for(WebElement dates:allDates){
            String dateToday = dates.getText();
            if(dateToday.equals("1")){
                dates.click();
                break;
            }
        }
    }
}
