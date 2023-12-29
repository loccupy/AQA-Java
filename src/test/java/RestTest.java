import Spec.Specifications;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.codehaus.groovy.util.ListHashMap;
import org.junit.jupiter.api.*;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RestTest {

    private final static String URL = "https://postman-echo.com";
    Map<String, String> params = new ListHashMap<>();

    @BeforeAll
    static void setup() {
        Specifications.installSpec(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
    }

    @Test
    @Order(1)
    public void getRequest() {
        given()
                .when().get("/get")
                .then().log().body()
                .assertThat()
                .body("args", equalTo(params))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.content-type", equalTo("application/json"))
                .body("headers.accept", equalTo(ContentType.ANY.getAcceptHeader()))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.21)"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("url", equalTo(URL + "/get"));
    }

    @Test
    @Order(2)
    public void getRequestWoops() {
        given()
                .when().get("/get?foo1=bar1&foo2=bar2")
                .then().log().body()
                .assertThat()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.content-type", equalTo("application/json"))
                .body("headers.accept", equalTo(ContentType.ANY.getAcceptHeader()))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.21)"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("url", equalTo(URL + "/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    @Order(3)
    public void  postRawTest() {
        given()
                .contentType(ContentType.TEXT)
                .body("{\n    \"test\": \"value\"\n}")
                .when().post("/post")
                .then().log().body()
                .body("args", equalTo(params))
                .body("data", equalTo("{\n    \"test\": \"value\"\n}"))
                .body("files", equalTo(params))
                .body("form", equalTo(params))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.content-length", equalTo("23"))
                .body("headers.accept", equalTo(ContentType.ANY.getAcceptHeader()))
                .body("headers.content-type", startsWith("text/plain"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.21)"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("json", nullValue())
                .body("url", equalTo(URL + "/post"));
    }

    @Test
    @Order(4)
    public void postFormData() {
        given()
                .contentType(ContentType.URLENC.withCharset("UTF-8"))
                .config(RestAssured.config().encoderConfig(encoderConfig()
                        .encodeContentTypeAs("form", ContentType.TEXT)))
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .post("post")
                .then().log().body()
                .body("args", equalTo(params))
                .body("data", equalTo(""))
                .body("files", equalTo(params))
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.content-length", equalTo("19"))
                .body("headers.accept", equalTo(ContentType.ANY.getAcceptHeader()))
                .body("headers.content-type", startsWith("application/x-www-form-urlencoded"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.21)"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"))
                .body("url", equalTo(URL + "/post"));

    }

    @Test
    @Order(5)
    public void putRequest() {
        String dataText = "This is expected to be sent back as part of response body.";
        given()
                .contentType(ContentType.TEXT)
                .body(dataText)
                .put("/put")
                .then().log().body()
                .assertThat()
                .body("args", equalTo(params))
                .body("data", equalTo(dataText))
                .body("files", equalTo(params))
                .body("form", equalTo(params))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.content-length", equalTo("58"))
                .body("headers.accept", equalTo(ContentType.ANY.getAcceptHeader()))
                .body("headers.content-type", startsWith("text/plain"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.21)"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("json", nullValue())
                .body("url", equalTo(URL + "/put"));
    }

    @Test
    @Order(6)
    public void patchRequest() {
        String dataText = "This is expected to be sent back as part of response body.";
        given()
                .contentType(ContentType.TEXT)
                .body(dataText)
                .patch("/patch")
                .then().log().body()
                .assertThat()
                .body("args", equalTo(params))
                .body("data", equalTo(dataText))
                .body("files", equalTo(params))
                .body("form", equalTo(params))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.content-length", equalTo("58"))
                .body("headers.accept", equalTo(ContentType.ANY.getAcceptHeader()))
                .body("headers.content-type", startsWith("text/plain"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.21)"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("json", nullValue())
                .body("url", equalTo(URL + "/patch"));
    }

    @Test
    @Order(7)
    public void deleteRequest() {

        String dataText = "This is expected to be sent back as part of response body.";

        given()
                .contentType(ContentType.TEXT)
                .body(dataText)
                .delete("/delete")
                .then().log().body()
                .assertThat()
                .body("args", equalTo(params))
                .body("data", equalTo(dataText))
                .body("files", equalTo(params))
                .body("form", equalTo(params))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.content-length", equalTo("58"))
                .body("headers.accept", equalTo(ContentType.ANY.getAcceptHeader()))
                .body("headers.content-type", startsWith("text/plain"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.21)"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("json", nullValue())
                .body("url", equalTo(URL + "/delete"));
    }
}