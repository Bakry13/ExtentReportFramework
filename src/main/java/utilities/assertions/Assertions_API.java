package utilities.assertions;
import utilities.actions.JSONActions;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Assertions_API {
    String errorCode_JsonPath = "code";
    String error_JsonPath = "errors";
    String error_HttpStatus = "httpStatus";

    private String unauthorized = "common.auth.unauthorized";
    private String unsupportedHTTPMethod = "common.validation.httpRequestMethodNotSupported";
    private String invalidInputParam = "common.validation.invalidInputParam";
    private String typeMismatch = "common.validation.typeMismatch";
    private String missingHeader = "common.validation.missingHeader";

    private static String expiredToken = "ted.um.auth.invalid.webtt.token";
    private static String authUserNotFound = "ted.um.auth.user.not.found";
    private static String userNotFound = "ted.um.user.not.found";

    private static String changeRequestNotFoundForUser = "ted.cm.change.request.not.found.for.user";
    private static String changeRequestNotFound = "ted.cm.change.request.not.found";
    private static String changeRequestExpired = "ted.cm.change.request.expired";
    private static String changeRequestCancelled = "ted.cm.change.request.cancelled";
    private static String authorizationForbidden = "common.auth.forbidden";
    private static String httpMediaNotSupprted = "common.validation.httpMediaTypeNotSupported";
    private static String invalidMessageFormat = "common.validation.invalidMessageFormat";
    private static String Forbidden = "FORBIDDEN";
    private static String notFoundValueOfHttpStatus="NOT_FOUND";

//===================================Value Assertions====================================
//-------------------------------Verify the correctness of String value------------------
    public static void assertString(String actualValue, String expectedValue)
    {
        try { assert actualValue.equals(expectedValue);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    //-------------------------------Verify the correctness of integer value--------------
    public static void assertInt(int actualValue, int expectedValue)
    {
        try { assert (actualValue == expectedValue);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    //-------------------------------Verify the correctness of float value---------------
    public static void assertFloat(float actualValue, float expectedValue)
    {
        try { assert (actualValue == expectedValue);
        } catch (Exception e) {
            e.printStackTrace(); Assert.fail();
        }
    }
    //-------------------------------Verify the correctness of boolean value------------
    public static void assertBoolean(boolean actualValue, boolean expectedValue)
    {
        try { assert (actualValue == expectedValue);
        } catch (Exception e) {
            e.printStackTrace(); Assert.fail();
        }
    }
    //==================================Errors Assertions=================================
    //-------------------------------Verify Success Code 200------------------------------
    //-------------------------------Verify Not found 404 - 1001--------------------------
    //-------------------------------Verify Not found 404 - 1006--------------------------
    //-------------------------------Verify Unauthorized 401------------------------------
    //-------------------------------Verify Method Not Allowed 405------------------------
    //-------------------------------Unsupported Media Type 415---------------------------
    //----------------------------------Bad Request 400-----------------------------------
    //-------------------------------------Forbidden 403----------------------------------
    //-------------------------------Internal Server Error 500----------------------------

    public void assertUnauthorizedError(Response response) {
        String actualErrorMessage = JSONActions.getJSONResponseAsValue(response, errorCode_JsonPath);
        Assert.assertEquals(actualErrorMessage, unauthorized);
    }

    public void assertNotSupportedHTTTPMethodError(Response response) {
        String actualErrorMessage = JSONActions.getJSONResponseAsValue(response, errorCode_JsonPath);
        Assert.assertEquals(actualErrorMessage, unsupportedHTTPMethod);
    }

    public void assertInvalidInputParam(Response response) {
        String actualErrorMessage = JSONActions.getJSONResponseAsValue(response, errorCode_JsonPath);
        Assert.assertEquals(actualErrorMessage, invalidInputParam);
    }

    public void assertInvalidInputParam(Response response, String key, String expectedErrorMessage) {
        Map actualErrorMessage = JSONActions.getJSONResponseAsHashMap(response, error_JsonPath);
        Assert.assertTrue(actualErrorMessage.containsKey(key));
        HashMap error = (HashMap) actualErrorMessage.get(key);
        Assert.assertEquals(error.get(errorCode_JsonPath), expectedErrorMessage);
    }

    public void assertInvalidInputParam(Response response, String key, List<String> expectedErrorMessages) {
        Map actualErrorMessage = JSONActions.getJSONResponseAsHashMap(response, error_JsonPath);
        Assert.assertTrue(actualErrorMessage.containsKey(key));
        HashMap error = (HashMap) actualErrorMessage.get(key);
        Assert.assertTrue(error.get(errorCode_JsonPath).equals(expectedErrorMessages.get(0))
                || error.get(errorCode_JsonPath).equals(expectedErrorMessages.get(1)));
    }

    public void assertTypeMismatch(Response response) {
        String actualErrorMessage = JSONActions.getJSONResponseAsValue(response, errorCode_JsonPath);
        Assert.assertEquals(actualErrorMessage, typeMismatch);
    }

    public void assertMissingHeader(Response response) {
        String actualErrorMessage = JSONActions.getJSONResponseAsValue(response, errorCode_JsonPath);
        Assert.assertEquals(actualErrorMessage, missingHeader);
    }

    public void assertTokenExpired(Response response) {
        String actualErrorMessage = JSONActions.getJSONResponseAsValue(response, errorCode_JsonPath);
        Assert.assertEquals(actualErrorMessage, expiredToken);
    }

    public void assertChangeRequestExpired(Response response) {
        String actualErrorMessage = JSONActions.getJSONResponseAsValue(response, errorCode_JsonPath);
        Assert.assertEquals(actualErrorMessage, changeRequestExpired);
    }

    public void assertAuthUserNotExist(Response response) {
        String actualErrorMessage = JSONActions.getJSONResponseAsValue(response, errorCode_JsonPath);
        Assert.assertEquals(actualErrorMessage, authUserNotFound);
    }

    public void assertUserNotExist(Response response) {
        String actualErrorMessage = JSONActions.getJSONResponseAsValue(response, errorCode_JsonPath);
        Assert.assertEquals(actualErrorMessage, userNotFound);
    }

    public void assertChangeRequestNotFoundForUser(Response response) {
        String actualErrorMessage = JSONActions.getJSONResponseAsValue(response, errorCode_JsonPath);
        Assert.assertEquals(actualErrorMessage, changeRequestNotFoundForUser);
    }

    public void assertChangeRequestNotExist(Response response) {
        String actualErrorMessage = JSONActions.getJSONResponseAsValue(response, errorCode_JsonPath);
        Assert.assertEquals(actualErrorMessage, changeRequestNotFound);

    }

    public void assertChangeRequestCancelled(Response response) {
        String actualErrorMessage = JSONActions.getJSONResponseAsValue(response, errorCode_JsonPath);
        Assert.assertEquals(actualErrorMessage, changeRequestCancelled);
    }

    public void assertAuthorizationtForbidden(Response response) {
        String actualErrorMessage = JSONActions.getJSONResponseAsValue(response, errorCode_JsonPath);
        Assert.assertEquals(actualErrorMessage, authorizationForbidden);
    }

    public void assertAuthorizationtForbiddenCheckingHttpStatusAndCode(Response response) {
        String httpStatus = JSONActions.getJSONResponseAsValue(response, error_HttpStatus);
        Assert.assertEquals(httpStatus, Forbidden);
        String code = JSONActions.getJSONResponseAsValue(response, errorCode_JsonPath);
        Assert.assertEquals(code, authorizationForbidden);
    }
    public void assertAuthorizationtNotFoundCheckingHttpStatusAndCode(Response response) {
        String httpStatus = JSONActions.getJSONResponseAsValue(response, error_HttpStatus);
        Assert.assertEquals(httpStatus, notFoundValueOfHttpStatus);
        String code = JSONActions.getJSONResponseAsValue(response, errorCode_JsonPath);
        Assert.assertEquals(code, changeRequestNotFound);
    }
    public void assertAuthorizationtNotFoundForThisUserCheckingHttpStatusAndCode(Response response) {
        String httpStatus = JSONActions.getJSONResponseAsValue(response, error_HttpStatus);
        Assert.assertEquals(httpStatus, notFoundValueOfHttpStatus);
        String code = JSONActions.getJSONResponseAsValue(response, errorCode_JsonPath);
        Assert.assertEquals(code, changeRequestNotFoundForUser);
    }

    public void assertHttpMediaNotSupportedError(Response response) {
        String actualErrorMessage = JSONActions.getJSONResponseAsValue(response, errorCode_JsonPath);
        Assert.assertEquals(actualErrorMessage, httpMediaNotSupprted);
    }

    public void assertInvalidMessageFormat(Response response) {
        String actualErrorMessage = JSONActions.getJSONResponseAsValue(response, errorCode_JsonPath);
        Assert.assertEquals(actualErrorMessage, invalidMessageFormat);
    }
}
