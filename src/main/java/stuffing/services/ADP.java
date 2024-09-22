package stuffing.services;

import java.io.IOException;

import static httpclient.URLEncodedForm.newFormBody;
import static java.nio.charset.StandardCharsets.UTF_8;
import static stuffing.util.Utils.newHttpCall;

public class ADP {

    public static boolean login(final String username, final String password) throws IOException {

        // site sends usernames and passwords over multiple requests and with a bunch of cookies and stuff

        final var response = newHttpCall()
                .uri("https://online.emea.adp.com")
                .post("/api/sign-in-service/v1/sign-in.challenge.respond")
                .header("Content-Type", "application/json")
                .body("")
                .execute()
//                .verifyNotServerError()
//                .verifySuccess()
                .fetchBodyAsString(UTF_8);

        return false;

    }

}
