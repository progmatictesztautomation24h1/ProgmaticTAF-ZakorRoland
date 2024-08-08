package api;


import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PetStoreApiTest {
    @Test
    public void getPetByIdFound() {
        given()
        .when().get("https://petstore.swagger.io/v2/pet/9222968140497183222")
        .then().assertThat().statusCode(200);
    }

    @Test
    public void getPetByIdNotFound() {
        given()
        .when().get("https://petstore.swagger.io/v2/pet/92")
        .then().assertThat().statusCode(404);
    }

    @Test
    public void getAllAvailablePet() {
        given()
        .param("status", "available")
        .when().get("https://petstore.swagger.io/v2/pet/findByStatus")
        .then().assertThat().statusCode(200);
    }

    String postBody = "{\n" +
            "  \"id\": 923749237121,\n" +
            "  \"category\": {\n" +
            "    \"id\": 0,\n" +
            "    \"name\": \"string\"\n" +
            "  },\n" +
            "  \"name\": \"Asztor\",\n" +
            "  \"photoUrls\": [\n" +
            "    \"https://www.purina.co.uk/sites/default/files/2020-12/Dog_1098119012_Teaser.jpg\"\n" +
            "  ],\n" +
            "  \"tags\": [\n" +
            "    {\n" +
            "      \"id\": 0,\n" +
            "      \"name\": \"string\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"available\"\n" +
            "}";

    @Test
    public void postNewPet() {
        given()
        .body(postBody).header("Content-Type", "application/json")
        .when().post("https://petstore.swagger.io/v2/pet")
        .then().assertThat().statusCode(200);
    }

}