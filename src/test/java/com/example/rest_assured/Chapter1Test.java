package com.example.rest_assured;

import org.junit.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Chapter1Test {

    @Test
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills() {

        given().
            log().all().
        when().
            get("http://zippopotam.us/us/90210").
        then().
            assertThat().
            statusCode(200).
            contentType(ContentType.JSON).
            log().body().
            // body("places[0].'state'", equalTo("California"));
            // ask for collection not for element
            // hassize to tell that there is only one place name in that context
            // body("places.'state'", hasItem("California"));
            body("places.'state'", hasSize(1));
    }
}
