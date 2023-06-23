package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class UserAccountPage {
    public final static String URL_PROFILE = "https://stellarburgers.nomoreparties.site/account/profile";

    @FindBy(how = How.XPATH, using = "//a[text()='\u041f\u0440\u043e\u0444\u0438\u043b\u044c']")
    private SelenideElement profileButton;

    @FindBy(how = How.XPATH, using = "//p[text()='\u041a\u043e\u043d\u0441\u0442\u0440\u0443\u043a\u0442\u043e\u0440']")
    private SelenideElement constructorButton;

    @FindBy(how = How.XPATH, using = "//div[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logoStellarButton;

    @FindBy(how = How.XPATH, using = "//button[text()='\u0412\u044b\u0445\u043e\u0434']")
    private SelenideElement logoutButton;

    @Step("Клик по кнопке «Войти»")
    public LoginPage clickExitButton() {
        logoutButton.click();
        return page(LoginPage.class);
    }

    @Step("Проверка заголовка «Профиль»")
    public boolean isProfileHeaderExist() {
        profileButton.shouldBe(Condition.visible);
        return profileButton.exists();
    }

    @Step("Клик по кнопке «Конструктор»")
    public MainPage clickConstructorButton() {
        constructorButton.click();
        return page(MainPage.class);
    }

    @Step("Клик по логотипу «stellar burgers»")
    public MainPage clickLogoButton() {
        logoStellarButton.click();
        return page(MainPage.class);
    }
}
