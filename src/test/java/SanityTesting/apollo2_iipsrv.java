package SanityTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class apollo2_iipsrv {
	
	 @Test(priority=1)
	 public void iipsrv()
	 
	    {
	    	Response response1 = RestAssured
	    		    .given()
	    		    .auth()
	    		    .basic("admin", "admin")
	    		    .when()
	    		    .get("https://apollo2.humanbrain.in/iipsrv/fcgi-bin/iipsrv.fcgi?FIF=/data/storageIIT/humanbrain/analytics/52/NISL/B_52_MTB10-SL_71-ST_NISL-SE_427_compressed.jp2&WID=1024&GAM=1.4&MINMAX=1:0,255&MINMAX=2:0,255&MINMAX=3:0,255&JTL=4,64");

	        int statusCode1 = response1.getStatusCode();
	        if (statusCode1 == 200) {
	            System.out.println("API request to the apollo2 iipsrv passed. Status code: " + statusCode1);
	            byte[] responseBody = response1.getBody().asByteArray(); // Store response body as byte array
	            System.out.println("Response body length: " + responseBody.length); // Display length of the response body
	            
	        } else {
	            System.out.println("API request to the apollo2 iipsrv failed. Status code: " + statusCode1);
	        }
	        Assert.assertEquals(statusCode1, 200, "API request to the apollo2 iipsrv failed");
	        
	    }	
	

}
