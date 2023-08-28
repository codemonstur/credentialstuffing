package stuffing.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static java.net.http.HttpRequest.BodyPublishers.ofString;

// https://github.com/
public enum GitHub {;

    // There is an authenticity token in the login request. Will need to rewrite this to first retrieve that
    // before doing a login. Annoying. Response is not easy to parse, request returns a 200 OK for a failed
    // login. Lots of stupid security-by-obscurity.
    public static boolean login(final String username, final String password) throws IOException {
        final long now = System.currentTimeMillis();
        final var request = HttpRequest.newBuilder()
                .uri(URI.create("https://github.com/session"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .method("POST", ofString("login=" + username + "&password=" + password + "&timestamp=" + now))
                .build();
        return false;
//        try {
//            final var response = HTTP_CLIENT.send(request, BodyHandlers.ofString());
//            return JsonPath.read(response.body(), "$....");
//        } catch (InterruptedException e) {
//            throw new IOException(e);
//        }
    }

}
