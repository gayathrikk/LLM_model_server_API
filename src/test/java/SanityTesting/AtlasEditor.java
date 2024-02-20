package SanityTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class AtlasEditor {

	 @Test(priority=1)
	 public void appatlas()
	 
	    {
	    	//app atlas registration
	    	Response response1 = RestAssured
	    		    .given()
	    		    .auth()
	    		    .basic("admin", "admin")
	    		    .when()
	    		    .get("https://apollo2.humanbrain.in/BR/AppAtlasRegisteration/7832/");

	        int statusCode1 = response1.getStatusCode();
	        if (statusCode1 == 200) {
	            System.out.println("API request to the appatlas registration of Atlas Editor passed. Status code: " + statusCode1);
	        } else {
	            System.out.println("API request to the appatlas registration of Atlas Editor failed. Status code: " + statusCode1);
	        }
	        Assert.assertEquals(statusCode1, 200, "API request to the appatlas registration of Atlas Editor failed");
	        
	    }
	 
	 @Test(priority=2)
	 public void Brainviewer()
	 {
	        
	        //Atlas brain viewer details
	        Response response2 = RestAssured.get("https://apollo2.humanbrain.in/GW/getBrainViewerDetails/IIT/V1/SS-15:10:1006");
	        int statusCode2 = response2.getStatusCode();
	        if (statusCode2 == 200) {
	            System.out.println("API request to the brain viewer details of Atlas page passed. Status code: " + statusCode2);
	        } else {
	            System.out.println("API request to the brain viewer details of Atlas page failed. Status code: " + statusCode2);
	        }
	        Assert.assertEquals(statusCode2, 200, "API request to the brain viewer details of Atlas page failed");
	        
	 }
	 
	 @Test(priority=3)
	 public void Contributor()
	 {
	        
	        //Get contributors details
	        Response response3 = RestAssured
	    		    .given()
	    		    .auth()
	    		    .basic("admin", "admin")
	    		    .when()
	    		    .get("https://apollo2.humanbrain.in/BR/AppAtlasRegisteration/?externalkey=FlatTree::IIT:V1:SS-15:10:1006:1006&annotationtype=6");

	        int statusCode3 = response3.getStatusCode();
	        if (statusCode3 == 200) {
	            System.out.println("API request to get contributors details of Atlas page passed. Status code: " + statusCode3);
	        } else {
	            System.out.println("API request to get contributors details of Atlas page failed. Status code: " + statusCode3);
	        }
	        Assert.assertEquals(statusCode3, 200, "API request to get contributors details of Atlas page failed");
	        
	 }
	 
	 @Test(priority=4)
	 public void appannotation()
	 {
	        
	       //Atlas app annotation type
	        Response response4 = RestAssured
	    		    .given()
	    		    .auth()
	    		    .basic("admin", "admin")
	    		    .when()
	    		    .get("https://apollo2.humanbrain.in/BR/AppAnnotationType/");
	        int statusCode4 = response4.getStatusCode();
	        if (statusCode4 == 200) {
	            System.out.println("API request to get app annotation type details of Atlas page passed. Status code: " + statusCode4);
	        } else {
	            System.out.println("API request to get app annotation type details of Atlas page failed. Status code: " + statusCode4);
	        }
	        Assert.assertEquals(statusCode4, 200, "API request to get app annotation type details of Atlas page failed");
	        
	   }
	 
	 @Test(priority=5)
	 public void save()
	  {
		  String jsonBody1 = "{\"atlasgeojson\":\"{\\\"type\\\":\\\"FeatureCollection\\\",\\\"features\\\":[{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[11279.499999999996,-10917.914976724238],[18923.202828517624,-10917.914976724238],[18923.202828517624,-18561.617805241865],[11279.499999999996,-18561.617805241865],[11279.499999999996,-10917.914976724238]]]},\\\"properties\\\":{\\\"data\\\":{\\\"text\\\":\\\"Cerebellum\\\",\\\"id\\\":\\\"500\\\",\\\"part_ID\\\":\\\"500\\\",\\\"name\\\":\\\"Cerebellum\\\",\\\"acronym\\\":\\\"CB\\\",\\\"type (gray matter/fiber tract/CNS cavity/developmental/other)\\\":\\\"G\\\",\\\"parent_structure_id\\\":\\\"1\\\",\\\"color_hex_triplet\\\":\\\"FFB3B3\\\"}},\\\"id\\\":\\\"298\\\"}],\\\"rotation\\\":0}\",\"accessdetails\":\"[{\\\"order\\\":0,\\\"key\\\":\\\"NISSL\\\",\\\"url\\\":\\\"https://apollo2.humanbrain.in/iipsrv/fcgi-bin/iipsrv.fcgi?FIF=/data/storageIIT/humanbrain/analytics/52/NISL/B_52_MTB10-SL_63-ST_NISL-SE_382_compressed.jp2&WID=1024&RGBGAMA&JTL={z},{tileIndex}\\\",\\\"name\\\":\\\"NISSL\\\",\\\"type\\\":\\\"titleLayer\\\",\\\"height\\\":24664,\\\"width\\\":22559,\\\"red\\\":{\\\"min\\\":0,\\\"max\\\":255},\\\"green\\\":{\\\"min\\\":0,\\\"max\\\":255},\\\"blue\\\":{\\\"min\\\":0,\\\"max\\\":255},\\\"gama\\\":1.4,\\\"opacity\\\":0.9,\\\"rigidrotation\\\":0,\\\"family\\\":\\\"brain\\\",\\\"sublayers\\\":[],\\\"trsdata\\\":null,\\\"export_status\\\":0,\\\"sectionid\\\":\\\"SS-16:12:382\\\"}]\",\"userid\":\"{\\\"id\\\":\\\"UFdBXLmKPTTVYLLxzkwKBm03XhY2\\\",\\\"name\\\":\\\"software team\\\",\\\"photo\\\":\\\"https://lh3.googleusercontent.com/a/AAcHTte--G1vkdrm_ojhRzgIsEpuDHA-4loc7lX1bl-XensG=s96-c\\\"}\",\"id\":21659,\"externalkey\":\"FlatTree::IIT:V1:SS-16:12:382:382\",\"annotationtype\":194,\"annotationtype_id\":194}";
		     Response response1 = RestAssured
	             .given()
	                 .auth()
	                 .preemptive()
	                 .basic("admin", "admin")
	                 .contentType(ContentType.JSON)
	                 .body(jsonBody1)
	             .when()
	                 .patch("https://apollo2.humanbrain.in/BR/AppAtlasRegisteration/21659/");
	    	 int statusCode1 = response1.getStatusCode();
	    	 if (statusCode1 == 200) {
	             System.out.println("API request to save annotation passed. Status code: " + statusCode1);
	         } else {
	             System.out.println("API request to save annotation failed. Status code: " + statusCode1);
	         }
	         Assert.assertEquals(statusCode1, 200, "API request to save annotation failed");  
	  }

}