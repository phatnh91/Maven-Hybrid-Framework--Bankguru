package restAssured.day1;

import org.testng.annotations.Test;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
given() : content type, set cookies, add auth, add param, set headers info etc....
when(): get, post, put, delete
then(): validate status code, extract response, extract headers cookies & response body...
**/

public class HTTPRequests {
    String url = "https://reqres.in/";
    String getRequest = "api/users?page=2";
    String createRequest = "api/users";
    String updateRequest = "api/users/";
    int userID;
    @Test(priority = 1)
    public void getUsers(){
        given()
                .when().get(url+getRequest)
                .then().statusCode(200).body("page",equalTo(2))
                .log().all();
    }

    @Test(priority = 2, groups = "createUser")
    public void createUser(){
        HashMap<String, String> data = new HashMap<>();
        data.put("name", "morpheus");
        data.put("job", "leader");
        userID = given().contentType("application/json").body(data)
                .when().post(url+createRequest).jsonPath().getInt("id");
//                .then().statusCode(201)
//                .log().all();
    }

    @Test(priority = 3, dependsOnGroups = {"createUser"})
    public void updateUser(){
        HashMap<String, String> data = new HashMap<>();
        data.put("name", "morpheus");
        data.put("job", "trainer");
        given().contentType("application/json").body(data)
                .when().put(url+updateRequest+userID)
                .then().statusCode(200).body("job",equalTo("trainer"))
                .log().all();
    }

    @Test(priority = 4)
    public void deleteUser(){
        given()
                .when().delete(url+updateRequest+userID)
                .then().statusCode(204)
                .log().all();
    }

}
