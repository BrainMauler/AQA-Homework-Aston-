import jdk.jfr.Description;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.ToStringConversion;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

//В тестах проверяются поля, значения которых возможно знать заранее.

public class EchoTest {
    private final String BASEURI = "https://postman-echo.com";
    private final String HOST = "postman-echo.com";
    private final String XFORWPROTO = "https";
    private final String XFORWPORT = "443";
    private final String CONTTYPE = "application/json";
    private final String CONTTYPEURL = "application/x-www-form-urlencoded; charset=utf-8";
    private final String USERAGENT = "Apache-HttpClient/4.5.13 (Java/11.0.6)";
    private final String ACCEPT = "*/*";
    private final String ACCEPTENC = "gzip,deflate";
    private String text = "positive test";
    private int contLength = text.length();

    @Test
    @Description("Тест запроса GET")
    public void getTest() {
        Specifications.installSpec(Specifications.reqJsonSpec(BASEURI),
                Specifications.respSpec(200));

        EchoPojo args = given()
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .log().body()
                .extract().body().jsonPath().getObject("args", EchoPojo.class);

        assertEquals("bar1", args.getFoo1(), "args GET не соотв. ожид.");
        assertEquals("bar2", args.getFoo2(), "args GET не соотв. ожид.");

        EchoPojo headers = given()
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .log().body()
                .extract().body().jsonPath().getObject("headers", EchoPojo.class);

        assertEquals(List.of(HOST, XFORWPROTO, XFORWPORT, CONTTYPE,
                        ACCEPT, USERAGENT, ACCEPTENC),
                headers.getReqHeaders(), "headers GET не соотв. ожид.");
    }

        @Test
        @Description("Тест запроса POSTRawText")
        public void postRTTest() {
            Specifications.installSpec(Specifications.reqJsonSpec(BASEURI),
                    Specifications.respSpec(200));

                     given()
                    .body(text)
                    .when()
                    .post("/post")
                    .then()
                    .assertThat()
                            .body("data", Matchers.equalTo(text));

            EchoPojo headers = given()
                    .body(text)
                    .when()
                    .post("/post")
                    .then()
                    .log().body()
                    .extract().body().jsonPath().getObject("headers", EchoPojo.class);

            assertEquals(List.of(HOST, Integer.toString(contLength), XFORWPROTO, XFORWPORT,
                            CONTTYPE, ACCEPT, USERAGENT, ACCEPTENC),
                    headers.postRTReqHeaders(), "headers POST Raw Text не соотв. ожид.");
    }

    @Test
    @Description("Тест запроса POST Form Data")
    public void postFDTest() {
        Specifications.installSpec(Specifications.reqUrlEncSpec(BASEURI),
                Specifications.respSpec(200));

        EchoPojo form = given()
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .log().body()
                .extract().body().jsonPath().getObject("form", EchoPojo.class);

        assertEquals("bar1", form.getFoo1(), "formParam POST Form Data" +
                " не соотв. ожид.");
        assertEquals("bar2", form.getFoo2(), "formParam POST Form Data" +
                " не соотв. ожид.");

        EchoPojo headers = given()
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .log().body()
                .extract().body().jsonPath().getObject("headers", EchoPojo.class);

        assertEquals(List.of(HOST, Integer.toString(("foo1=bar1&foo2=bar2").length()),
                        XFORWPROTO, XFORWPORT, ACCEPT, CONTTYPEURL, USERAGENT, ACCEPTENC),
                headers.postFDReqHeaders(), "headers POST Form Data не соотв. ожид.");
    }

    @Test
    @Description("Тест запроса PUT")
    public void putTest() {
        Specifications.installSpec(Specifications.reqJsonSpec(BASEURI),
                Specifications.respSpec(200));

        given()
                .body(text)
                .when()
                .put("/put")
                .then()
                .assertThat()
                        .body("data", Matchers.equalTo(text));

        EchoPojo headers = given()
                .body(text)
                .when()
                .put("/put")
                .then()
                .log().body()
                .extract().body().jsonPath().getObject("headers", EchoPojo.class);

        assertEquals(List.of(HOST, Integer.toString(contLength),
                        XFORWPROTO, XFORWPORT, ACCEPT, CONTTYPE, USERAGENT, ACCEPTENC),
                headers.putReqHeaders(), "headers PUT не соотв. ожид.");
    }

    @Test
    @Description("Тест запроса PATCH")
    public void patchTest() {
        Specifications.installSpec(Specifications.reqJsonSpec(BASEURI),
                Specifications.respSpec(200));

        given()
                .body(text)
                .when()
                .patch("/patch")
                .then()
                .assertThat()
                        .body("data", Matchers.equalTo(text));

        EchoPojo headers = given()
                .body(text)
                .when()
                .patch("/patch")
                .then()
                .log().body()
                .extract().body().jsonPath().getObject("headers", EchoPojo.class);

        assertEquals(List.of(HOST, Integer.toString(contLength),
                        XFORWPROTO, XFORWPORT, ACCEPT, CONTTYPE, USERAGENT, ACCEPTENC),
                headers.patchReqHeaders(), "headers PATCH не соотв. ожид.");
    }

    @Test
    @Description("Тест запроса DELETE")
    public void deleteTest() {
        Specifications.installSpec(Specifications.reqJsonSpec(BASEURI),
                Specifications.respSpec(200));

        given()
                .body(text)
                .when()
                .delete("/delete")
                .then()
                .assertThat()
                        .body("data", Matchers.equalTo(text));

        EchoPojo headers = given()
                .body(text)
                .when()
                .delete("/delete")
                .then()
                .log().body()
                .extract().body().jsonPath().getObject("headers", EchoPojo.class);

        assertEquals(List.of(HOST, Integer.toString(contLength),
                        XFORWPROTO, XFORWPORT, ACCEPT, CONTTYPE, USERAGENT, ACCEPTENC),
                headers.deleteReqHeaders(), "headers DELETE не соотв. ожид.");
    }

}
