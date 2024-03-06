package com.techInc.APITestingFramework.APIs;

import com.techInc.APITestingFramework.setUp.BaseTest;
import io.restassured.response.Response;

import java.util.Hashtable;

import static io.restassured.RestAssured.given;

public class CreateCustomerAPI  extends BaseTest {

    public static Response sendPostRequestToCreateCustomerAPIWithValidAuthKey(Hashtable<String,String> data){

        // sample comment
        Response response = given().auth().basic(config.getProperty("validSecretKey"), "")
                .formParam("name", data.get("name"))
                .formParam("email", data.get("email"))
                .formParam("description", data.get("description"))
                .post(config.getProperty("customerAPIEndPoint"));

        return response;
    }

    public static Response sendPostRequestToCreateCustomerAPIWithInValidAuthKey(Hashtable<String,String> data){

        Response response = given().auth().basic(config.getProperty("inValidSecretKey"), "")
                .formParam("name", data.get("name"))
                .formParam("email", data.get("email"))
                .formParam("description", data.get("description"))
                .post(config.getProperty("customerAPIEndPoint"));

        return response;
    }

}
