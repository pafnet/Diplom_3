package pageobject;

import userapi.User;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    public final static String URL_LOGIN = "https://stellarburgers.nomoreparties.site/login";

    @FindBy(how = How.XPATH, using = "//h2[text()='\u0412\u0445\u043e\u0434']")
    private SelenideElement enterButton;

    @FindBy(how = How.XPATH, using = "//button[text()='\u0412\u043e\u0439\u0442\u0438']")
    private SelenideElement authorizationButton;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'\u0417\u0430\u0440\u0435\u0433\u0438\u0441\u0442\u0440\u0438\u0440\u043e\u0432\u0430\u0442\u044c\u0441\u044f')]")
    private SelenideElement registrationButton;

    @FindBy(how = How.XPATH, using = "//label[text()='Email']//following-sibling::input")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = "//label[text()='\u041f\u0430\u0440\u043e\u043b\u044c']//following-sibling::input")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = "//p[text()='\u041d\u0435\u043a\u043e\u0440\u0440\u0435\u043a\u0442\u043d\u044b\u0439 \u043f\u0430\u0440\u043e\u043b\u044c']")
    private SelenideElement errorPasswordMessage;

    @FindBy(how = How.XPATH, using = "//div/p/a[text()='\u0412\u043e\u0439\u0442\u0438']")
    private SelenideElement enterLinkButton;

    @Step("Клик по кнопке «Зарегистрироваться»")
    public RegistrationPage clickRegistrationLinkButton() {
        registrationButton.click();
        return page(RegistrationPage.class);
    }

    @Step("Дождаться кнопки «Войти»")
    public LoginPage verifyLoginPageElementsVisible() {
        enterButton.shouldBe(Condition.visible);
        authorizationButton.shouldBe(Condition.enabled);
        return this;
    }

    @Step("Заполнить поле «Email»")
    public LoginPage setEmail(String email) {
        emailField.click();
        emailField.val(email);
        return this;
    }

    @Step("Заполнить поле «Пароль»")
    public LoginPage setPassword(String password) {
        passwordField.click();
        passwordField.val(password);
        return this;
    }

    @Step("Клик по кнопке «Войти»")
    public MainPage submitLoginForm() {
        authorizationButton.shouldBe(Condition.enabled).click();
        return page(MainPage.class);
    }

    @Step("Заполнить поля с данными пользователя")
    public MainPage loginWithUserCredentials(User user) {
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        return submitLoginForm();
    }

    @Step("Заполнить поля с данными пользователя")
    public MainPage enterUserCredentials(String email, String password) {
        Selenide.sleep(300);
        setEmail(email);
        setPassword(password);
        return submitLoginForm();
    }

    @Step("Убедится что кнопка «Войти» отображается")
    public boolean isEnterButtonDisplayed() {
        enterButton.shouldBe(Condition.visible);
        return enterButton.exists();
    }

    @Step("Проверить сообщение об ошибке")
    public boolean isErrorMessageDisplayed() {
        return errorPasswordMessage.exists();
    }

    @Step("Проверить отображение текста с ошибкой ")
    public LoginPage errorPasswordMessageGetText() {
        String actualErrorMessage = errorPasswordMessage.getText();
        Assert.assertEquals("Некорректный пароль", actualErrorMessage);
        return this;
    }

    public LoginPage clickEnterPageLinkButton() {
        enterLinkButton.click();
        return page(LoginPage.class);
    }
}
