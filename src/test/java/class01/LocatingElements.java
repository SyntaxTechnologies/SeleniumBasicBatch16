package class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingElements {
    public static void main(String[] args) {
//        instance
        WebDriver driver=new ChromeDriver();
//        facebook.com
        driver.get("https://www.facebook.com/");
//        maximize the windows
        driver.manage().window().maximize();

//        send some text in the email
//        find the element                .  send some text
        driver.findElement(By.id("email")).sendKeys("moazam@gmail.com");

//          send some text to the password field
         driver.findElement(By.name("pass")).sendKeys("abracadbara");


//         print the url on console
        String url = driver.getCurrentUrl();
        System.out.println(url);

//        print the title on the console
        String title = driver.getTitle();
        System.out.println(title);
//        confirm that the title is "Facebook – log in or sign up"
        if(title.equals("Facebook – log in or sign up")){
            System.out.println("the title is correct");
        }
        else{
            System.out.println("the title is incorrect");
        }
//        close
        driver.quit();



    }
}
