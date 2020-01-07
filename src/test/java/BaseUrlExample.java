import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BaseUrlExample {
    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "https://reqres.in/api/";
        //setting up the base uri for each request that will be sent in each test
    }
    @Test
    public void singleUserTest(){
        Response response = RestAssured.get("users/2");
        response.prettyPrint();
        Assert.assertTrue(response.asString().contains("Janet"));
        }
     @Test
    public void getListOfUsers(){
         Response response = RestAssured.get("page=2");
         response.prettyPrint();
         int actualStatusCode = response.statusCode();
         Assert.assertEquals(200, actualStatusCode);
         Assert.assertTrue(response.asString().contains("id"));
     }
     @Test
    public void getSingleUserNotFound (){
        Response response = RestAssured.get("/api/users/23");
        response.prettyPrint();
        int actualStatusCode = response.statusCode();
        Assert.assertEquals(404, actualStatusCode);
     }

    }


