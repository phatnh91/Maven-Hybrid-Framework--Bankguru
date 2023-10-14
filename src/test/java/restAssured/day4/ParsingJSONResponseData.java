package restAssured.day4;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ParsingJSONResponseData {

//    @Test
    void testJSONResponse(){
        //Approach 1
        /*
        given().contentType("ContentType.JSON")

                .when()
                .given().get("http://localhost:3000/store")
                .then()
                .statusCode(200).
                header("Content-Type","application/json; charset=utf-8")
                .body("book[2].title",equalTo("Moby Dick"))
                .log().all();
                */

        //Approach 2

                Response response = given().contentType("ContentType.JSON")

                .when()
                .given().get("http://localhost:3000/store");

                Assert.assertEquals(response.getStatusCode(), 200);
                Assert.assertEquals(response.header("Content-Type"), "application/json; charset=utf-8");
                Assert.assertEquals(response.jsonPath().get("book[2].title").toString(), "Moby Dick");


    }

    @Test
    void testJSONResponseBodyData(){
        Response response = given().contentType("ContentType.JSON")

                .when()
                .given().get("http://localhost:3000/store");

        //JSONObject class

        JSONObject object = new JSONObject(response.asString()); //convert response to json object type
        boolean status = false;
        double totalPrice = 0;
        int objectSize = object.getJSONArray("book").length();
        for(int i=0;i<objectSize;i++){
            String title = object.getJSONArray("book").getJSONObject(i).getString("title");
            double price = object.getJSONArray("book").getJSONObject(i).getInt("price");
            totalPrice = totalPrice +price;
            System.out.println(title);
            if(title.equals("Moby Dick")){
                status =true;
                break;
            }
        }
        System.out.println("Total Price = " +totalPrice);
        Assert.assertTrue(status);
        Assert.assertEquals(totalPrice, 325.0);
        Assert.assertEquals(object.getJSONArray("book").getJSONObject(objectSize-1).getString("title"), "Moby Dick");

    }
}
