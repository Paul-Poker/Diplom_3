package site.nomoreparties.stellarburgers.user;


import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserClient extends RestClient {

    private static final String USER_CREATE = "/api/auth/register";


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
