import userapi.UserFaker;
import userapi.User;
import userapi.UserApiService;
import userapi.UserAuthentication;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;

abstract public class BaseTest {

    protected static final User user = UserFaker.getRandomUser();

    protected UserApiService userClient;

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";

        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

    @Before
    public void init() {
        setUp();

        userClient = new UserApiService();
        userClient.registerUser(user);
    }

    @After
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();

        UserAuthentication userAuthentication = new UserAuthentication(user.getEmail(), user.getPassword());
        Response response = userClient.authenticateUser(userAuthentication);
        if (response.body().jsonPath().getString("accessToken") != null) {
            userClient.deleteUser(response);
        }
    }
}
