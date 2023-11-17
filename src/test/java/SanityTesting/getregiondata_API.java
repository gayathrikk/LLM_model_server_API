package SanityTesting;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class getregiondata_API {

    @Test
    public void testGetRegionDataAPI() {
        String jsonBody2 = "{\"currentsection\":\"B_142_FB34-SL_82-ST_NISL-SE_241_lossless.jp2\",\"geojson\":\"{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[15416.719663511562,-25344.286033833574],[20127.228884821685,-19760.630616910683],[26128.918031310866,-16828.580862641746],[31206.951081648425,-18057.31448286796],[35207.440378373096,-20848.10833058724],[38540.719555333206,-23792.79856654369],[38677.13631229918,-27214.642859505537],[38677.13631229918,-27670.204239233804],[38677.13631229918,-27746.64126751898],[37472.278228291776,-30700.501978345033],[34556.111391265506,-34398.142194896434],[31826.973029813125,-37751.97366679082],[29983.794116888486,-40587.93866949481],[26871.055669149457,-42700.51193319681],[22473.678129729917,-44774.26249479353],[17045.116074834063,-46783.15235167555],[14950.327403208474,-47169.036169591294],[12937.746958113952,-46692.703207615436],[11652.675437111066,-43324.22549883708],[11060.839514205065,-40055.30960915288],[11060.839514205065,-40055.30960915288],[10737.110475133952,-32746.15928061402],[14461.563313446415,-26851.09032451568],[15416.719663511562,-25344.286033833574]]]}\",\"biosample\":\"142\"}"; // Your JSON body here
        Response response = RestAssured
            .given()
                .auth()
                .preemptive()
                .basic("admin", "admin") // replace with actual credentials in a secure way
                .contentType(ContentType.JSON)
                .body(jsonBody2)
            .when()
                .post("https://apollo2.humanbrain.in/dgx/getRegionData/");
        int statusCode = response.getStatusCode();
        
        // Use Assert to validate the response status code
        Assert.assertEquals(statusCode, 200, "API request to getregion data failed");

        // This line will only execute if the assertion above is successful
        System.out.println("API request to the Getregion data passed. Status code: " + statusCode);
    }
}
