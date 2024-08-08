package api;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class StarWarsApiTest {

    @DataProvider(name = "targetedStarships")
    public Object[] targetedStarships() {
        return new Object[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 100, 1000};
        //return new Object[]{9};
    }

    @Test(dataProvider = "targetedStarships")
    public void starshipTest(Object shipId) {

        System.out.println();
        String url = "https://swapi.dev/api/starships/" + (int) shipId;
        System.out.println(url);

        given()
                .when()
                .get(url)
                .then()
                .assertThat().statusCode(200)
                .assertThat().body("name", not(emptyOrNullString()))
                .assertThat().body("model", not(emptyOrNullString()))
                .assertThat().body("manufacturer", not(emptyOrNullString()))
                .assertThat().body("cost_in_credits", instanceOf(String.class))
                .assertThat().body("length", instanceOf(String.class))
                .assertThat().body("max_atmosphering_speed", not(emptyOrNullString()))
                .assertThat().body("films[0]", anyOf(startsWith("http://"), startsWith("https://")))
                .assertThat().body("created", instanceOf(String.class))
                .assertThat().body("created", containsString("T"));

    }

}
