package pl.redny.mikrus

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class MikrusResourceTest {

    @Test
    fun testHelloEndpoint() {
        given()
          .`when`().get("/api/v1/info")
          .then()
             .statusCode(500)
    }

}
