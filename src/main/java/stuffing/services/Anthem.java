package stuffing.services;

import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;
import static stuffing.util.Functions.escapeJson;
import static stuffing.util.Utils.newHttpCall;

public class Anthem {

    public static void main(final String... args) throws IOException {
        login("test@test.com", "test");
    }

    private record LoginResponse(boolean authenticated, String authErr, String smAuthReason, String code) {}
    public static boolean login(final String username, final String password) throws IOException {

        // This will probably fail at some point. When the cookie stops being valid.

        final var response = newHttpCall()
            .uri("https://www.anthem.com")
            .post("/member/public/api/tcp/webaccount/v2/login")
            .header("Content-Type", "application/json")
            .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 Safari/537.36")
            .header("Cookie", "TLTSID=e50f8033-4929-d3ae-0d1c-178b76cbd271; ak_bmsc=045877253D0E478A38B3EDDE92884FB5~000000000000000000000000000000~YAAQk0d7XL4QGOGRAQAAt1VCGhmepGCB10MlTYUOl4DppMq54ExPv5fX2SLkvkF9GIhT9Gf4f01kgQXrVh0GOaAmiFcCbtYHWA7vh3VcHZQyPpUUvcq3FnJqbyd2Mv4lKioqd4ntvT1EHUXCE6Bw3vqPn3UE+fnOY51zBGsLANxJvnhCrE1Fx3PwWQ5U3jHvWyGoFUMgL6VtS8rnPoVYt/mTn/nOycwo1PW0DiIC4eZId/1Tw/vq/t2+SDi/8z5f/2ePVBFbDtSSxjdUbo/OChHKUjWeqeU8/loJGjK33w1/lKL4Blk+otqTlmiif+hX5Q9NDCML4R4TGN01P7SZRIloVKUqKeF665vTXXTzHUcDydXd1vdz/oQfgKn3GDegElFq9/AXffmsdw==; PIM-SESSION-ID=gY4LkeDAI8n1ard9; at_check=true; referrer-type=direct; AMCVS_95CF659E533DE4C90A490D4D%40AdobeOrg=1; _abck=F8BD1F57A4399BD101CADDE3170764B9~0~YAAQk0d7XPsQGOGRAQAAF1pCGgynnmF7HGcj3YenUBxNkB5eFqZcaHZvlY4y+0och8Nsxpzs++U2Iivbs0I5wVYgvVdPh3oRPmvslFhCKz+fH2Ae3xrtc52CktnhPnmZFjdCBLYL2twnCq48HjbPh32LEWMKawPBmJ6imWoHyL+WiPwWn/76SquAXFqQReTA9RCxfzPI0p22Yj9Kw+WA+V4nKV1k/jxNFLKKAKI34KLbZNQ44NRHXCpk42fsCykgDpixvJ0fPRPIIkfg2igNCSqw2AANvI9QRFg1oiJNfHAe2HAYCpf05eAuB2BZNjwnkoa9/wXpSG3UztU/EbTJQ11eu/rQAAQCvK9MCKHWwT7V6d34feyqMutXsW7xc62YXET/pQCYLIJ4tLrhu7Ke4Tre4H1zwvr4/L77e0wpyuVTRx0j9uq8BAcqKrxyNWHHRzHg0OsnXJ0R~-1~||0||~-1; mdLogger=false; kampyle_userid=e17b-7bf1-1a2a-2976-9678-c7bb-b2e3-374e; kampyleUserSession=1727017409988; kampyleUserSessionsCount=1; JSESSIONID=LfoaQmK5NreO9V1PPTwL1D42IBWE2ykx66QHQvrFqr2ejvbLGF8E!-134804549; bm_mi=1683198AF6620DE954E5CE8F5664E0A2~YAAQk0d7XEURGOGRAQAAW2NCGhmBXUQ9uZQpqFgvLpb4ZgQoswCBK9e/NYvUg7GL+NgD8maFyyKwVptdsXnvezFjpUot8VUiSzm1Tido2ez7/L5KlkIJ7myj18LaTSy+RA8/lDUJDufbruNkA/Eg/KdqBf+fLuiEry85fkX8VzRrhSpR7c5yDRzsh19TYcz/Em8gfGyX209Q4pR5puuRFPj0C3sz63B+lsdo8EvP6wiIZByPrU9v0L6r/2NuPvudZalSjOaQNIPf+KoKClISkltIGPYhd0NIAwcBAtiN2a09PLeJwVwk/IZA52zvxtB1VOLri7wjlk7f4f77~1; mbox=session#77961b7dc71441998fa5d81c6abc19f0#1727019273|PC#77961b7dc71441998fa5d81c6abc19f0.37_0#1790262213; AKA_A2=A; AMCV_95CF659E533DE4C90A490D4D%40AdobeOrg=179643557%7CMCIDTS%7C19989%7CMCMID%7C28690487444495201504715597599860969758%7CMCAID%7CNONE%7CMCOPTOUT-1727024614s%7CNONE%7CvVersion%7C5.5.0; target=; criteria=; dplid=; kampyleSessionPageCounter=3; AWSALB=WpZltUimLPPq5Eb2qD1vLtdk2tF1aGzzmdspFK96yfNGTQGyJOWt6yh4g+zvj24PGYTHSMlYQD82RjCQZ2/OTN4cUbqO4/PP7TTdXPUuBtyiRHHaS5IWrM4kXnlC; AWSALBCORS=WpZltUimLPPq5Eb2qD1vLtdk2tF1aGzzmdspFK96yfNGTQGyJOWt6yh4g+zvj24PGYTHSMlYQD82RjCQZ2/OTN4cUbqO4/PP7TTdXPUuBtyiRHHaS5IWrM4kXnlC; bm_sz=1E7F35AAEEBB78C3FE88D636CDAEB497~YAAQk0d7XBESGOGRAQAA0nxCGhm1u8zmOQvdnBxBofjBK2Gbu6WYxFK6Em8eI90cKUbAlwGatKAEQoXYumCYJK7CnRI8VvCCnDxYMStmJOsmYFm7qhTI8Uy0opNUehIrHRpsKR063WXFkt286I293/puL8P9p0YE0hnaNNiFv0BhkNGqWSBlE0m7IE0EkStlDZg+zErT5MPIsjPrZFR82Cb8XiTQ497q1IftBqdoIvR3+MPP98zgQywNxO+azq98F8YRmuKoHejdcIoL240hZAC6WAunOLS7RwVlILSeWYDTUAPxyxmAG33b8AKzXcvbqWtdQyiXWGWMkF9fYdnQksAjY0fyeO/zZZAMgNwbVk5Dm5w7YcDb1rP0c2r95mmslzzo1Yz4X+NcbHlLJbyT4HCsEn9Nxv1Agp+f/DE=~3487799~3683889; bm_sv=6C042F83E45B505EEB823C73423EC0CE~YAAQk0d7XC4UGOGRAQAAHq5CGhlsw8uj21mmT0myrhWlkCpaJer+4RXJMZyZlqggwbLqGyimINgKOV49FQIfd8iEYfssPMryaBwbZbaoUzpglEJWub229pXvgvfozj4CUVV4APedvYRvRahb8yyllxb+05DljMBxlw/rn5xodG8s2GSSaXkVu2ibk+8kaWfdTSmmKLHwbcvwzDIAy8559pBprb9hAdj2wps+FrIZjFmD2S/xHtPaGOCyUwVFN+3N~1")
            .body("{\"usernm\":\"" + escapeJson(username) + "\",\"password\":\"" + escapeJson(password) + "\",\"brand\":\"ABCBS\",\"fingerprint\":\"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 Safari/537.36\",\"dplid\":\"\",\"proxyId\":null}")
            .execute()
            .fetchBodyInto(LoginResponse.class);

        return response.authenticated;
    }

}
