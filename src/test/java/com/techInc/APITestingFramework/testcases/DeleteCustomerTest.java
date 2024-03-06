package com.techInc.APITestingFramework.testcases;

import com.techInc.APITestingFramework.APIs.CreateCustomerAPI;
import com.techInc.APITestingFramework.APIs.DeleteCustomerAPI;
import com.techInc.APITestingFramework.listeners.ExtentListeners;
import com.techInc.APITestingFramework.setUp.BaseTest;
import com.techInc.APITestingFramework.utilities.DataUtil;
import com.techInc.APITestingFramework.utilities.TestUtil;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class DeleteCustomerTest extends BaseTest {

    @Test(dataProviderClass = DataUtil.class, dataProvider = "data")
    public void deleteCustomer (Hashtable<String,String> data){

        Response response = DeleteCustomerAPI.sendDeleteRequestToDeleteCustomerAPIWithValidID(data);
        ExtentListeners.testReport.get().info(data.toString());

        response.prettyPrint();

        System.out.println(response.statusCode());


/*        String actualId=response.jsonPath().get("id").toString();

        System.out.println("Getting id from Json path: "+actualId);

        Assert.assertEquals(actualId, data.get("id"), "ID not matching");*/


/*        JSONObject jsonObject = new JSONObject(response.asString());
        System.out.println(jsonObject.has("id"));
        Assert.assertTrue(jsonObject.has("id"), "ID key is not present in the JSON response");*/

        System.out.println("Presence of object key: "+TestUtil.jsonHasKey(response.asString(), "object"));
        System.out.println("Presence of deleted key: "+TestUtil.jsonHasKey(response.asString(), "deleted    "));
        Assert.assertTrue(TestUtil.jsonHasKey(response.asString(), "id"), "ID key is not present in the JSON response");

        String actualId = TestUtil.getJsonKeyValue(response.asString(), "id");
        System.out.println(actualId);
        Assert.assertEquals(actualId, data.get("id"), "ID not matching");

        System.out.println("Object key value is: "+TestUtil.getJsonKeyValue(response.asString(),"object"));
        System.out.println("Deleted key value is: "+TestUtil.getJsonKeyValue(response.asString(),"deleted"));


        Assert.assertEquals(response.statusCode(), 200);

    }


}
