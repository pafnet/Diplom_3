import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.MainPage;
import pageobject.RecoveryPasswordPage;
import pageobject.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Вход с кнопки «Войти в аккаунт»")
    public void loginFromMainPageTest() {
        open(MainPage.MAIN_PAGE_URL, MainPage.class)
                .clickLoginButton()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .submitLoginForm()
                .isCreateOrderButtonAppear();
    }

    @Test
    @DisplayName("Вход с кнопки «Личный кабинет»")
    public void loginFromProfileButtonTest() {
        open(MainPage.MAIN_PAGE_URL, MainPage.class)
                .clickProfileButtonBeforeAuthorization()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .submitLoginForm()
                .isCreateOrderButtonAppear();
    }

    @Test
    @DisplayName("Вход с кнопки в форме регистрации")
    public void loginFromRegistrationFormTest() {
        open(RegistrationPage.URL_REGISTER, RegistrationPage.class)
                .clickConfirmRegistrationButton()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .submitLoginForm()
                .isCreateOrderButtonAppear();
    }

    @Test
    @DisplayName("Вход с кнопки в форме восстановления пароля")
    public void loginFromRecoveryPasswordFormTest() {
        open(RecoveryPasswordPage.URL_FORGOT_PASSWORD, RecoveryPasswordPage.class)
                .clickRecoveryPasswordButton()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .submitLoginForm()
                .isCreateOrderButtonAppear();
    }

}