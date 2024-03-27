package SanityTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Apollo3_iipsrv_api {
	
	@Test(priority=1)
	 public void iipsrv()
	 
	    {
	    	Response response1 = RestAssured
	    		    .given()
	    		    .auth()
	    		    .basic("admin", "admin")
	    		    .when()
	    		    .get("https://ap3.humanbrain.in//iipsrv/fcgi-bin/iipsrv.fcgi?FIF=/apollo3/storageIIT/humanbrain/analytics/299/NISL/B_299_HB19\\[M1-A\\]-SL_197-ST_NISL-SE_589_compressed.jp2&WID=1024&GAM=1.4&MINMAX=1:0,255&MINMAX=2:0,255&MINMAX=3:0,255&JTL=7,5327");

	        int statusCode1 = response1.getStatusCode();
	        if (statusCode1 == 200) {
	            System.out.println("API request to the apollo3 iipsrv passed. Status code: " + statusCode1);
	            byte[] responseBody = response1.getBody().asByteArray(); // Store response body as byte array
	            System.out.println("Response body length: " + responseBody.length); // Display length of the response body
	            
	        } else {
	            System.out.println("API request to the apollo3 iipsrv failed. Status code: " + statusCode1);
	        }
	        Assert.assertEquals(statusCode1, 200, "API request to the apollo3 iipsrv failed");
	        
	    }	

}
