package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase {
    //before
    //removeOneContact
    //removeAllContact

    @BeforeMethod
    public void precondition() {
        if (!app.getUser().isLogged()) {
            app.getUser().login(new User().withEmail("eriknet201@mail.ru").withPassword("Erik12345$"));
        }


    }
        @Test
         public void removeOneContact(){

            int result = app.contact().removeOneContact();
            Assert.assertEquals(result,-1);

        }

        @Test
    public void removeAllContacts(){
        app.contact().removeAllContacts();
        Assert.assertTrue(app.contact().isContactNotHere());
        }
}
