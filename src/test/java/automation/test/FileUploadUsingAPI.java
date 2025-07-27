package automation.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadUsingAPI {

    @Test
    public void uploadFile(){
        RestAssured.useRelaxedHTTPSValidation();

        File zipfile = new File("FileUpload/DatabaseTestingAutomation.zip");
      Response response =  RestAssured
                .given()
                    .multiPart("file", zipfile, "application/zip")   // form field 'file' or as per API spec
                    .contentType("multipart/form-data")
                .when()
                    .post("https://api.example.com/api/v1/upload")
                .then()
                    .log().all()
                    .statusCode(200)
                    .extract().response();

        System.out.println("Upload Responses: "+ response.asString());

    }
}


/*
* When uploading ZIP files—or any file, really—multipart/form-data is essential because it’s designed to transmit binary data safely and efficiently over HTTP.
*
*
* */