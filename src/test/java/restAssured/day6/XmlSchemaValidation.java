package restAssured.day6;

import io.restassured.matcher.RestAssuredMatchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class XmlSchemaValidation {

    @Test
    void xmlSchemaValidation(){


        when()
                .get("http://restapi.adequateshop.com/api/Traveler?page=1")
                .then()
                .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("xmlSchema.xsd"));
    }
}
