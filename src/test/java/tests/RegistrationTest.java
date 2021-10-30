package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RegistrationTest extends TestBase{
    WebDriver wd;

    @BeforeMethod
   public void preCondition(){
        if(app.getUser().isLogged()){
           app.getUser().logout();
        }
    }



    @Test
    public void registrationTestPositive(){

        int i=(int) (System.currentTimeMillis()/1000)%3600;
        String email = "david"+ i + "@gmail.com";
        String password ="David123$";
        System.out.println("Email: " +email);

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email,password);
        app.getUser().submitRegistration();

        //Assert.assertTrue(isElementPresent(By.xpath("//button[text()='Sign Out']")));
        Assert.assertTrue(app.getUser().isLogged());
    }


    @Test
    public void RegistrationTestWrongEmail() {
        int i =(int) (System.currentTimeMillis()/1000)%3600;
        String email = "david" + i + "gmail.com";
        String password = "David123$";
        System.out.println("Email:" + email);

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email,password);
        app.getUser().submitRegistration();

        app.getUser().pause(2000);
        //Assert.assertFalse(isElementPresent(By.xpath("//button[text()='Sign Out']")));
        //Assert.assertFalse(app.getUser().isLogged());
        Assert.assertTrue(app.getUser().isErrorMessageWrongFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());
    }



    }

