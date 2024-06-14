package tests;

import base.appFactory;
import io.qameta.allure.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.loginPage;
import utilities.excelReader;

import java.net.MalformedURLException;
import java.util.Random;

public class loginPageTest {

    loginPage login;
    appFactory factory;

   @BeforeTest
    public void setup() throws MalformedURLException, InterruptedException {
       factory = new appFactory();
       appFactory.initialize();
       login = new loginPage();
       excelReader.readExcelFile();
   }

    @Test
    @Epic("Booking.com")
    @Feature("Create account")
    @Description("Signup a user")
    @Severity(SeverityLevel.MINOR)

     public void createNewAccount() throws InterruptedException {

       Thread.sleep(1000);
       login.createAccountButton();
       String enterEmail = excelReader.GetCellValue(1, 0);
       String enterPass = excelReader.GetCellValue(1, 1);
       login.enterEmail("nam" + rand() + enterEmail);
       login.clickContButton();
       Thread.sleep(1000);
       login.enterPass(enterPass);

   }

   public int rand(){
       Random r = new Random();
       int x = r.nextInt(900) + 100;
       return x;
   }

   @AfterTest

      public void tearDown(){
       appFactory.quitDriver();
   }

}
