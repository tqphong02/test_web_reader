package web_1;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

@Listeners(TestListener.class)
public class BTT_Test {
    @Test
    public void testLogin() throws InterruptedException {
        // Test case: Đăng nhập
        WebDriver driver = new EdgeDriver();

        try {
            driver.get("https://baotangtruyen10.com/");
            driver.manage().window().setSize(new Dimension(1189, 669));
            driver.findElement(By.cssSelector(".txtSearchKey")).click();
            Thread.sleep(1000); 
            driver.findElement(By.linkText("Đăng nhập")).click();
            
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_mainContent_login1_LoginCtrl_UserName")));

            driver.findElement(By.id("ctl00_mainContent_login1_LoginCtrl_UserName")).sendKeys("phongnhihaha@gmail.com");
            driver.findElement(By.id("ctl00_mainContent_login1_LoginCtrl_Password")).sendKeys("phong111");
            driver.findElement(By.id("ctl00_mainContent_login1_LoginCtrl_Password")).click();
            Thread.sleep(30000);
            driver.findElement(By.id("ctl00_mainContent_login1_LoginCtrl_Login")).click();
            Thread.sleep(6000);
            
            // Test passed
        } catch (Exception e) {
            // Test failed
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testSearch() throws InterruptedException {
        // Test case: Tìm kiếm
        WebDriver driver = new EdgeDriver();

        try {
            // Your search test steps here
            // Test passed
        } catch (Exception e) {
            // Test failed
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testFollow() throws InterruptedException {
        // Test case: Theo dõi
        WebDriver driver = new EdgeDriver();

        try {
            // Your follow test steps here
            // Test passed
        } catch (Exception e) {
            // Test failed
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testUnfollow() throws InterruptedException {
        // Test case: Bỏ theo dõi
        WebDriver driver = new EdgeDriver();

        try {
            // Your unfollow test steps here
            // Test passed
        } catch (Exception e) {
            // Test failed
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testLogout() throws InterruptedException {
        // Test case: Đăng xuất
        WebDriver driver = new EdgeDriver();

        try {
            // Your logout test steps here
            // Test passed
        } catch (Exception e) {
            // Test failed
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
