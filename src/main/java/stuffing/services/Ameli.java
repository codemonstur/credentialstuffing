package stuffing.services;

import java.io.IOException;

import static httpclient.URLEncodedForm.newFormBody;
import static java.nio.charset.StandardCharsets.UTF_8;
import static stuffing.util.Utils.newHttpCall;

public class Ameli {

    public static void main(final String... args) throws IOException {
        login("test@test.com", "test");
    }
    public static boolean login(final String username, final String password) throws IOException {

        // Requests dies with a certificate validation error. But not the website in the browser. WTF
        // Code probably doesn't work. As usual the page contains a lot of junk.

        final var response = newHttpCall()
            .uri("https://ameliconnect.ameli.fr")
            .post("/oauth2/authorize")
            .body(newFormBody()
                .add("user", username)
                .add("password", password))
            .execute().response();

        System.out.println(response.statusCode());
        System.out.println(response.headers());
        System.out.println(new String(response.body()));


        return false;
    }

}
