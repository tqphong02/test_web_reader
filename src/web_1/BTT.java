package web_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class BTT {

    public static void main(String[] args) throws InterruptedException {
        // Thiết lập đường dẫn đến Microsoft Edge WebDriver (msedgedriver.exe) trên máy của bạn
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Asus\\eclipse-workspace\\web1\\msedgedriver.exe");

        // Khởi tạo Microsoft Edge WebDriver
        WebDriver driver = new EdgeDriver();
        try {
            driver.get("https://baotangtruyen10.com/");
            driver.manage().window().setSize(new Dimension(1189, 669));
            driver.findElement(By.cssSelector(".txtSearchKey")).click();
            Thread.sleep(1000); // Dừng chương trình trong 1 giây
            driver.findElement(By.linkText("Đăng nhập")).click();
            
            // Đợi cho trường nhập tên đăng nhập xuất hiện trước khi thực hiện hành động tiếp theo
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_mainContent_login1_LoginCtrl_UserName")));

            driver.findElement(By.id("ctl00_mainContent_login1_LoginCtrl_UserName")).click();
            
            driver.findElement(By.id("ctl00_mainContent_login1_LoginCtrl_UserName")).sendKeys("phongnhihaha@gmail.com");
            driver.findElement(By.id("ctl00_mainContent_login1_LoginCtrl_Password")).click();
            
            driver.findElement(By.id("ctl00_mainContent_login1_LoginCtrl_Password")).sendKeys("phong111");
            driver.findElement(By.id("ctl00_mainContent_login1_LoginCtrl_Password")).click();
            Thread.sleep(20000);
            driver.findElement(By.id("ctl00_mainContent_login1_LoginCtrl_Login")).click();
            Thread.sleep(6000);

         
            // Tiếp tục với các bước kiểm thử khác sau khi đã đăng nhập
            driver.findElement(By.cssSelector(".txtSearchKey")).click(); 
            Thread.sleep(4000); 
            driver.findElement(By.cssSelector(".txtSearchKey")).sendKeys("thiên tài võ thuật");
            Thread.sleep(4000); 
            driver.findElement(By.cssSelector(".txtSearchKey")).sendKeys(Keys.ENTER);
            Thread.sleep(4000); 
            
            driver.findElement(By.cssSelector(".item:nth-child(1) > .clearfix img")).click();
            Thread.sleep(4000); 
            
            driver.findElement(By.cssSelector(".btn-success > span")).click(); // theo dõi truyen 
            Thread.sleep(4000); 
            
            driver.findElement(By.cssSelector("li[id='Login'] i[class='fa fa-chevron-down']")).click();  
            Thread.sleep(4000); 
            
            driver.findElement(By.cssSelector("li[id='Login'] a[title='Truyện đang theo dõi']")).click(); // vao trang theo doi
            Thread.sleep(4000);
            
            driver.findElement(By.cssSelector(".follow-link")).click(); // bo theo doi
            Thread.sleep(4000);
            
            driver.findElement(By.cssSelector(".sbtn.sbtnOk")).click(); // dong y bo theo doi
            Thread.sleep(6000); 

            driver.findElement(By.linkText("Thoát")).click();
            Thread.sleep(4000); 
           
        } finally {
//            Đóng trình duyệt
            driver.quit();
        }
    }
}
