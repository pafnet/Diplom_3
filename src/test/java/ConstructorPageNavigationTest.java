import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class ConstructorPageNavigationTest extends BaseTest {

    @Test
    @DisplayName("Открыть кнопкой раздел «Булки» в конструкторе")
    public void navigateToBunsSection() {
        MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
        mainPage.clickSaucesButton();
        mainPage.clickBunsButton();
        assertTrue("Раздел «Булки» не отобразился", mainPage.isBunsHeaderIsDisplayed());
    }

    @Test
    @DisplayName("Открыть кнопкой раздел «Соусы» в конструкторе")
    public void navigateToSaucesSection() {
        MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
        mainPage.clickSaucesButton();
        assertTrue("Раздел «Соусы» не отобразился", mainPage.isSaucesHeaderDisplayed());
    }

    @Test
    @DisplayName("Открыть кнопкой раздел «Начинки» в конструкторе")
    public void navigateToFillingsSection() {
        MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
        mainPage.clickFillingsButton();
        assertTrue("Раздел «Начинки» не отобразился", mainPage.isFillingsHeaderDisplayed());
    }

    @Test
    @DisplayName("Скролл до раздела «Булки» в конструкторе")
    public void scrollToBunsSection() {
        MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
        mainPage.scrollToBunsHeader();
        assertTrue("Раздел «Булки» не отобразился", mainPage.isBunsHeaderIsDisplayed());
    }

    @Test
    @DisplayName("Скролл до раздела «Соусы» в конструкторе")
    public void scrollToSaucesSection() {
        MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
        mainPage.scrollToSaucesHeader();
        assertTrue("Раздел «Соусы» не отобразился", mainPage.isSaucesHeaderDisplayed());
    }

    @Test
    @DisplayName("Скролл до раздела «Начинки» в конструкторе")
    public void scrollToFillingsSection() {
        MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
        mainPage.scrollToFillingsHeader();
        assertTrue("Раздел «Начинки» не отобразился", mainPage.isFillingsHeaderDisplayed());
    }
}