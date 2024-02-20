package SanityTesting;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Contacts_api_colab {
	
	@Test
    public void testGetRegionDataAPI() {
	 Map<String, String> formParams = new HashMap<>();
        formParams.put("fname", ""); // Add your parameters here
        formParams.put("email", "");
        formParams.put("phone", "");
        formParams.put("mge", "");

        // Send the POST request with form URL-encoded parameters
        Response response = RestAssured
                .given()
                    .auth()
                    .preemptive()
                    .basic("admin", "admin") // replace with actual credentials in a secure way
                    .contentType(ContentType.URLENC)
                    .formParams(formParams) // Set the form parameters
                .when()
                    .post("https://apollo2.humanbrain.in/GW/contactSubmit");

        // Get the response status code
        int statusCode = response.getStatusCode();

        // Use Assert to validate the response status code
        Assert.assertEquals(statusCode, 200, "API request to get region data failed");

        // This line will only execute if the assertion above is successful
        System.out.println("API request to the GetRegion data passed. Status code: " + statusCode);
    }

}
