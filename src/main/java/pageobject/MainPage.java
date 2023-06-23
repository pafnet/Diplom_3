package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;


public class MainPage {
    public static String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    @FindBy(how = How.XPATH, using = "//button[text()='\u0412\u043e\u0439\u0442\u0438 \u0432 \u0430\u043a\u043a\u0430\u0443\u043d\u0442']")
    private SelenideElement loginButton;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'\u041e\u0444\u043e\u0440\u043c\u0438\u0442\u044c \u0437\u0430\u043a\u0430\u0437')]")
    private SelenideElement createOrderButton;

    @FindBy(how = How.XPATH, using = "//p[text()='\u041b\u0438\u0447\u043d\u044b\u0439 \u041a\u0430\u0431\u0438\u043d\u0435\u0442']")
    private SelenideElement personalProfileButton;

    @FindBy(how = How.XPATH, using = "//h1[text()='\u0421\u043e\u0431\u0435\u0440\u0438\u0442\u0435 \u0431\u0443\u0440\u0433\u0435\u0440']")
    private SelenideElement burgerConstructionHeader;

    @FindBy(how = How.XPATH, using = "//div[span[text()='\u0411\u0443\u043b\u043a\u0438']]")
    private SelenideElement buttonBuns;

    @FindBy(how = How.XPATH, using = "//div[span[text()='\u0421\u043e\u0443\u0441\u044b']]")
    private SelenideElement buttonSauce;

    @FindBy(how = How.XPATH, using = "//*[text()='\u041d\u0430\u0447\u0438\u043d\u043a\u0438']")
    private SelenideElement buttonFillings;

    @FindBy(how = How.XPATH, using = "//h2[text()='\u041d\u0430\u0447\u0438\u043d\u043a\u0438']")
    private SelenideElement buttonFillingsHeader;

    @FindBy(how = How.XPATH, using = "//h2[text()='\u0421\u043e\u0443\u0441\u044b']")
    private SelenideElement buttonSauceHeader;

    @FindBy(how = How.XPATH, using = "//h2[text()='\u0411\u0443\u043b\u043a\u0438']")
    private SelenideElement buttonBunsHeader;

    @FindBy(how = How.CLASS_NAME, using = "tab_tab_type_current__2BEPc")
    private SelenideElement sectionIngredients;

    @FindBy(how = How.XPATH, using = "//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']")
    private SelenideElement constructorContainer;

    @FindBy(how = How.XPATH, using = "//p[text()='\u041d\u0435\u043a\u043e\u0440\u0440\u0435\u043a\u0442\u043d\u044b\u0439 \u043f\u0430\u0440\u043e\u043b\u044c']")
    private SelenideElement errorPasswordMessage;

    @Step("Клик по кнопке «Войти»")
    public LoginPage clickLoginButton() {
        loginButton.click();
        return page(LoginPage.class);
    }

    @Step("Проверка кнопки «Оформить заказ»")
    public boolean isCreateOrderButtonAppear() {
        createOrderButton.shouldBe(Condition.visible);
        return createOrderButton.exists();
    }

    @Step("Клик по кнопке «Личный Кабинет» до авторизации")
    public LoginPage clickProfileButtonBeforeAuthorization() {
        personalProfileButton.click();
        return page(LoginPage.class);
    }

    @Step("Клик по кнопке «Личный Кабинет» после авторизации")
    public UserAccountPage clickProfileButtonAfterAuthorization() {
        personalProfileButton.click();
        return page(UserAccountPage.class);
    }

    @Step("Проверка заголовка «Конструктор»")
    public boolean isBurgerConstructorHeaderExist() {
        return burgerConstructionHeader.exists();
    }

    @Step("Клик «Булки» в «Конструтор»")
    public MainPage clickBunsButton() {
        buttonBuns.click();
        return this;
    }

    @Step("Клик «Соусы в «Конструктор»")
    public MainPage clickSaucesButton() {
        buttonSauce.click();
        return this;
    }

    @Step("Клик «Начинки» в «Конструктор»")
    public MainPage clickFillingsButton() {
        buttonFillings.click();
        return this;
    }

    @Step("Заголовок «Булки» отобразился")
    public boolean isBunsHeaderIsDisplayed() {
        return sectionIngredients.getText().contentEquals("Булки");
    }

    @Step("Заголовок «Соусы» отобразился")
    public boolean isSaucesHeaderDisplayed() {
        return sectionIngredients.getText().contentEquals("Соусы");
    }

    @Step("Заголовок «Начинки» отобразился")
    public boolean isFillingsHeaderDisplayed() {
        return sectionIngredients.getText().contentEquals("Начинки");
    }

    @Step("Скролл в «Булки»")
    public MainPage scrollToBunsHeader() {
        constructorContainer.click();
        buttonBunsHeader.scrollIntoView(false);
        return this;
    }

    @Step("Скролл в «Соусы»")
    public MainPage scrollToSaucesHeader() {
        constructorContainer.click();
        buttonSauceHeader.scrollIntoView(false);
        return this;
    }

    @Step("Скролл в «Начинки»")
    public MainPage scrollToFillingsHeader() {
        constructorContainer.click();
        buttonFillingsHeader.scrollIntoView(false);
        return this;
    }

    @Step("Ожидание загрузки конструтора")
    public MainPage constructionShouldBeVisible() {
        constructorContainer.shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка сообщения об ошибке")
    public boolean isErrorMessageAppear() {
        return errorPasswordMessage.exists();
    }
}
