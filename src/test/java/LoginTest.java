import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver wd;

    @BeforeMethod
    public void init() {

    }
    @Test
    public void loginTestPositive(){
        
    }


    @AfterMethod
    public void tearDown() {

        wd.quit();

    }
}