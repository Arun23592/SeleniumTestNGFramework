package automation.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadUsingAPI {

    @Test
    public void uploadFile(){
        File zipfile = new File("FileUpload/DatabaseTestingAutomation.zip");
      Response response =  RestAssured
                .given()
                    .multiPart("file", zipfile, "application/zip")   // form field 'file' or as per API spec
                    .contentType("multipart/form-data")
                .when()
                    .post("https://api.example.com/upload")
                .then()
                    .log().all()
                    .assertThat()
                    .statusCode(200)
                    .extract().response();

        System.out.println("Upload Responses: "+ response.toString());

    }
}
