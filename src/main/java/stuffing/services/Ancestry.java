package stuffing.services;

import java.io.IOException;

import static httpclient.URLEncodedForm.newFormBody;
import static java.nio.charset.StandardCharsets.UTF_8;
import static stuffing.util.Functions.escapeJson;
import static stuffing.util.Utils.newHttpCall;

public class Ancestry {

    // In addition to the extra hoops the site makes you jump through there was also an error when I tried
    // to login normally from the browser. Server died with a 500 Internal Sserver Error.

    public static void main(final String... args) throws IOException {
        login("test@test.com", "12345");
    }
    public static boolean login(final String username, final String password) throws IOException {

        // Getting a 403 when I directly post the request. There is a pre-authenticate call that looks like this:
        // https://www.ancestry.com
        // POST /account/signin/api/pre-authenticate
        // {"username":"test@test.com"}
        //
        // 200 OK
        // {
        //    "authFlow": "password",
        //    "sessionId": "254287b3-bf10-47db-813c-83a52ba5e77eehoqSNqS2nvbfQALjw0=",
        //    "algorithm": "sha256-mod-v1",
        //    "algorithmParameters": {
        //        "n": 400,
        //        "r": 0
        //    }
        //}
        // The preAuthToken in the follow up login request is a base64 encoded json blob that looks like this:
        // {"key":557,"session_id":"254287b3-bf10-47db-813c-83a52ba5e77eehoqSNqS2nvbfQALjw0=","solution_hash":"fcde384011a9bb32c4d085d347c67dd1f36ec535fb5f38f2c2e6f3aec431a720","solution_time_ms":32}

        final var response = newHttpCall()
            .uri("https://www.ancestry.com")
            .post("/account/signin/api/authenticate")
            .header("Content-Type", "application/json")
            .body("{\"username\":\"" + escapeJson(username) + "\",\"password\":\"" + escapeJson(password) + "\",\"preAuthToken\":\"\"}")
            .execute().response();

        System.out.println(response.statusCode());
        System.out.println(response.headers());
        System.out.println(new String(response.body()));

        return false;
    }

}
