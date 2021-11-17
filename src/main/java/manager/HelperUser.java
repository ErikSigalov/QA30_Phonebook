package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase {


    public HelperUser(WebDriver wd) {
        super(wd);
    }


    public void submitRegistration() {
        click(By.xpath("//button[2]"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);
    }
    public void fillLoginRegistrationForm(User user) {
        type(By.xpath("//input[1]"), user.getEmail());
        type(By.xpath("//input[2]"), user.getPassword());
    }

    public void submitLogin() {
        click(By.xpath("//button[1]"));
    }

    public void openLoginRegistrationForm() {

        click(By.xpath("//a[text()='LOGIN']"));
    }


    public boolean isLogged() {
        return isElementPresent(By.xpath("//a[normalize-space()='LOGIN']"));

    }
    public void logout(){

        click(By.xpath("//button[text()='Sign Out']"));
    }

    public boolean isAlertPresent() {

        Alert alert = new WebDriverWait(wd,10)
                .until(ExpectedConditions.alertIsPresent());

        if(alert==null){
            return false;
        }else{
            wd.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();

            // alert.dismiss();
            //alert.sendKeys("jg");
            //alert.getText();
            return true;
        }
    }

    public boolean isErrorMessageWrongFormat() {
        Alert alert = new WebDriverWait(wd,10)
                .until(ExpectedConditions.alertIsPresent());
        String error = alert.getText();

        return error.contains("Wrong email or password format");

    }

    public void login(User user) {
        openLoginRegistrationForm();

        fillLoginRegistrationForm(user);
        submitLogin();
        pause(5000);
    }


    public boolean isMainContactPagePresent() {
        return isElementPresent(By.xpath("//div[@class='contact-page_main__32Irj']"));
    }
}