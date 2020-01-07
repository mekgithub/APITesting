package edu.app.tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class QueryParameter {
    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "https://uinames.com/api/";
    }
    @Test
    public void uiNamesByAmount(){
        given().
                queryParam("amount", "3").
                when().get().prettyPrint();

    }
    @Test
    public void uiNamesByRegion(){
        given().
                queryParam("region", "Turkey").
                when().get().prettyPrint();
    }
    @Test
    public void uiNamesByAmountRegion(){
        given().queryParam("amount", "5").
                queryParam("region","Hungary").
                when().get().prettyPrint();
    }
    @Test
    public void uiNamesByAmountGenderRegion(){
        given().
                queryParam("amount", "3").
                queryParam("gender", "female").
                queryParam("region", "United States").
                when().get().prettyPrint();
    }

}
