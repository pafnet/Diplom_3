package pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class RecoveryPasswordPage {

    public final static String URL_FORGOT_PASSWORD = "https://stellarburgers.nomoreparties.site/forgot-password";

    @FindBy(xpath = "//a[text()='\u0412\u043e\u0439\u0442\u0438']")
    private SelenideElement passwordRecoveryLink;

    @Step("Клик по кнопке «Войти» на странице восстановления пароля")
    public LoginPage clickRecoveryPasswordButton() {
        passwordRecoveryLink.click();
        return page(LoginPage.class);
    }
}