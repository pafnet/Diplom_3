import userapi.UserFaker;
import userapi.UserApiService;
import userapi.UserAuthentication;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Test;
import pageobject.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.*;


public class UserRegistrationTest {
    UserApiService userApiService;

    protected String name = UserFaker.getRandomUser().getName();
    protected String email = UserFaker.getRandomUser().getEmail();
    protected String password = UserFaker.getRandomUser().getPassword();
    protected String incorrectPassword = "short";

    @Test
    @DisplayName("Регистрация пользователя успешна")
    public void successfulUserRegistrationTest() {
        open(MainPage.MAIN_PAGE_URL, MainPage.class)
                .clickLoginButton()
                .clickRegistrationLinkButton()
                .setName(name)
                .setEmail(email)
                .setPassword(password)
                .clickConfirmRegistrationButton()
                .enterUserCredentials(email, password);

        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();

        assertEquals("https://stellarburgers.nomoreparties.site/login", currentUrl);
    }

    @Test
    @DisplayName("Регистрация пользователя безуспешна с коротким паролем")
    public void unsuccessfulUserRegistrationTest() {
        boolean isErrorMessageDisplayed = open(MainPage.MAIN_PAGE_URL, MainPage.class)
                .clickLoginButton()
                .clickRegistrationLinkButton()
                .setName(name)
                .setEmail(email)
                .setPassword(incorrectPassword)
                .clickConfirmRegistrationButton()
                .errorPasswordMessageGetText()
                .clickEnterPageLinkButton()
                .enterUserCredentials(email, incorrectPassword)
                .isErrorMessageAppear();

        assertTrue(isErrorMessageDisplayed);
    }

    @After
    public void tearDown() {
        userApiService = new UserApiService();
        UserAuthentication userAuthentication = new UserAuthentication(email, password);
        Response response = userApiService.authenticateUser(userAuthentication);
        if (response.body().jsonPath().getString("accessToken") != null) {
            userApiService.deleteUser(response);
        }

        UserAuthentication userInvalidCredentials = new UserAuthentication(email, incorrectPassword);
        Response invalidResponse = userApiService.authenticateUser(userInvalidCredentials);
        if (invalidResponse.body().jsonPath().getString("accessToken") != null) {
            userApiService.deleteUser(invalidResponse);
        }
    }
}