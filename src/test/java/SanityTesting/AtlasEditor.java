package SanityTesting;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class AtlasEditor {
	
	@Test
	 void save()
	 {
		 String jsonBody = "{\"atlasgeojson\":\"{\\\"type\\\":\\\"FeatureCollection\\\",\\\"features\\\":[{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[14298.560789480227,-14471.355983719397],[15177.586614759755,-13171.926502871402],[15980.175411754106,-14490.465240790694],[14298.560789480227,-14471.355983719397]]]},\\\"properties\\\":{\\\"data\\\":{\\\"text\\\":\\\"forebrain (prosencephalon)\\\",\\\"acronym\\\":\\\"F\\\",\\\"color_hex_triplet\\\":\\\"EBD6D0\\\",\\\"failed_facet\\\":734881840,\\\"graph_order\\\":3,\\\"id\\\":10156,\\\"name\\\":\\\"forebrain (prosencephalon)\\\",\\\"parent_structure_id\\\":10155,\\\"safe_name\\\":\\\"forebrain (prosencephalon)\\\",\\\"st_level\\\":null,\\\"structure_id_path\\\":\\\"/10153/10154/10155/10156/\\\",\\\"structure_name_facet\\\":2015023488}},\\\"id\\\":\\\"506\\\"},{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[12827.147994990584,-16305.844662563628],[13572.409020771054,-15560.583636783162],[14718.964445048696,-16152.970605993276],[12827.147994990584,-16305.844662563628]]]},\\\"properties\\\":{\\\"data\\\":{\\\"text\\\":\\\"hindbrain (rhombencephalon)\\\",\\\"acronym\\\":\\\"H\\\",\\\"color_hex_triplet\\\":\\\"CAD7EE\\\",\\\"failed_facet\\\":734881840,\\\"graph_order\\\":2672,\\\"id\\\":10653,\\\"name\\\":\\\"hindbrain (rhombencephalon)\\\",\\\"parent_structure_id\\\":10155,\\\"safe_name\\\":\\\"hindbrain (rhombencephalon)\\\",\\\"st_level\\\":null,\\\"structure_id_path\\\":\\\"/10153/10154/10155/10653/\\\",\\\"structure_name_facet\\\":440055500}},\\\"id\\\":\\\"759\\\"}],\\\"rotation\\\":0}\",\"accessdetails\":\"[{\\\"order\\\":0,\\\"key\\\":\\\"NISSL\\\",\\\"url\\\":\\\"https://apollo2.humanbrain.in/iipsrv/fcgi-bin/iipsrv.fcgi?FIF=/data/storageIIT/humanbrain/analytics/220/NISL/B_220_DEV1-SL_1-ST_NISL-SE_42_compressed.jp2&WID=1024&RGBGAMA&JTL={z},{tileIndex}\\\",\\\"name\\\":\\\"NISSL\\\",\\\"type\\\":\\\"titleLayer\\\",\\\"height\\\":20248,\\\"width\\\":22979,\\\"red\\\":{\\\"min\\\":0,\\\"max\\\":255},\\\"green\\\":{\\\"min\\\":0,\\\"max\\\":255},\\\"blue\\\":{\\\"min\\\":0,\\\"max\\\":255},\\\"gama\\\":1.4,\\\"opacity\\\":0.9,\\\"rigidrotation\\\":0,\\\"family\\\":\\\"brain\\\",\\\"sublayers\\\":[],\\\"trsdata\\\":null,\\\"export_status\\\":0,\\\"sectionid\\\":\\\"SS-90:233:42\\\"}]\",\"userid\":\"{\\\"id\\\":\\\"UFdBXLmKPTTVYLLxzkwKBm03XhY2\\\",\\\"name\\\":\\\"software team\\\",\\\"photo\\\":\\\"https://lh3.googleusercontent.com/a/AAcHTte--G1vkdrm_ojhRzgIsEpuDHA-4loc7lX1bl-XensG=s96-c\\\"}\",\"id\":22214,\"externalkey\":\"FlatTree::IIT:V1:SS-90:233:42:42\",\"annotationtype\":6,\"annotationtype_id\":6}";
	        given()
	            .auth()
	            .preemptive()
	            .basic("admin", "admin")
	            .contentType(ContentType.JSON) 
	            .body(jsonBody) 
	        .when()
	            .patch("https://apollo2.humanbrain.in/BR/AppAtlasRegisteration/22214/")
	        .then()
	            .statusCode(200)
	            .body("id", equalTo(22214))
	            .log().all();
	 }

}