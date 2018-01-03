package com.exercise.rest;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class MeasurementResourceIntegrationTest {

    @LocalServerPort
    private int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void should_add_new_measurement() {
        // add measurement
        given().
                contentType(JSON).
                body("{ \"sensorId\": 3," +
                        "        \"measurementValue\": 15.35," +
                        "        \"measurementTime\": \"2017-12-30T12:25:43\"}").
                when().
                post("/measurements").

                then().
                statusCode(CREATED.value());

        // add measurement for non-existing sensor
        given().
                contentType(JSON).
                body("{ \"sensorId\": 8," +
                        "        \"measurementValue\": 18.35," +
                        "        \"measurementTime\": \"2017-12-30T12:26:43\"}").
                when().
                post("/measurements").

                then().
                statusCode(BAD_REQUEST.value());
    }

}
