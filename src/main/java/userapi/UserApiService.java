package userapi;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static userapi.ApiRequestBuilder.getBaseSpecSettings;
import static io.restassured.RestAssured.given;

public class UserApiService {
    private static final String AUTH_LOGIN_ENDPOINT = "auth/login/";
    private static final String USER_PROFILE_ENDPOINT = "auth/user/";
    private static final String REGISTER_USER_ENDPOINT = "auth/register/";

    @Step("Создание пользователя")
    public Response registerUser(User user) {
        return given()
                .spec(getBaseSpecSettings())
                .body(user)
                .when()
                .post(REGISTER_USER_ENDPOINT)
                .then()
                .extract()
                .response();
    }

    @Step("Логин пользователя")
    public Response authenticateUser(UserAuthentication creds) {
        return given()
                .spec(getBaseSpecSettings())
                .body(creds)
                .when()
                .post(AUTH_LOGIN_ENDPOINT)
                .then()
                .extract()
                .response();
    }

    @Step("Удаление пользователя")
    public Response deleteUser(Response response) {
        String accessToken = response.body().jsonPath().getString("accessToken");
        if (accessToken == null) {
            return null;
        }
        return given()
                .spec(getBaseSpecSettings())
                .header("authorization", accessToken)
                .when()
                .delete(USER_PROFILE_ENDPOINT)
                .then()
                .extract()
                .response();
    }
}