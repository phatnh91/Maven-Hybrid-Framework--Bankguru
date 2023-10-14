package restAssured.day3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PathAndQueryParameters {

    @Test
    void testQueryAndPathParameters(){
    String url = "https://reques.in/api";
        given()
                .pathParams("mypath","users") // path paraments
                .queryParam("page", 2)
                .queryParam("id", 5)
                .when().get("https://reqres.in/api/{mypath}")

                .then()
                .statusCode(200)
                .log().all();
    }
}
