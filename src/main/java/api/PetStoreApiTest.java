package api;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PetStoreApiTest {
    @Test
    public void getPetById() {
        given()
                .when()
                .get("https://petstore.swagger.io/v2/pet/9222968140497184209")
                .then()
                .assertThat().statusCode(200);
    }

    @Test
    public void getPetByIdHasBody() {

        String responseBody = given()
                .when()
                .get("https://petstore.swagger.io/v2/pet/9222968140497184209")
                .then()
                .assertThat().statusCode(200)
                .extract().body().asString();

        Assert.assertFalse(responseBody.isEmpty());
    }

    @Test
    public void getPetByIdHasBody2() {
        given()
                .when()
                .get("https://petstore.swagger.io/v2/pet/9222968140497184334")
                .then()
                .assertThat().statusCode(200)
                .assertThat().body("", not(empty()));

    }

    @Test
    public void getPetByIdHasBodyWithAGoodStructure() {
        given()
                .when()
                .get("https://petstore.swagger.io/v2/pet/9223372016900017299")
                .then()
                .assertThat().statusCode(200)
                .assertThat().body("id", not(emptyOrNullString()))
                .assertThat().body("category", not(emptyOrNullString()))
                .assertThat().body("name", not(emptyOrNullString()))
                .assertThat().body("photoUrls", not(emptyOrNullString()))
                .assertThat().body("tags", not(emptyOrNullString()))
                .assertThat().body("status", not(emptyOrNullString()));
    }

    @Test
    public void getPetByIdHasBodyWithAGoodStructureAndTypes() {
        given()
                .when()
                .get("https://petstore.swagger.io/v2/pet/9223372016900017482")
                .then()
                .assertThat().statusCode(200)
                .assertThat().body("id", instanceOf(Long.class))
                .assertThat().body("category", not(emptyOrNullString()))
                .assertThat().body("name", instanceOf(String.class))
                .assertThat().body("photoUrls", instanceOf(String.class)).assertThat()
                .body("photoUrls", startsWith("http://"))
                .assertThat().body("tags", not(emptyOrNullString()))
                .assertThat().body("status", not(emptyOrNullString()));
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