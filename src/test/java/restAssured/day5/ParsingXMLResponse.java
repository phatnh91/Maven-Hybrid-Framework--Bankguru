package restAssured.day5;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ParsingXMLResponse {

//    @Test
    void testXMLResponse1(){

        //Approach 1
        given()
                .when().get("http://restapi.adequateshop.com/api/Traveler?page=1")
                .then().statusCode(200)
                .header("Content-Type","application/xml; charset=utf-8")
                .body("TravelerinformationResponse.page",equalTo("1"))
                .body("TravelerinformationResponse.travelers.Travelerinformation.id[0]",equalTo("11133"))
                .log().all();
    }

//    @Test
    void testXMLResponse2(){

        //Approach 2
        Response response = given()
                .when().get("http://restapi.adequateshop.com/api/Traveler?page=1");

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.header("Content-Type"),"application/xml; charset=utf-8");
        Assert.assertEquals(response.xmlPath().get("TravelerinformationResponse.page"),"1");
        Assert.assertEquals(response.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation.id[0]"),"11133");
    }

    @Test
    void testXMLResponse3(){
        boolean status = false;
        //Approach 3
        Response response = given()
                .when().get("http://restapi.adequateshop.com/api/Traveler?page=1");

        XmlPath xmlObj = new XmlPath(response.asString());
        List<String> travelerInfo = xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
        int xmlObjSize = travelerInfo.size();
        Assert.assertEquals(xmlObjSize, 10);
        for (String traveler : travelerInfo) {
            System.out.println("Traveler infor ==>" + traveler);
            System.out.println("---------------------------------------");
            if(traveler.equals("Developer123")){
                status = true;
                break;
            }
        }
        Assert.assertTrue(status);
    }
}
