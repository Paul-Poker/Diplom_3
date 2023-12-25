package site.nomoreparties.stellarburgers.user;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestClient {

    private static final String BASE_URI = "https://stellarburgers.nomoreparties.site";
    private static final String USER_LOGIN = "/api/auth/login";

    protected static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .build();
    }

    @Step("Авторизация пользователя")
    public ValidatableResponse loginUser(UserCredentials credentials) {
        return given()
                .spec(requestSpecification())
                .body(credentials)
                .when()
                .post(USER_LOGIN)
                .then();
    }
}
