package stuffing.services;

import java.io.IOException;

import static httpclient.URLEncodedForm.newFormBody;
import static java.nio.charset.StandardCharsets.UTF_8;
import static stuffing.util.Utils.newHttpCall;

public class Apec {

    public static void main(final String... args) throws IOException {
        login("test@test.com", "test");
    }

    // website appears to allow username discovery. It returns an error saying "{"account":"unknown_user"}"
    // what would it give back if it wasn't an unknown account?

    public static boolean login(final String username, final String password) throws IOException {

        // code returns an error message when executed. I suspect that it wants some form of session to
        // exist before logging in. There are a bunch of cookies that get set. Otherwise this looks like
        // the first page that isn't truely horrible, despite all the security vulnerabilities.

        final var response = newHttpCall()
            .uri("https://www.apec.fr")
            .post("/.apec-login.do")
            .body(newFormBody()
                .add("source", "loginApec")
                .add("username", username)
                .add("password", password))
            .execute()
            .fetchBodyAsString(UTF_8);

        System.out.println(response);

        return false;

    }

}
