package restAssured.day6;

import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class JsonSchemaValidation {

    @Test
    void jsonSchemaValidation(){


        when()
                .get("http://localhost:3000/store")
                .then()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeJsonSchema.json"));
    }
}
