package apitesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApiTesting {

    @Test
    public void apiTestingPractice() {
        RestAssured.baseURI = "https://automationexercise.com/api";

        Response response = given()
                .contentType(ContentType.URLENC)
                .formParam("search_product", "top")
                .log().all()
        .when()
                .post("/searchProduct");

        response.then()
                .log().all();

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.jsonPath().getList("products").size()).isNotZero();
    }

    @Test
    public void delayApi() {

        Response response = given()
                .baseUri("https://automationexercise.com/api")
                .log().all()
                .when()
                .get("/searchProduct");

        response.then()
                .log().all();

        assertThat(response.getStatusCode()).isEqualTo(200);
    }
}
