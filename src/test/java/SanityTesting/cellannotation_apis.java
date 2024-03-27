package SanityTesting;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class cellannotation_apis {
	  
	  @Test(priority=1)
	  public void appatlas()
	    {
	    	//App atlas Registration
	    	Response response1 = RestAssured
	    		    .given()
	    		    .auth()
	    		    .basic("admin", "admin")
	    		    .when()
	    		    .get("https://apollo2.humanbrain.in/BR/AppAtlasRegisteration/22992/");
	      int statusCode1 = response1.getStatusCode();
	      if (statusCode1 == 200) {
	          System.out.println("API request to the appatlas registration of Cell annotation passed. Status code: " + statusCode1);
	      } else {
	          System.out.println("API request to the appatlas registration of Cell annotation failed. Status code: " + statusCode1);
	      }
	      Assert.assertEquals(statusCode1, 200, "API request to the appatlas registration of Cell annotation failed");
	    }
	  
	  @Test(priority=2)
	  public void Brainviewer()
	  {
	      
	      //Get brain viewer details
	      Response response2 = RestAssured.get("https://apollo2.humanbrain.in/GW/getBrainViewerDetails/IIT/V1/SS-16:12:382");
	      int statusCode2 = response2.getStatusCode();
	      if (statusCode2 == 200) {
	          System.out.println("API request to the brain viewer details of cell annotation passed. Status code: " + statusCode2);
	      } else {
	          System.out.println("API request to the brain viewer details of cell annotation failed. Status code: " + statusCode2);
	      }
	      Assert.assertEquals(statusCode2, 200, "API request to the brain viewer details of cell annotation failed");
	      
	  }
	  
	  @Test(priority=3)
	  public void appannotation()
	  {
	      
	      //App annotation type
	      Response response3 = RestAssured
	  		    .given()
	  		    .auth()
	  		    .basic("admin", "admin")
	  		    .when()
	  		    .get("https://apollo2.humanbrain.in/BR/AppAnnotationType/");
	      
	    int statusCode3 = response3.getStatusCode();
	    if (statusCode3 == 200) {
	        System.out.println("API request to get app annotation type details of Cell annotation page passed. Status code: " + statusCode3);
	    } else {
	        System.out.println("API request to get app annotation type details of Cell annotation page failed. Status code: " + statusCode3);
	    }
	    Assert.assertEquals(statusCode3, 200, "API request to get app annotation type details of Cell annotation page failed");
	  }
	  
	  @Test(priority=4)
	  public void contributors()
	  {
	      
	       //Contributors
	    Response response4 = RestAssured
	  		    .given()
	  		    .auth()
	  		    .basic("admin", "admin")
	  		    .when()
	  		    .get("https://apollo2.humanbrain.in/BR/AppAtlasRegisteration/?externalkey=PixelAnnotation::IIT:V1:SS-16:12:382:382&annotationtype=3");    
	    
		  int statusCode4 = response4.getStatusCode();
		  if (statusCode4 == 200) {
		      System.out.println("API request to get contributors details of cell annotation passed. Status code: " + statusCode4);
		  } else {
		      System.out.println("API request to get contributors details of cell annotation failed. Status code: " + statusCode4);
		  }
		  Assert.assertEquals(statusCode4, 200, "API request to get contributors details of Cell annotation failed");
	  }
	  
	  @Test(priority=5)
	  public void annotatedtile()
	  {
		  
		  //Annotated tile list
		  String jsonBody1 = "{\"bid\":52,\"sec\":382,\"annotationtype\":3,\"seriestype\":\"NISSL\",\"tilesize_ip\":\"512\",\"tilesize_op\":512}";
		   	 Response response5 = RestAssured
		            .given()
		                .auth()
		                .preemptive()
		                .basic("admin", "admin")
		                .contentType(ContentType.JSON)
		                .body(jsonBody1)
		            .when()
		                .post("https://apollo2.humanbrain.in/GW/listAnnotatedTiles");
		   	 int statusCode5 = response5.getStatusCode();
		   	 if (statusCode5 == 200) {
		            System.out.println("API request to list of annotated tiles  passed. Status code: " + statusCode5);
		        } else {
		            System.out.println("API request to list of annotated tiles failed. Status code: " + statusCode5);
		        }
		        Assert.assertEquals(statusCode5, 200, "API request to list of annotated tiles failed"); 
	  }
	  
	  @Test(priority=6)
	  public void Wiptile()
	  {
		        
		        //WIP tile list
		        String jsonBody2 = "{\"bid\":52,\"sec\":382,\"annotationtype\":3,\"seriestype\":\"NISSL\",\"tilesize_ip\":\"512\",\"tilesize_op\":512}";
			   	 Response response6 = RestAssured
			            .given()
			                .auth()
			                .preemptive()
			                .basic("admin", "admin")
			                .contentType(ContentType.JSON)
			                .body(jsonBody2)
			            .when()
			                .post("https://apollo2.humanbrain.in/GW/listWipTiles");
			   	 int statusCode6 = response6.getStatusCode();
			   	 if (statusCode6 == 200) {
			            System.out.println("API request to list of wip tiles  passed. Status code: " + statusCode6);
			        } else {
			            System.out.println("API request to list of wip tiles failed. Status code: " + statusCode6);
			        }
			        Assert.assertEquals(statusCode6, 200, "API request to list of wip tiles failed");  
	  }
	  
	  @Test(priority=7)
	  public void AGtile()
	  {
			        
			     //AG tile list
			        String jsonBody3 = "{\"bid\":52,\"sec\":382,\"annotationtype\":3,\"seriestype\":\"NISSL\",\"tilesize_ip\":\"512\",\"tilesize_op\":512}";
				   	 Response response7 = RestAssured
				            .given()
				                .auth()
				                .preemptive()
				                .basic("admin", "admin")
				                .contentType(ContentType.JSON)
				                .body(jsonBody3)
				            .when()
				                .post("https://apollo2.humanbrain.in/GW/listWipTiles");
				   	 int statusCode7 = response7.getStatusCode();
				   	 if (statusCode7 == 200) {
				            System.out.println("API request to list of AG tiles  passed. Status code: " + statusCode7);
				        } else {
				            System.out.println("API request to list of AG tiles failed. Status code: " + statusCode7);
				        }
				        Assert.assertEquals(statusCode7, 200, "API request to list of AG tiles failed");    
		  
		   
		    }
	  
	  @Test(priority=8)
	  public void tileloading_API()
	  {
		  Response response1 = RestAssured
	    		    .given()
	    		    .auth()
	    		    .basic("admin", "admin")
	    		    .when()
	    		    .get("https://apollo2.humanbrain.in/iipsrv1/fcgi-bin/iipsrv.fcgi?FIF=/data/storageIIT/humanbrain/analytics/52/NISL/B_52_MTB10-SL_63-ST_NISL-SE_382_lossless.jp2&GAM=1.5&WID=512&RGN=0.5900970787712221,0.37366201751540706,0.02269604149120085,0.02075900097307817&CVT=jpeg");
	      int statusCode1 = response1.getStatusCode();
	      if (statusCode1 == 200) {
	          System.out.println("API request to the tile loading passed. Status code: " + statusCode1);
	      } else {
	          System.out.println("API request to the tile loading failed. Status code: " + statusCode1);
	      }
	      Assert.assertEquals(statusCode1, 200, "API request to the tile loading failed");
	  }
	  
	 @Test(priority=9) 
	 public void  Celldetection_API()
	 {
		 
  	 Response response1 = RestAssured
           .given()
               .auth()
               .preemptive()
               .basic("admin", "admin")
               .formParam("iipsrv", "https://apollo2.humanbrain.in/iipsrv1/fcgi-bin/iipsrv.fcgi?FIF=/data/storageIIT/humanbrain/analytics/52/NISL/B_52_MTB10-SL_63-ST_NISL-SE_382_lossless.jp2&GAM=1.5&WID=512&RGN=0.5900970787712221,0.37366201751540706,0.02269604149120085,0.02075900097307817&CVT=jpeg")
           .when()
               .post("https://apollo2.humanbrain.in/ml/predictions/ep1");
  	 int statusCode1 = response1.getStatusCode();
  	 if (statusCode1 == 200) {
           System.out.println("API request to cell detection firstpass passed. Status code: " + statusCode1);
       } else {
           System.out.println("API request to cell detection firstpass failed. Status code: " + statusCode1);
       }
       Assert.assertEquals(statusCode1, 200, "API request to cell detection firstpass failed");  
	 }
	
	 @Test(priority=10)
	 public void Centroiddetection_API()
	 {
		 Response response1 = RestAssured
	             .given()
	                 .auth()
	                 .preemptive()
	                 .basic("admin", "admin")
	                 .formParam("iipsrv", "https://apollo2.humanbrain.in/iipsrv1/fcgi-bin/iipsrv.fcgi?FIF=/data/storageIIT/humanbrain/analytics/52/NISL/B_52_MTB10-SL_63-ST_NISL-SE_382_lossless.jp2&GAM=1.5&WID=512&RGN=0.5900970787712221,0.37366201751540706,0.02269604149120085,0.02075900097307817&CVT=jpeg")
	             .when()
	                 .post("https://apollo2.humanbrain.in/ml/predictions/ep4");
	    	 int statusCode1 = response1.getStatusCode();
	    	 if (statusCode1 == 200) {
	             System.out.println("API request to centroid detection firstpass passed. Status code: " + statusCode1);
	         } else {
	             System.out.println("API request to centroid detection firstpass failed. Status code: " + statusCode1);
	         }
	         Assert.assertEquals(statusCode1, 200, "API request to centroid detection firstpass failed");  
		 
	 }
	 
	 @Test(priority=11)
	 public void Rabbies_API()
	 {
		 Response response1 = RestAssured
	             .given()
	                 .auth()
	                 .preemptive()
	                 .basic("admin", "admin")
	                 .formParam("iipsrv", "https://apollo2.humanbrain.in/iipsrv1/fcgi-bin/iipsrv.fcgi?FIF=/data/storageIIT/humanbrain/analytics/52/NISL/B_52_MTB10-SL_63-ST_NISL-SE_382_lossless.jp2&GAM=1.5&WID=512&RGN=0.5900970787712221,0.37366201751540706,0.02269604149120085,0.02075900097307817&CVT=jpeg")
	             .when()
	                 .post("https://apollo2.humanbrain.in/ml/predictions/ep7");
	    	 int statusCode1 = response1.getStatusCode();
	    	 if (statusCode1 == 200) {
	             System.out.println("API request to Rabbies firstpass passed. Status code: " + statusCode1);
	         } else {
	             System.out.println("API request to Rabbies firstpass failed. Status code: " + statusCode1);
	         }
	         Assert.assertEquals(statusCode1, 200, "API request to centroid detection firstpass failed");  
	 }
	
	 @Test(priority=12)
	 public void Save_API()
	 {
		 File file = new File("src/test/resource/celldetectionSaveapi.txt");
		 Response response1 = RestAssured
				 .given()
		            .auth()
		            .preemptive()
		            .basic("admin", "admin")
		            .contentType(ContentType.JSON) 
		            .body(file)
	             .when()
	                 .post("https://apollo2.humanbrain.in/GW/save_pixel_additions_status_wp");
	    	 int statusCode1 = response1.getStatusCode();
	    	 if (statusCode1 == 200) {
	             System.out.println("API request to save passed. Status code: " + statusCode1);
	         } else {
	             System.out.println("API request to save firstpass failed. Status code: " + statusCode1);
	         }
	         Assert.assertEquals(statusCode1, 200, "API request to save firstpass failed");  
	 }
	 
	 @Test(priority=13)
	 public void activity()
	 {
		 String jsonBody1 = "{\"user\":57,\"action\":\"Cell Annotation\",\"info\":\"SS-15:10:1012\"}";
    	 Response response1 = RestAssured
             .given()
                 .auth()
                 .preemptive()
                 .basic("admin", "admin")
                 .contentType(ContentType.JSON)
                 .body(jsonBody1)
             .when()
                 .post("https://apollo2.humanbrain.in/activities/Activity/");
    	 int statusCode1 = response1.getStatusCode();
    	 if (statusCode1 == 201) {
             System.out.println("API request to Brainaccess Activity passed. Status code: " + statusCode1);
         } else {
             System.out.println("API request to Brainaccess Activity failed. Status code: " + statusCode1);
         }
         Assert.assertEquals(statusCode1, 201, "API request to Activity failed");  
	 }

}
