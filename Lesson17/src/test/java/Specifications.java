import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {
    public static RequestSpecification reqJsonSpec(String url){
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification reqUrlEncSpec(String url){
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType("application/x-www-form-urlencoded; charset=utf-8")
                .build();
    }

    public static ResponseSpecification respSpec(int status){
        return new ResponseSpecBuilder()
                .expectStatusCode(status)
                .build();
    }

    public static void installSpec(RequestSpecification request, ResponseSpecification response){
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }

}
