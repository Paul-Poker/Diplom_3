package site.nomoreparties.stellarburgers.user;


import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserClient extends RestClient {

    private static final String USER_CREATE = "/api/auth/register";
    private static final String USER_UPDATE_DELETE = "/api/auth/user";

    @Step("Удаление пользователя")
    public static void deleteUser(String accessToken) {
        given()
                .spec(requestSpecification())
                .header("authorization", accessToken)
                .auth().oauth2(accessToken)
                .when()
                .delete(USER_UPDATE_DELETE)
                .then();
    }

    @Step("Создание пользователя")
    public ValidatableResponse createUser(UserData user) {
        return given()
                .spec(requestSpecification())
                .body(user)
                .when()
                .post(USER_CREATE)
                .then();
    }
}
