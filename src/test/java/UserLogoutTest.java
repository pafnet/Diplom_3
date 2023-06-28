import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class UserLogoutTest extends BaseTest {

    @Test
    @DisplayName("Выход из личного кабинета с кнопки «Выйти»")
    public void userLogoutFromProfile() {
        LoginPage loginPage = open(LoginPage.URL_LOGIN, LoginPage.class);
        loginPage.setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .submitLoginForm()
                .clickProfileButtonAfterAuthorization()
                .clickExitButton();

        loginPage.isEnterButtonDisplayed();
    }
}