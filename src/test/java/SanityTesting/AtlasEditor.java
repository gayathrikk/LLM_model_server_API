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
		 String jsonBody = "{\"atlasgeojson\":\"{\\\"type\\\":\\\"FeatureCollection\\\",\\\"features\\\":[{\\\"type\\\":\\\"Feature\\\","
		 		+ "\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[14298.560789480227,-14471.355983719397],"
		 		+ "[15120.258843545871,-13305.69130237046],[15789.082841041163,-14203.82638472128],[14298.560789480227,-14471.355983719397]]]},"
		 		+ "\\\"properties\\\":{\\\"data\\\":{\\\"text\\\":\\\"central tegmental tract\\\",\\\"acronym\\\":\\\"ctg\\\",\\\"color_hex_triplet\\\":"
		 		+ "\\\"F2F1F0\\\",\\\"failed_facet\\\":734881840,\\\"graph_order\\\":3126,\\\"id\\\":12730,\\\"name\\\":\\\"central tegmental tract\\\","
		 		+ "\\\"parent_structure_id\\\":10668,\\\"safe_name\\\":\\\"central tegmental tract\\\",\\\"st_level\\\":null,\\\"structure_id_path\\\":\\\""
		 		+ "/10153/10154/10155/10653/10668/12730/\\\",\\\"structure_name_facet\\\":103413118}},\\\"id\\\":\\\"881\\\"},{\\\"type\\\":\\\"Feature\\\","
		 		+ "\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[13018.240565703523,-16210.29837720716],[13629.736791984935,-15637.02066506834],"
		 		+ "[14890.947758690345,-16229.407634278454],[13018.240565703523,-16210.29837720716]]]},\\\"properties\\\":{\\\"data\\\":{\\\"text\\\":"
		 		+ "\\\"dorsal external fibers\\\",\\\"acronym\\\":\\\"def\\\",\\\"color_hex_triplet\\\":\\\"F2F1F0\\\",\\\"failed_facet\\\":734881840,\\\"graph_order\\\":"
		 		+ "3131,\\\"id\\\":12734,\\\"name\\\":\\\"dorsal external fibers\\\",\\\"parent_structure_id\\\":10668,\\\"safe_name\\\":\\\"dorsal external fibers\\\",\\\""
		 		+ "st_level\\\":null,\\\"structure_id_path\\\":\\\"/10153/10154/10155/10653/10668/12734/\\\",\\\"structure_name_facet\\\":4154535422}},\\\"id\\\":\\\"1048\\\"},"
		 		+ "{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[11852.575884354588,-9923.352800751412],[13495.971992485876,"
		 		+ "-11662.295194239172],[14833.61998747646,-12808.850618516815],[15254.02364304493,-13095.489474586226],[15387.788442543988,-12522.211762447405],[11852.575884354588,"
		 		+ "-9923.352800751412]]]},\\\"properties\\\":{\\\"data\\\":{\\\"text\\\":\\\"forebrain (prosencephalon)\\\",\\\"acronym\\\":\\\"F\\\",\\\"color_hex_triplet\\\":"
		 		+ "\\\"EBD6D0\\\",\\\"failed_facet\\\":734881840,\\\"graph_order\\\":3,\\\"id\\\":10156,\\\"name\\\":\\\"forebrain (prosencephalon)\\\",\\\"parent_structure_id\\\":"
		 		+ "10155,\\\"safe_name\\\":\\\"forebrain (prosencephalon)\\\",\\\"st_level\\\":null,\\\"structure_id_path\\\":\\\"/10153/10154/10155/10156/\\\",\\\"structure_name_facet\\\":"
		 		+ "2015023488}},\\\"id\\\":\\\"772\\\"},{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[13992.812676339523,-9942.462057822706],"
		 		+ "[15693.536555684695,-10993.47119674388],[16190.377239538338,-9885.134286608823],[13992.812676339523,-9942.462057822706]]]},\\\"properties\\\":{\\\"data\\\":{\\\"text\\\":\\\""
		 		+ "forebrain (prosencephalon)\\\",\\\"acronym\\\":\\\"F\\\",\\\"color_hex_triplet\\\":\\\"EBD6D0\\\",\\\"failed_facet\\\":734881840,\\\"graph_order\\\":3,\\\"id\\\":10156,\\\"name\\\""
		 		+ ":\\\"forebrain (prosencephalon)\\\",\\\"parent_structure_id\\\":10155,\\\"safe_name\\\":\\\"forebrain (prosencephalon)\\\",\\\"st_level\\\":null,\\\"structure_id_path\\\":\\\"/10153/10154/10155/10156/\\\","
		 		+ "\\\"structure_name_facet\\\":2015023488}},\\\"id\\\":\\\"485\\\"}],\\\"rotation\\\":0}\",\"accessdetails\":\"[{\\\"order\\\":0,\\\"key\\\":\\\"NISSL\\\",\\\"url\\\":\\\""
		 		+ "https://apollo2.humanbrain.in/iipsrv/fcgi-bin/iipsrv.fcgi?FIF=/data/storageIIT/humanbrain/analytics/220/NISL/B_220_DEV1-SL_1-ST_NISL-SE_42_compressed.jp2&WID=1024&RGBGAMA&JTL={z},"
		 		+ "{tileIndex}\\\",\\\"name\\\":\\\"NISSL\\\",\\\"type\\\":\\\"titleLayer\\\",\\\"height\\\":20248,\\\"width\\\":22979,\\\"red\\\":{\\\"min\\\":0,\\\"max\\\":255},\\\"green\\\":"
		 		+ "{\\\"min\\\":0,\\\"max\\\":255},\\\"blue\\\":{\\\"min\\\":0,\\\"max\\\":255},\\\"gama\\\":1.4,\\\"opacity\\\":0.9,\\\"rigidrotation\\\":0,\\\"family\\\":\\\"brain\\\",\\\"sublayers\\\":[],"
		 		+ "\\\"trsdata\\\":null,\\\"export_status\\\":0,\\\"sectionid\\\":\\\"SS-90:233:42\\\"}]\",\"userid\":\"{\\\"id\\\":\\\"IGG9dZhqQNaJmIJ2o9cvGRfgzW92\\\",\\\"name\\\":\\\"Gayathri B\\\",\\\"photo\\\":"
		 		+ "\\\"https://lh3.googleusercontent.com/a/ALm5wu0jqUbs-dEZO0pbSsHwDZTO3wydRWjsv_aISTth=s96-c\\\"}\",\"id\":17162,\"externalkey\":\"FlatTree::IIT:V1:SS-90:233:42:42\","
		 		+ "\"annotationtype\":6,\"annotationtype_id\":6}";
	        given()
	            .auth()
	            .preemptive()
	            .basic("admin", "admin")
	            .contentType(ContentType.JSON) 
	            .body(jsonBody) 
	        .when()
	            .patch("https://apollo2.humanbrain.in/BR/AppAtlasRegisteration/17162/")
	        .then()
	            .statusCode(200)
	            .body("id", equalTo(17162))
	            .log().all();
	 }

}