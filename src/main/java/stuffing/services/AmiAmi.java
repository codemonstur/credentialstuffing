package stuffing.services;

import java.io.IOException;

import static httpclient.URLEncodedForm.newFormBody;
import static java.nio.charset.StandardCharsets.UTF_8;
import static stuffing.util.Functions.escapeJson;
import static stuffing.util.Utils.newHttpCall;

public class AmiAmi {

    // The below username and password are correct. I only wanted to test the page but accidentally logged in.
    // Its only a test account but still kinda ugly. In their defense; their website is pretty clean and doesn't
    // have all this bullshit that other pages have.

    public static void main(final String... args) throws IOException {
        login("test@test.com", "123456");
    }

    private record LoginResponse(boolean RSuccess, String RMessage) {}

    public static boolean login(final String username, final String password) throws IOException {

        final var response = newHttpCall()
            .uri("https://api-secure.amiami.com")
            .post("/api/v1.0/login")
            .header("Content-Type", "application/json;charset=UTF-8")
            .header("Referer", "https://secure.amiami.com/")
            .header("X-User-Key", "amiami_dev")
            .body("{\"lang\":\"eng\",\"email\":\"" + escapeJson(username) + "\",\"password\":\"" + escapeJson(password) + "\",\"c_ransu\":null}")
            .execute()
            .fetchBodyInto(LoginResponse.class);

        return response.RSuccess;
    }

}
