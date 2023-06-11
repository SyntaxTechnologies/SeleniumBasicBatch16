package class09;

import Utlis.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FileUpload extends CommonMethods {
    public static void main(String[] args) {
        String url = "https://the-internet.herokuapp.com/upload";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

//        find the element which u can click to upload the file
        WebElement fileUploadBtn = driver.findElement(By.xpath("//input[@id='file-upload']"));
//in order to send/upload the file
//   u can send the path of that file in sendKEys.
//        the file path willbe different for everyone depending on their own system
        fileUploadBtn.sendKeys("C:\\Users\\moazzam\\Desktop\\Java.txt");
    }
}
