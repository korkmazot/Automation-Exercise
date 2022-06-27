package exercises.tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class API_PostRequest {

    @Test
    public void post01(){

        /*
         https://jsonplaceholder.typicode.com/posts/44 url'ine bir POST Request
    yolladigimizda donen Response'un

{
    "title": "API",
     "body": "API ogrenmek ne guzel",
     "userId": 10
}
    status code = 200
    Content Type = application/json
         */

        //     1- Request URL ve Body olustur
        String url = "https://jsonplaceholder.typicode.com/posts";
        JSONObject reqBody = new JSONObject();

        reqBody.put("title","API");
        reqBody.put("body","API ogrenmek ne guzel");
        reqBody.put("userId",10);

//     2- Expected Data olustur.
        JSONObject expBody = new JSONObject();

        expBody.put("title","API");
        expBody.put("body","API ogrenmek ne guzel");
        expBody.put("userId",10);

//     3- Response kaydet
        Response response = given().
                contentType(ContentType.JSON).
                when().
                body(reqBody.toString()).
                post(url);

        JsonPath actBody = response.jsonPath();

//     4- Assertion
        response.
                then().
                assertThat().
                contentType(ContentType.JSON).
                statusCode(201);

        Assert.assertEquals(expBody.get("title"),actBody.get("title"));
        Assert.assertEquals(expBody.get("body"),actBody.get("body"));
        Assert.assertEquals(expBody.get("userId"),actBody.get("userId"));


    }
}
