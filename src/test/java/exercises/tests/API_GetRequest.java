package exercises.tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class API_GetRequest {

    /*
    https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET Request
    yolladigimizda donen Response'un

    status code : 200
    Content type : JSON
    Response Body'sinde bulunan UserID : 5
    Response Body'sinde bulunan title'nin : Optia dolar molestios sit
    */

    @Test
            public void get01(){
//     1- Request URL ve Body olustur
       String url = "https://jsonplaceholder.typicode.com/posts/44";

//     2- Expected Data olustur.
       JSONObject expBody = new JSONObject();
       expBody.put("userId",5);
       expBody.put("title","optio dolor molestias sit");

//     3- Response kaydet
       Response response = given().when().get(url);
       //response.prettyPrint();

//     4- Assertion
       response.
               then().
               assertThat().
               statusCode(200).
               contentType(ContentType.JSON);

        JsonPath actBody = response.jsonPath();
        Assert.assertEquals(expBody.get("userId"),actBody.get("userId"));
        Assert.assertEquals(expBody.get("title"),actBody.get("title"));

    }


}
