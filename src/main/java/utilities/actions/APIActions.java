package utilities.actions;

import utilities.ConfigUtil;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.EncoderConfig;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

//Created by Ahmed Abdelhamid
public class APIActions {
    private static RequestSpecification request = given().relaxedHTTPSValidation();

    /**
     * @param targetPortal Set the target URL to hit
     * @return Returns the base URI
     */
    @SuppressWarnings("Method need to be modified with URLs for WTT in configuration file first.")
    private static String setBaseUrl(TargetPortal targetPortal) {
        switch (targetPortal) {
            case ST:
               return ConfigUtil.STURL;
            case SIT:
               return ConfigUtil.SITURL;
            case ChangeManagementST:
//                return ConfigUtil.ChangeManagement_API_BASE_URL;
            default:
                break;
        }
        return null;
    }

    /**
     * @param targetPortal  The URL to hit.
     * @param endPoint      The endpoint appended on the URL to hit.
     * @param formParams    To send the request with form parameters
     * @param contentType   Use contentType.ANY when not sending form parameters or JSON.
     *                      Use contentType.URLENC when sending form parameters.
     *                      Use contentType.JSON when sending JSON Object.
     * @return Building the request specs
     */
    @SuppressWarnings("Methods needs to be refactored to be more generic in the term of headers.")
    private static RequestSpecification prepareRequestSpecification(String targetPortal, String endPoint,
                                                                    List<List<Object>> formParams, Map<String, String> headers, ContentType contentType) {
        RequestSpecBuilder builder = new RequestSpecBuilder();
//        builder.setBaseUri(setBaseUrl(targetPortal));
        builder.setBaseUri(targetPortal);
        builder.setBasePath(endPoint);
        builder.setContentType(contentType.toString());

        if (formParams != null) {
            formParams.forEach(param -> {
                builder.addFormParam(param.get(0).toString(), param.get(1));
            });
        }
        if (headers != null && !headers.isEmpty()) {
            headers.forEach((headerName, headerValue) -> builder.addHeader(headerName, headerValue));
        }

        builder.setRelaxedHTTPSValidation();

        builder.setConfig(
                (new RestAssuredConfig()).encoderConfig((new EncoderConfig()).defaultContentCharset("UTF-8")).and()
                        .httpClient(HttpClientConfig.httpClientConfig()
                                .setParam("http.connection.timeout", 10000)
                                .setParam("http.socket.timeout", 10000)
                                .setParam("http.connection-manager.timeout", 10000)));
        return builder.build();
    }

    /**
     * @param targetPortal  The main URI to send request.
     * @param endPoint      The endpoint to hit which is appended on target portal
     * @param requestType   HTTP Method type, example: POST, GET
     * @param JSONObject    JSON body to send in request if exist
     * @return Returns response as Response
     */
    public static Response sendRequest(String targetPortal, String endPoint, RequestType requestType,
                                       int statusCode, String JSONObject, List<List<Object>> formParams, Map<String, String> headers, ContentType contentType) {
        Response response = null;

        System.out.println("Start performing API request on: [" + endPoint + "].");
        if (JSONObject != null) {
            request = given().spec(prepareRequestSpecification(targetPortal, endPoint, formParams, headers, contentType)).body(JSONObject);
        } else if (JSONObject == null) {
            request = given().spec(prepareRequestSpecification(targetPortal, endPoint, formParams, headers, contentType));
        } else {
            System.out.println("Method sendRequest in APIActions class needs to be refactored.");
        }

        switch (requestType) {
            case POST:
                response = request.when().post().then().extract().response();
                System.out.println("Response: [" + response.asString() + "].");
                Assert.assertEquals(response.getStatusCode(), statusCode);
                return response;
            case PATCH:
                response = request.when().patch().then().extract().response();
                System.out.println("Response: [" + response.asString() + "].");
                Assert.assertEquals(response.getStatusCode(), statusCode);
                return response;
            case PUT:
                response = request.when().put().then().extract().response();
                System.out.println("Response: [" + response.asString() + "].");
                Assert.assertEquals(response.getStatusCode(), statusCode);
                return response;
            case GET:
                response = request.when().get().then().extract().response();
                System.out.println("Response: [" + response.asString() + "].");
                Assert.assertEquals(response.getStatusCode(), statusCode);
                return response;
            case DELETE:
                response = request.when().delete().then().extract().response();
                System.out.println("Response: [" + response.asString() + "].");
                Assert.assertEquals(response.getStatusCode(), statusCode);
                return response;
            default:
                break;
        }
        System.out.println("Response is null.");
        return response;
    }

    /**
     * Adding enumerations to handle only the possible values that can be provided
     */
    public enum RequestType {
        POST, GET, PATCH, DELETE, PUT
    }

    /**
     * Adding enumerations to handle only the possible values that can be provided
     */
    @SuppressWarnings("To be refactored to have the URL from configuration file.")
    public enum TargetPortal {
        CMST, UMST, ChangeManagementST ,ST ,SIT
    }
}
