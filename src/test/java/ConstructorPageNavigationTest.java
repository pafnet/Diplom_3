import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class ConstructorPageNavigationTest extends BaseTest {

    @Test
    @DisplayName("Открыть кнопкой раздел «Булки» в конструкторе")
    public void navigateToBunsSection() {
        open(MainPage.MAIN_PAGE_URL, MainPage.class)
                .clickSaucesButton()
                .clickBunsButton()
                .isBunsHeaderIsDisplayed();
    }

    @Test
    @DisplayName("Открыть кнопкой раздел «Соусы» в конструкторе")
    public void navigateToSaucesSection() {
        open(MainPage.MAIN_PAGE_URL, MainPage.class)
                .clickSaucesButton()
                .isSaucesHeaderDisplayed();
    }

    @Test
    @DisplayName("Открыть кнопкой раздел «Начинки» в конструкторе")
    public void navigateToFillingsSection() {

        open(MainPage.MAIN_PAGE_URL, MainPage.class)
                .clickFillingsButton()
                .isSaucesHeaderDisplayed();
    }

    @Test
    @DisplayName("Скролл до раздела «Булки» в конструторе")
    public void scrollToBunsSection() {
        open(MainPage.MAIN_PAGE_URL, MainPage.class)
                .scrollToBunsHeader()
                .isBunsHeaderIsDisplayed();
    }

    @Test
    @DisplayName("Скролл до раздела «Соусы» в конструторе")
    public void scrollToSaucesSection() {
        open(MainPage.MAIN_PAGE_URL, MainPage.class)
                .scrollToSaucesHeader()
                .isSaucesHeaderDisplayed();
    }

    @Test
    @DisplayName("Скролл до раздела «Начинки» в конструкторе")
    public void scrollToFillingsSection() {
        open(MainPage.MAIN_PAGE_URL, MainPage.class)
                .scrollToFillingsHeader()
                .isFillingsHeaderDisplayed();
    }
}