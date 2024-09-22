package stuffing.services;

import java.io.IOException;

import static httpclient.URLEncodedForm.newFormBody;
import static java.nio.charset.StandardCharsets.UTF_8;
import static stuffing.util.Functions.escapeJson;
import static stuffing.util.Utils.newHttpCall;

public class Admiral {

    public static void main(final String... args) throws IOException {
        login("test@test.com", "test");
    }
    public static boolean login(final String username, final String password) throws IOException {

        final var response = newHttpCall()
            .uri("https://login.admiral.com")
            .post("/myaccount/login/api/authenticate")
            .header("Content-Type", "application/json")
            .body("{\"module\":\"UsernameAndPassword\",\"definition\":{\"rememberMe\":false,\"username\":\"" +
                    escapeJson(username) + "\",\"password\":\"" + escapeJson(password) + "\"}}")
            .execute()
            .fetchBodyAsString(UTF_8);

        return !"{\"code\":2001,\"message\":\"Invalid credentials\"}".equals(response);
    }

}
