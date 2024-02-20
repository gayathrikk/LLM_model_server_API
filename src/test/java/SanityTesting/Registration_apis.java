package SanityTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Registration_apis {
	
	 @Test(priority=1)
	 public void atlasregistration()
	 {
		 Response response1 = RestAssured
	    		    .given()
	    		    .auth()
	    		    .basic("admin", "admin")
	    		    .when()
	    		    .get("https://apollo2.humanbrain.in/BR/AppAtlasRegisteration/11534/");
	      int statusCode1 = response1.getStatusCode();
	      if (statusCode1 == 200) {
	          System.out.println("API request to the appatlas registration of Registration passed. Status code: " + statusCode1);
	      } else {
	          System.out.println("API request to the appatlas registration of Registration  failed. Status code: " + statusCode1);
	      }
	      Assert.assertEquals(statusCode1, 200, "API request to the appatlas registration of Registration failed");
	 }
	 
	 @Test(priority=2)
	 public void getthumbnails()
	 {
		 Response response2 = RestAssured.get("https://apollo2.humanbrain.in/GW/getBrainThumbNailDetails/IIT/V1/SS-15:10:1006");
         int statusCode2 = response2.getStatusCode();
         if (statusCode2 == 200) {
             System.out.println("API request to the thumbnails details of series set page passed. Status code: " + statusCode2);
         } else {
             System.out.println("API request to the thumbnails details of series set failed. Status code: " + statusCode2);
         }
         Assert.assertEquals(statusCode2, 200, "API request to the thumbnails details of series set failed");
	 }
	 
	 @Test(priority=3)
	 public void getccuser()
	 {

		 String jsonBody1 = "{\"user_hash\":\"108775719029651384883\"}";
    	 Response response1 = RestAssured
             .given()
                 .auth()
                 .preemptive()
                 .basic("admin", "admin")
                 .contentType(ContentType.JSON)
                 .body(jsonBody1)
             .when()
                 .post("https://apollo2.humanbrain.in/CC/getCCUserId");
    	 int statusCode1 = response1.getStatusCode();
    	 if (statusCode1 == 200) {
             System.out.println("API request to Brainaccess get ccuser id passed. Status code: " + statusCode1);
         } else {
             System.out.println("API request to Brainaccess get ccuser id failed. Status code: " + statusCode1);
         }
         Assert.assertEquals(statusCode1, 200, "API request to get ccuser id failed");  
	 }
	 
	 @Test(priority=4)
	 public void Brainviewer()
	 {
	        
	        //Atlas brain viewer details
	        Response response2 = RestAssured.get("https://apollo2.humanbrain.in/GW/getBrainViewerDetails/IIT/V1/SS-15:10:1006");
	        int statusCode2 = response2.getStatusCode();
	        if (statusCode2 == 200) {
	            System.out.println("API request to the brain viewer details of Registration page passed. Status code: " + statusCode2);
	        } else {
	            System.out.println("API request to the brain viewer details of registartion page failed. Status code: " + statusCode2);
	        }
	        Assert.assertEquals(statusCode2, 200, "API request to the brain viewer details of Registration page failed");
	 }
}
