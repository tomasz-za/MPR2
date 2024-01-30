package com.example.demo_mpr_lab2;

import org.junit.jupiter.api.Test;

import java.util.List;

//import static io.restassured.RestAssured.when;
//import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyRestControllerTest {
    private static final String URI = "http://localhost:8080";

   /** @Test
    public void testGet(){
        when()
                .get(URI + "/user/findById/1")
                .then()
                .statusCode(200)
                .log()
                .body();
    }
   **/

   @Test
   public void testGet(){
       when()
               .get(URI + "/Car/718")
               .then()
               .statusCode(200)
               .assertThat()
               .body("id",equalTo(1))
               .body("name",equalTo("718"))
               .log()
               .body();
   }

    @Test
    public void testGetList(){

                List<Car> list = List.of(
                        when()
                .get(URI + "/Car/show")
                .then()
                .statusCode(200)
                .extract()
                .as(Car[].class));

               assertEquals(1, list.get(0).getId());

    }

    @Test
    public void testPostUser(){
       with()
               .body(new Car("test", "test"))
               .contentType("application/json")
               .post(URI + "/Car/add")
               .then()
               .statusCode(200)
               .assertThat()
               .body("name", equalTo("test"))
               .log()
               .body();


    }
}
