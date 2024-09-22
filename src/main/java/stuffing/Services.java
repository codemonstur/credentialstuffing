package stuffing;

import stuffing.services.*;

import java.io.IOException;
import java.util.List;

public enum Services {;

    public interface Service {
        boolean login(String username, String password) throws IOException;
    }

    // Only ones that work right now. All sites should be possible to implement in theory. In practice it can
    // be quite some work because these sites have so much garbage and obfuscation in them. I've done what I felt
    // like doing so far. Feel free to help out implementing more.
    public static List<Service> services() {
        return List.of(Admiral::login, AirAsia::login, AmiAmi::login, Anthem::login);
    }

}
