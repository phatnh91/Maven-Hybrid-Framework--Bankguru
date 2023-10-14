package restAssured.day5;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FileUploadAndDownload {

    @Test
    void singleFileUpload(){
        File file = new File("");
        given()
                .multiPart("file",file)
                .contentType("multipart/form-data")

                .when().post("http://localhost:8080/uploadFile")
                .then()
                .statusCode(200)
                .body("fileName",equalTo(""));
    }

    @Test
    void multipleFileUpload(){
        File file1 = new File("");
        File file2 = new File("");

        File[] fileArray = {file1, file1}; //Depend on API that developer created
        given()
                .multiPart("files",file1)
                .multiPart("files",file2)
                .multiPart("files",fileArray)
                .contentType("multipart/form-data")

                .when().post("http://localhost:8080/uploadFiles")
                .then()
                .statusCode(200)
                .body("[0].fileName",equalTo(""))
                .body("[1].fileName",equalTo(""));
    }

    @Test
    void FileDownload(){

        given()

                .when().get("http://localhost:8080/uploadFile/test1.txt")
                .then()
                .statusCode(200)
                .log().body();
    }
}
