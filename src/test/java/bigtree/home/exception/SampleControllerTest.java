package bigtree.home.exception;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import bigtree.home.exception.ex.SampleExceptionRuntimeException;
import bigtree.home.exception.service.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SampleApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SampleControllerTest {

    @Value("classpath:users.json")
    private Resource jsonData;
    @LocalServerPort
    private int port;

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    public void testException() {
        try {
            RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE).when().get("/api/testException");
            fail("Expected an SampleExceptionRuntimeException to be thrown");
        } catch (SampleExceptionRuntimeException e) {
            assertEquals(e.getErrorCode(), 8888);
        }
    }

    @Test
    public void testValidation() throws JsonParseException, JsonMappingException, IOException {

        // String jsonStr = new
        // String(FileCopyUtils.copyToByteArray(jsonData.getInputStream()));
        // ObjectMapper oMapper = new ObjectMapper();
        // User u = oMapper.readValue(jsonStr, User.class);

        User u = User.builder().name("min").age(31111111).money(Arrays.asList(BigDecimal.valueOf(1111))).build();

        Response response = RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE).body(u).when()
                .post("/api/sampleData");

        response.statusCode();
        if (response.statusCode() != 200)
            assertThat(Integer.valueOf(response.getBody().jsonPath().getInt("errorCode"))).isEqualTo(8888);
        else
            fail("error code expected is 8888 ,but the return is " + response.getBody().as(User.class));

    }
}
