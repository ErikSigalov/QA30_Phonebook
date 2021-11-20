package tests;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

    @Test(groups = {"web"})
    public void loginTest2() {
        User user = new User().withEmail("eriknet201@mail.ru").withPassword("Erik12345$");

        String email = "erik201@mail.ru";
        String password = "Erik12345$";

        app.getUser().openLoginRegistrationForm();
        //app.getUser().fillLoginRegistrationForm(email, password);
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(5000);

        //Assert.assertTrue(isElementPresent(By.xpath("//button[text()='Sign Out']")));
        Assert.assertTrue(app.getUser().isLogged());
    }


}