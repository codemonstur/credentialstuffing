package stuffing.util;

import java.text.StringCharacterIterator;

import static java.text.CharacterIterator.DONE;

public enum Functions {;

    public static String escapeJson(final String input) {
        if (input == null) return "";

        final var ret = new StringBuilder();
        final var iterator = new StringCharacterIterator(input);
        for (char c = iterator.current(); c != DONE; c = iterator.next()) {
            ret.append(switch (c) {
                case '\"' -> "\\\"";
                case '\t' -> "\\t";
                case '\f' -> "\\f";
                case '\n' -> "\\n";
                case '\r' -> "\\r";
                case '\\' -> "\\\\";
                case '/' -> "\\/";
                case '\b' -> "\\b";
                default -> c;
            });
        }

        return ret.toString();
    }

    private static final char[] hex_array = "0123456789abcdef".toCharArray();
    public static String encodeHex(final byte[] bytes) {
        final char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hex_array[v >>> 4];
            hexChars[j * 2 + 1] = hex_array[v & 0x0F];
        }
        return new String(hexChars);
    }

}
