package automation.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Test
public class testParseNumbersValidUrl {


    String intputUrl = "http://mockserver.com/sample-numbers.html";

    String invalidUrl = "http://mockserver.com/sample-numbers-invalid.html";

    String noUrl = "http://mockserver.com/sample-numbers-no.html";

    String emptyUrl = "http://mockserver.com/sample-numbers-empty.html";


    String specialCharUrl = "http://mockserver.com/sample-numbers-specialchar.html";


    Response response = RestAssured
            .given()
            .queryParam("url", intputUrl)
            .when()
            .get("http://localhost:8080/parse-numbers")
            .then()
            .statusCode(200)
            .extract().response();


    String filePath = response.jsonPath().getString("filePath");

    BufferedReader br = new BufferedReader(new FileReader(filePath));
    String fileContent = br.lines().collect(Collectors.joining(","));
    //br.close();

    List<String> expectedNumbers = Arrays.asList("123", "456", "789", "101112");
    List<String> actualNumbers = Arrays.stream(fileContent.split(","))
            .map(String::trim)
            .filter(s -> s.matches("\\d+")) // Filter only numeric strings
            .collect(Collectors.toList());

    public testParseNumbersValidUrl() throws FileNotFoundException {
    }
    //Assert.assertEquals(actualNumbers, expectedNumbers, "The extracted numbers do not match the expected values.");

}
