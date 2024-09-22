package stuffing.services;

import java.io.IOException;

import static httpclient.URLEncodedForm.newFormBody;
import static java.nio.charset.StandardCharsets.UTF_8;
import static stuffing.util.Functions.escapeJson;
import static stuffing.util.Utils.newHttpCall;

public class Advanzia {

    public static void main(final String... args) throws IOException {
        login("test@test.com", "test");
    }
    public static boolean login(final String username, final String password) throws IOException {

        // page responds with a cookie not found error.

        final var response = newHttpCall()
            .uri("https://identity.omc.advanzia.com")
            .post("/auth/realms/advanzia-deu/login-actions/authenticate")
            .body(newFormBody()
                .add("username", username)
                .add("password", password)
                .add("login", "Anmelden"))
            .execute()
//                .verifyNotServerError()
//                .verifySuccess()
            .fetchBodyAsString(UTF_8);

        System.out.println(response);

        return false;
    }


}
