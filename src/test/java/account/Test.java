package account;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static account.Utils.GSON;
import static account.Utils.newHttpCall;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Test {

    private static final String
            URL_ACCOUNT_DETECTION = "https://raw.githubusercontent.com/WebBreacher/WhatsMyName/main/wmn-data.json";

    record Sites(List<String> license, List<String> authors, List<String> categories, List<Site> sites) {}
    record Site(String name, String uri_check, int e_code, String e_string, String m_string, int m_code, List<String> known, String cat, boolean valid) {}

    public static void main(final String... args) throws IOException {
        final var response = newHttpCall()
            .uri(URL_ACCOUNT_DETECTION).get()
            .execute()
            .verifyNotServerError()
            .verifySuccess()
            .fetchBodyAsString(UTF_8);

        final var sites = GSON.fromJson(response, Sites.class);
        for (final var site : sites.sites) {
            System.out.println(site.name);
        }
    }

}
