package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.appDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import java.sql.Driver;
import java.sql.DriverManager;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class loginPage {

    public loginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(appDriver.getDriver()), this);
    }

    @FindBy(id = "com.booking:id/identity_landing_social_button")
    public WebElement createAccount;

    @FindBy(id = "com.booking:id/identity_text_input_edit_text")
    public WebElement emailAddress;

    @FindBy(id = "com.booking:id/identity_landing_social_button")
    public WebElement continue_Btn;

    @FindBy(id = "com.booking:id/identity_text_input_edit_text")
    public List<WebElement> password;

//    @FindBy(id = "com.booking:id/identity_text_input_layout")
//    public WebElement confirmPass;

    public void waitForElement(WebDriver d, WebElement elem) {

        WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOf(elem));

    }

    //Declare function of above keys
    public void createAccountButton() throws IllegalArgumentException {

        waitForElement(appDriver.getDriver(), createAccount);
        createAccount.click();
    }

    public void enterEmail(String  email) {
        emailAddress.sendKeys(email);
    }

    public void clickContButton() {
        continue_Btn.click();
    }

    public void enterPass(String pass) {

        password.get(0).sendKeys(pass);
        password.get(1).sendKeys(pass);
    }
}

//    public void enterConfirmPass(String pass){
//        waitForElement(appDriver.getDriver(), password);
//        confirmPass.sendKeys(pass);
//    }
//}
