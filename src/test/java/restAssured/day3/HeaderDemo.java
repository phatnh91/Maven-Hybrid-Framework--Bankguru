package restAssured.day3;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class HeaderDemo {

//    @Test
    void testHeaders(){

        given()
                .when().get("https://www.google.com/")
        .then().header("Content-Type","text/html; charset=ISO-8859-1")
                .header("Content-Encoding","gzip");
    }

    @Test(priority = 2)
    void getHeadersInfo(){
        Response res = given()
                .when()
                .get("https://www.google.com/");

        //get single header info
        String header_value = res.getHeader("Content-Type");
        System.out.println("Value of header is: "+header_value);

        //get all headers info
//        Headers headers = res.getHeaders();
//        for(Header header:headers.asList()){
//            String headerValue = header.getValue();
//            System.out.println(header.getName()+" : "+headerValue);
        }
    }
