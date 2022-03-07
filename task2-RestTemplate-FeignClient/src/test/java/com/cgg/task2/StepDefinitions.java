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

public class StepDefinitions {

	private Response response;
	private RequestSpecification request;
	private ValidatableResponse jsonResponse;
	private static final String BASE_PATH = "http://localhost:8080/product/api/getAllproducts";

	
//	@Given("Get product with id {int}")
//	public void get_product_with_id(Integer int1) {
//		request= RestAssured.given().param("productId", int1);
//	}
	
	@Given("providing product details")
	public void providing_product_details() {
		ProductVo productVo = new ProductVo(1, "redmi", "8gb", 3, 9000L, "my company");
		request= RestAssured.given().contentType(ContentType.JSON).body(productVo);
	}

	@When("sending a get http request")
	public void sending_a_get_http_request() {
		response = request.get(BASE_PATH);
		response.prettyPrint();
	}

	@Then("product details are fetched and displayed")
	public void product_details_are_fetched_and_displayed() {
		jsonResponse = response.then().statusCode(200);

	}
}
