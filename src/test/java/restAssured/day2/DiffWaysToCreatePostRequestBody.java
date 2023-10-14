package restAssured.day2;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 There are 4 ways to create request body
 1 - Hashmap
 2 - using org.json
 3 - using POJO (Plain Old Java Object)
 4 - using external json file
 **/
public class DiffWaysToCreatePostRequestBody {
//    @Test(priority = 1)
    public void test01_PostUsingHashMap(){
        HashMap data = new HashMap();
        data.put("name","Hunter");
        data.put("location","Da Nang");
        data.put("phone","0983918891");

        String[] coureArray = {"C#", "Java"};
        data.put("courses", coureArray);

        given().contentType("application/json").body(data)
                .when().post("http://localhost:3000/students")
                .then().statusCode(201)
                .body("name",equalTo("Hunter"))
                .body("location",equalTo("Da Nang"))
                .body("phone",equalTo("0983918891"))
                .body("courses[0]",equalTo("C#"))
                .body("courses[1]",equalTo("Java"))
                .header("Content-Type","application/json; charset=utf-8")
                .log().all();
    }



//    @Test(priority = 1)
    public void test02_PostUsingOrgJson(){

        JSONObject data = new JSONObject();
        data.put("name","Hunter");
        data.put("location","Da Nang");
        data.put("phone","0983918891");

        String[] coureArray = {"C#", "Java"};
        data.put("courses", coureArray);

        given().contentType("application/json").body(data.toString())
                .when().post("http://localhost:3000/students")
                .then().statusCode(201)
                .body("name",equalTo("Hunter"))
                .body("location",equalTo("Da Nang"))
                .body("phone",equalTo("0983918891"))
                .body("courses[0]",equalTo("C#"))
                .body("courses[1]",equalTo("Java"))
                .header("Content-Type","application/json; charset=utf-8")
                .log().all();
    }

//    @Test(priority = 1)
    public void test03_PostUsingPOJO(){

        Pojo_PostRequest data = new Pojo_PostRequest();
        data.setName("Hunter");
        data.setLocation("Da Nang");
        data.setPhone("0983918891");
        String[] coureArray = {"C#", "Java"};
        data.setCourses(coureArray);

        given().contentType("application/json").body(data)
                .when().post("http://localhost:3000/students")
                .then().statusCode(201)
                .body("name",equalTo("Hunter"))
                .body("location",equalTo("Da Nang"))
                .body("phone",equalTo("0983918891"))
                .body("courses[0]",equalTo("C#"))
                .body("courses[1]",equalTo("Java"))
                .header("Content-Type","application/json; charset=utf-8")
                .log().all();
    }

    @Test(priority = 1)
    public void test04_PostUsingExtenalJsonFile() throws FileNotFoundException {
        File file = new File(".\\BODY.json");
        FileReader fr = new FileReader(file);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject data = new JSONObject(jt);
        given().contentType("application/json").body(data.toString())
                .when().post("http://localhost:3000/students")
                .then().statusCode(201)
                .body("name",equalTo("Hunter"))
                .body("location",equalTo("Da Nang"))
                .body("phone",equalTo("0983918891"))
                .body("courses[0]",equalTo("C#"))
                .body("courses[1]",equalTo("Java"))
                .header("Content-Type","application/json; charset=utf-8")
                .log().all();
    }


    @Test(priority = 2)
    public void testDelete(){

        given()
                .when().delete("http://localhost:3000/students/4")
                .then().statusCode(200);
    }

}
