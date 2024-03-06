package com.techInc.APITestingFramework.APIs;

import com.techInc.APITestingFramework.setUp.BaseTest;
import io.restassured.response.Response;

import java.util.Hashtable;

import static io.restassured.RestAssured.given;

public class DeleteCustomerAPI extends BaseTest {

    public static Response sendDeleteRequestToDeleteCustomerAPIWithValidID(Hashtable<String,String> data){

        Response response = given().auth().basic(config.getProperty("validSecretKey"), "")
                .delete(config.getProperty("customerAPIEndPoint")+"/"+data.get("id"));

        return response;
    }
}
