package APITesting;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class API_functions {
	
	@Test
	public void test_get_1()
	{
		
		Response response = get("https://data.cityofchicago.org/resource/6zsd-86xi/10666778.json");
		int statuscode = response.getStatusCode();
		System.out.println(response.getTime());		
		Assert.assertEquals(statuscode, 200); 
	}
	@Test
	public void test_get_2() 
	{
		baseURI = "https://data.ct.gov/resource/y6p2-px98.json";
		given()
		.get("?category=Fruit&farm_name=Karabin Farms&farmer_id=7243&item=Peaches")
		.then()
		.statusCode(200).log().all();
	}
	@Test
	public void test_put1() {
		
		baseURI = "https://data.cityofchicago.org";
		JSONObject request = new JSONObject();
		request.put("description", "testtestHARASSMENT BY ELECTRONIC MEANS");
		given()
		.auth()
		.preemptive()
		.basic("3rz9e5hiypbprhqn02979sfez", "62i64c94mw8in4t0r4qsmnmuhm3oufdlmg5ibhbnk0i8zn8f5v")
		.headers("Content-Type","application/json")
		.accept("*/*")
		.body(request.toJSONString())
		.when()
		.post("resource/6zsd-86xi/10666778.json")
		.then()
		.statusCode(200).log().all();
		
		}
		
	@Test
	public void test_delete() {
		baseURI = "https://data.cityofchicago.org";
		given()
		.auth()
		.preemptive()
		.basic("3rz9e5hiypbprhqn02979sfez", "62i64c94mw8in4t0r4qsmnmuhm3oufdlmg5ibhbnk0i8zn8f5v")
		.headers("Content-Type","application/json")
		.accept("*/*")
		.when()
		.delete("resource/6zsd-86xi/10666778.json")
		.then()
		.statusCode(200).log().all();
		
	}
	}

	
	


