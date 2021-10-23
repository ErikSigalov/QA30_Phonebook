import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    WebDriver wd;

        @BeforeMethod


        public void init(){
            wd=new ChromeDriver();
            wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        }

        @Test
        public void loginPositiveTest() {

                wd.findElement(By.xpath("//button[1]")).click();
                //Assert if button Logout is


                Assert.assertTrue(wd.findElements(By.xpath("//button[text()='Sign Out']")).size() > 0);

            }

            @AfterMethod
            public void tearDown () {
                //wd.quit();
            }

            @Test
            public void loginTest2 () {
                String email = "erik@mail.ru";
                String password = "Er120390!";

                openLoginRegistrationForm();
                fillLoginRegistrationForm(email, password);
                submitLogin();
                pause(5000);

                Assert.assertTrue(isElementPresent(By.xpath("//button[text()='Sign Out']")));
            }
        }
