package edu.app.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WarmUp {
    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "https://api.got.show/api/";

    }
    @Test
    public void warmUpTest(){
        Response response = RestAssured.get("show/animals/");
        response.prettyPrint();

        String responseAsString = response.asString();
        Assert.assertTrue(responseAsString.contains("habitat"));

        int actualCode = response.getStatusCode();
        Assert.assertEquals(200, actualCode );

    }
}
