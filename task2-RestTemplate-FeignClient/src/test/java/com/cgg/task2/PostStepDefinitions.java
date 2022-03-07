package com.cgg.task2;

import com.cgg.task2.vo.ProductVo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PostStepDefinitions {

	private Response response;
	private RequestSpecification request;
	private ValidatableResponse jsonResponse;
	private static final String BASE_PATH = "http://localhost:8080/product/api/addproduct";

	
	@Given("Providing post method api endpoint")
	public void providing_post_method_api_endpoint() {
		ProductVo productVo = new ProductVo(1, "redmi", "8gb", 3, 9000L, "my company");
		request= RestAssured.given().contentType(ContentType.JSON).body(productVo);

	}

	@When("sending POST http request")
	public void sending_post_http_request() {
		response=request.when().post(BASE_PATH);
		response.prettyPrint();
	}

	@Then("valid response with status code {int}")
	public void valid_response_with_status_code(Integer int1) {
		jsonResponse=response.then().statusCode(int1);
	}

}
