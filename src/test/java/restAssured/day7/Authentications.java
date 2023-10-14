package restAssured.day7;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Authentications {

    @Test(priority = 1)
    void testBasicAuthentication(){

        given().auth().basic("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();
    }

    @Test(priority = 2)
    void testDigestAuthentication(){

        given().auth().digest("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();
    }

    @Test(priority = 3)
    void testPreemptiveAuthentication(){

        given().auth().preemptive().basic("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();
    }

    @Test(priority = 4)
    void testBearerTokenAuthentication(){

        String bearerToken = "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";
//        given().auth().oauth2(bearerToken) //another way
        given().header("Authorization","Bearer "+bearerToken)
                .when()
                .get("https://api.github.com/user/repos")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 5)
    void testOAuth1Authentication(){

        given().auth().oauth("consumerKey","consumerSecret","accessToken","tokenSecret")
                .when()
                .get("url")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 6)
    void testOAuth2Authentication(){
        String bearerToken = "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";
        given().auth().oauth2(bearerToken)
                .when()
                .get("https://api.github.com/user/repos")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 7)
    void testAPIKeyAuthentication(){

       given().queryParam("appid","APIKey")
                .when()
                .get("url")
                .then()
                .statusCode(200)
                .log().all();

    }
}
