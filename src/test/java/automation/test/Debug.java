package automation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Debug {


    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();

      try{
          driver.get("https://testautomationpractice.blogspot.com/");

          driver.findElement(By.id("name")).sendKeys("Name");
          driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

          driver.findElement(By.className("login-btn ")).click();

          String message = driver.findElement(By.cssSelector("#welcome-message")).getText();

          if (message.equalsIgnoreCase("elcome Admin")) {
              System.out.println("Login success");
          } else {
              System.out.println("Login failed");
          }
      }catch (Exception e){
          e.printStackTrace();
      }finally {
          driver.quit();
      }




    }
}
