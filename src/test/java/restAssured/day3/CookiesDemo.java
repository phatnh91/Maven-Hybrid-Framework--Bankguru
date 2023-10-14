package restAssured.day3;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CookiesDemo {

//    @Test(priority = 1)
    void testCookies(){
        given()

                .when()
                .get("https://www.google.com/")
                .then()
                .cookie("AEC","Ackid1TJGzwyglg_RuGjRN3XSpRtrkH3iOqmaMXLHf404HsXmwWAfDqEguI")
                .log().all();
    }

    @Test(priority = 2)
    void getCookiesInfo(){
        Response res = given()
                .when()
                .get("https://www.google.com/");

        //get single cookie info
//        String cookie_value = res.getCookie("AEC");
//        System.out.println("Value of cookie is: "+cookie_value);

        //get all cookies info
        Map<String, String> cookie_values = res.getCookies();
        for(String key:cookie_values.keySet()){
            String cookieValue = res.getCookie(key);
            System.out.println(key+" : "+cookieValue);
        }
    }
}
