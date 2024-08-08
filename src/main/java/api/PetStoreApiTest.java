package api;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class PetStoreApiTest {
    @Test
    public void getPetByIdFound() {
        given()
        .when()
                .get("https://petstore.swagger.io/v2/pet/9222968140497183222")
        .then()
                .assertThat().statusCode(200);
    }

    @Test
    public void getPetByIdNotFound() {
        given()
        .when()
                .get("https://petstore.swagger.io/v2/pet/92")
        .then()
                .assertThat().statusCode(404);
    }

    @Test
    public void getAllAvailablePet() {
        given()
                .param("status", "available")
        .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus")
        .then()
                .assertThat().statusCode(200);
    }

    @Test
    public void postNewPet() {
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

        given()
                .body(postBody)
                .header("Content-Type", "application/json")
        .when()
                .post("https://petstore.swagger.io/v2/pet")
        .then()
                .assertThat().statusCode(200);
    }

    @Test
    public void changeAlreadyExistingPetWithPut() {
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
                "  \"status\": \"sold\"\n" +
                "}";

        given()
                .body(postBody)
                .header("Content-Type", "application/json")
        .when()
                .put("https://petstore.swagger.io/v2/pet")
        .then()
                .assertThat().statusCode(200);
    }

    @Test
    public void tryToChangeAlreadyExistingPetWithPatch() {
        String postBody = "{\n" +
                "  \"id\": 923749237121,\n" +
                "  \"name\": \"Asztor new\"\n" +
                "}";

        given()
                .body(postBody)
                .header("Content-Type", "application/json")
        .when()
                .patch("https://petstore.swagger.io/v2/pet")
       .then()
                .assertThat().statusCode(405);
    }


    @Test
    public void deletePetById() {
        given()
                .when()
                .delete("https://petstore.swagger.io/v2/pet/923749237121")
                .then()
                .assertThat().statusCode(200);
    }

}