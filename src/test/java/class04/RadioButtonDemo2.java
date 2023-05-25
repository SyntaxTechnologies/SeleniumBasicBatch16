package class04;

import Utlis.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButtonDemo2 extends CommonMethods {
    public static void main(String[] args) {
        String url="http://practice.syntaxtechs.net/basic-radiobutton-demo.php";
        String browser="chrome";
        openBrowserAndLaunchApplication(url,browser);
        
//        get all the radio buttons associated with age group using 
//        driver.findElements
        List<WebElement> ageGroup = driver.findElements(By.xpath("//input[@name='ageGroup']"));
// u need to select the option specified by user
        String option ="15 - 50";

        for(WebElement age:ageGroup){

            String value = age.getAttribute("value");
            if(value.equals(option)){
                age.click();
                break;
            }
        }

    }
}
