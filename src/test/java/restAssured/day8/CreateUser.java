package restAssured.day8;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUser {

    String userUrl = "https://gorest.co.in/public/v2/users";
    String bearerToken = "c3e568a19756292a4e0fc318dd97987c75373b8678941349db08e5f411a695f2";

    @Test
    void createUser(ITestContext context){
        UserInfoModel user = new UserInfoModel();
        Faker faker = new Faker();
        user.setName(faker.name().fullName());
        user.setGender("Male");
        user.setEmail(faker.internet().emailAddress());
        user.setStatus("inactive");

        UserInfoModel.id = given()
//                .auth().oauth2(bearerToken)
                .headers("Authorization","Bearer "+bearerToken)
                .contentType("application/json").body(user)
                .when().post(userUrl).jsonPath().getInt("id");
//        context.setAttribute("user_id",UserInfoModel.id);
        context.getSuite().setAttribute("user_id",UserInfoModel.id);
    }
}
