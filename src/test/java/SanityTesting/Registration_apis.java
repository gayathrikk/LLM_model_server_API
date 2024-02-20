package SanityTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Registration_apis {
	
	 @Test(priority=2)
	 public void Brainviewer()
	 {
	        
	        //Atlas brain viewer details
	        Response response2 = RestAssured.get("https://apollo2.humanbrain.in/GW/getBrainViewerDetails/IIT/V1/SS-15:10:1006");
	        int statusCode2 = response2.getStatusCode();
	        if (statusCode2 == 200) {
	            System.out.println("API request to the brain viewer details of  page passed. Status code: " + statusCode2);
	        } else {
	            System.out.println("API request to the brain viewer details of Atlas page failed. Status code: " + statusCode2);
	        }
	        Assert.assertEquals(statusCode2, 200, "API request to the brain viewer details of Atlas page failed");
	        
	 }

}
