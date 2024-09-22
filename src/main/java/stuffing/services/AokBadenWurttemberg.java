package stuffing.services;

import java.io.IOException;

import static httpclient.URLEncodedForm.newFormBody;
import static java.nio.charset.StandardCharsets.UTF_8;
import static stuffing.util.Functions.escapeJson;
import static stuffing.util.Utils.newHttpCall;

public class AokBadenWurttemberg {

    public static void main(final String... args) throws IOException {
        login("test", "test");
    }

    public static boolean login(final String username, final String password) throws IOException {

        // Page uses a multi stage login page where you must first select the type of bank which is probably
        // stored inside some form of session using cookies.
        // There is also a very weird CSRF token in various places. What a mess.

        final var response = newHttpCall()
            .uri("https://bw-login.meine.aok.de")
            .post("/ext/smart/authentication/ajax")
            .header("Content-Type", "application/json")
            .body("{\"_csrf\":\"\",\"LoginForm\":{\"username\":\"" + escapeJson(username) + "\",\"password\":\"" + escapeJson(password) + "\"}}")
            .execute().response();

//                .verifyNotServerError()
//                .verifySuccess()
//            .fetchBodyAsString(UTF_8);

        System.out.println(response.statusCode());
        System.out.println(response.headers());
        System.out.println(new String(response.body()));

        return false;

    }

}
