package edu.app.tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

public class JsonPathExample {
    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";
    }
    @Test
    public void test1(){
        Response response = RestAssured.given().pathParam("orderId", "2" ).
                get("store/order/{orderId}");
        response.then().log().all().assertThat().statusCode(200);
        JsonPath jsonPath = response.jsonPath();
        int id = jsonPath.get("id");
        System.out.println("Printing pet id: "+id);
        String shipDate = jsonPath.get("shipDate");
        System.out.println("Ship Date:" + shipDate);
    }

}
