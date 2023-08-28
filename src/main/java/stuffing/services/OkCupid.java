package stuffing.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpRequest.BodyPublishers.ofString;
import static stuffing.util.Functions.escapeJson;

public class OkCupid {

    public static final String REQUEST_BODY = """
            {"operationName":"authUserLoginWithEmail","variables":{"input":
            {"email":"%s","password":"%s","deviceId":"6613ed6dfd84173d","forceCaptcha":false,"recaptchaResponse":null,"authCode":""}},
            "query":"mutation authUserLoginWithEmail($input: AuthUserLoginWithEmailInput!) {\\n  authUserLoginWithEmail(input: $input) {\\n    userid\\n    statusCode\\n    reenableAuthCode\\n    reenableUserid\\n    onboardingIncomplete\\n    __typename\\n  }\\n}"}""";

    public static boolean login(final HttpClient httpClient, final String username, final String password) throws IOException {
        final long now = System.currentTimeMillis();
        final var request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.okcupid.com/graphql?operationName=authUserLoginWithEmail"))
                .header("Content-Type", "application/json; charset=utf-8")
                .method("POST", ofString(String.format(REQUEST_BODY, escapeJson(username), escapeJson(password), null)))
                .build();
        try {
            final var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return false;

//            return JsonPath.read(response.body(), "$....");
        } catch (InterruptedException e) {
            throw new IOException(e);
        }
    }

    private static String randomDeviceId() {
        return null;
    }
}
