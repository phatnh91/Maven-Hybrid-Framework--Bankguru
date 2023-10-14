package restAssured.day8;

import com.github.javafaker.Faker;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateUser {
    String userUrl = "https://gorest.co.in/public/v2/users/";
    String bearerToken = "Bearer c3e568a19756292a4e0fc318dd97987c75373b8678941349db08e5f411a695f2";
    @Test
    void test_updateUser(ITestContext context){
        UserInfoModel user = new UserInfoModel();
        Faker faker = new Faker();
        user.setName(faker.name().fullName());
        user.setGender("Female");
        user.setEmail(faker.internet().emailAddress());
        user.setStatus("active");
//        int id = UserInfoModel.id;
//        int id = (int) context.getAttribute("user_id");
        int id = (int) context.getSuite().getAttribute("user_id");

        given()
                .headers("Authorization",bearerToken)
                .contentType("application/json")
                .pathParams("id",id)
                .body(user)
                .when().put("https://gorest.co.in/public/v2/users/{id}")
                .then()
                .statusCode(200)
                .log().all();

    }
}
