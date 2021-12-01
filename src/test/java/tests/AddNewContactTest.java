package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTest extends TestBase {
//login

    @BeforeMethod(alwaysRun = true)
    public void precondition () {
        if (!app.getUser().isLogged()){
            app.getUser().login(new User().withEmail("eriknet201@mail.ru").withPassword("Erik12345$"));
        }
    }
        @Test (invocationCount = 1,groups = {"web","smoke"})
        public void addNewContactTest(){

            int index = (int) (System.currentTimeMillis() / 1000) % 3600;
            Contact contact = Contact.builder()
                    .name("Er")
                    .lastName("si")
                    .phone("1234567" + index)
                    .email("er" + index + "@gmail.com")
                    .address("Tel Aviv")
                    .description("brother")
                    .build();
            app.contact().openContactForm();
            app.contact().fillContactForm(contact);
            app.contact().submitContactForm();

            //Assert.assertTrue(app.getUser().isMainContactPagePresent());
            Assert.assertTrue(app.contact().isContactCreated(contact.getPhone()));
        }

    @AfterMethod
    public void stop() {

        app.stop();
    }

    }




