package com.techInc.APITestingFramework.testcases;

import com.techInc.APITestingFramework.APIs.CreateCustomerAPI;
import com.techInc.APITestingFramework.listeners.ExtentListeners;
import com.techInc.APITestingFramework.setUp.BaseTest;
import com.techInc.APITestingFramework.utilities.DataUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.Hashtable;

import static io.restassured.RestAssured.*;

public class CreateCustomerTest extends BaseTest {

    @Test(dataProviderClass = DataUtil.class, dataProvider = "data")
    public void validateCreateCustomerAPIWithValidSecretKey (Hashtable<String,String> data){

        Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithValidAuthKey(data);

        ExtentListeners.testReport.get().info(data.toString());

        response.prettyPrint();

        System.out.println(response.statusCode());

        Assert.assertEquals(response.statusCode(), 200);

    }

//    @Ignore
    @Test(dataProviderClass = DataUtil.class, dataProvider = "data")
    public void validateCreateCustomerAPIWithInValidSecretKey (Hashtable<String,String> data){

        Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithInValidAuthKey(data);

        ExtentListeners.testReport.get().info(data.toString());

        response.prettyPrint();

        System.out.println(response.statusCode());

        Assert.assertEquals(response.statusCode(), 200);

    }


}
