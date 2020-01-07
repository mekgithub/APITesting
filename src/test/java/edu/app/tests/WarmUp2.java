package edu.app.tests;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class WarmUp2 {
    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "https://api.got.show";
    }
    @Test
    public void getAllBattles(){
        given().when().get("/api/show/battles").prettyPrint();
    }
    @Test
    public void getBattlesByName(){
        given().pathParam("name","Battle of Ashford").when().get("/api/show/battles/{name}").prettyPrint();
    }

}
