import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class UserProfileTest extends BaseTest {

    @Test
    @DisplayName("Переход по клику на «Личный кабинет»")
    public void userProfileButtonLinkTest() {
        open(LoginPage.URL_LOGIN, LoginPage.class)
                .loginWithUserCredentials(user)
                .clickProfileButtonAfterAuthorization()
                .isProfileHeaderExist();
    }
}
