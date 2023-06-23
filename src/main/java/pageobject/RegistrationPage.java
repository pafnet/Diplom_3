package pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {
    public final static String URL_REGISTER = "https://stellarburgers.nomoreparties.site/register";

    @FindBy(how = How.XPATH, using = "//label[text()='\u0418\u043c\u044f']/following-sibling::input")
    private SelenideElement nameField;

    @FindBy(how = How.XPATH, using = "//*[text()='Email']/following-sibling::input")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = "//*[text()='\u041f\u0430\u0440\u043e\u043b\u044c']/following-sibling::input")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = "//button[text()='\u0417\u0430\u0440\u0435\u0433\u0438\u0441\u0442\u0440\u0438\u0440\u043e\u0432\u0430\u0442\u044c\u0441\u044f']")
    private SelenideElement confirmRegistrationButton;

    @FindBy(how = How.XPATH, using = "//a[text()='\u0412\u043e\u0439\u0442\u0438']")
    private SelenideElement registrationPageAuthButton;

    @FindBy(how = How.XPATH, using = "//p[text()='\u041d\u0435\u043a\u043e\u0440\u0440\u0435\u043a\u0442\u043d\u044b\u0439 \u043f\u0430\u0440\u043e\u043b\u044c']")
    private SelenideElement errorPasswordMessage;

    @Step("Заполнение поля для имени")
    public RegistrationPage setName(String name) {
        nameField.setValue(name);
        return this;
    }

    @Step("Заполнение поля для почты")
    public RegistrationPage setEmail(String email) {
        emailField.setValue(email);
        return this;
    }

    @Step("Заполнение поля для пароля")
    public RegistrationPage setPassword(String password) {
        passwordField.setValue(password);
        return this;
    }

    @Step("Клик по кнопке «Зарегистрироваться»")
    public LoginPage clickRegistrationButton() {
        confirmRegistrationButton.click();
        return page(LoginPage.class);
    }

    @Step("Клик по кнопке «Войти»")
    public LoginPage clickConfirmRegistrationButton() {
        registrationPageAuthButton.click();
        return page(LoginPage.class);
    }
}
