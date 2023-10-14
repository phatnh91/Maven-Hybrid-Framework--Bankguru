package restAssured.day8;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUser {

    String userUrl = "https://gorest.co.in/public/v2/users/";
    String bearerToken = "Bearer c3e568a19756292a4e0fc318dd97987c75373b8678941349db08e5f411a695f2";
    @Test
    void test_getUser(ITestContext context){
//        int id = UserInfoModel.id;
//        int id = (int) context.getAttribute("user_id");
        int id = (int) context.getSuite().getAttribute("user_id");
        given()
                .headers("Authorization",bearerToken).pathParams("id",id)
                .when()
                .get("https://gorest.co.in/public/v2/users/{id}")
                .then()
                .statusCode(200)
                .log().all();
    }
}
