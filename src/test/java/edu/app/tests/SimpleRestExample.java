package edu.app.tests;

import groovy.transform.ASTTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class SimpleRestExample {
@Test
    public void test1() {
    //RestAssured library will prepare and set the url
    Response response = RestAssured.get("https://uinames.com/api/");
    //to print the response
    response.prettyPrint();
    // as String --> we convert our object into string
    String responseAsString = response.asString();
    Assert.assertTrue(responseAsString.contains("name"));
    Assert.assertTrue(responseAsString.contains("surname"));

    int actualStatusCode = response.statusCode();
    Assert.assertEquals(200, actualStatusCode);
}
@Test
    public void headersTest(){
    Response response = RestAssured.get("https://uinames.com/api/");
    String contentType = response.contentType();
    System.out.println(contentType);
    Assert.assertEquals("application/json; charset=utf-8", contentType);
    }

@Test
    public void  statusLineTest(){
    Response response = RestAssured.get("https://uinames.com/api/");
    String statusLine = response.statusLine();
    System.out.println(statusLine);
    Assert.assertTrue(statusLine.contains("200"));
    Assert.assertTrue(statusLine.contains("OK"));
}

}


