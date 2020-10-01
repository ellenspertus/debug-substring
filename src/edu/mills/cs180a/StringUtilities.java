package edu.mills.cs180a;

import java.util.Objects;

/**
 * Static utility class for testing whether a string is a substring of another string.
 */
public class StringUtilities {
    private StringUtilities() {}

    /**
     * Tests whether the potential substring is in the full string. The empty string is considered a
     * substring of every full string.
     *
     * @param substring the potential substring
     * @param text the full string
     * @return true if the substring is contained in the full string, false otherwise
     * @throws NullPointerException if either argument is null
     */
    public static boolean isSubstring(String substring, String text) {
        Objects.requireNonNull(substring);
        Objects.requireNonNull(text);

        if (substring.isEmpty()) {
            return true;
        }

        for (int i = 0; i < text.length(); i++) {
            // Check if current character of the full string matches start of substring.
            if (text.charAt(i) == substring.charAt(0)) {
                if (isSubstringHelper(substring, text, i)) {
                    // If so, see if the rest of the strings match.
                    return true;
                }
            }
            // If not, keep iterating through the full string.
        }
        return false;
    }

    // check if substring appears at the given offset in text
    private static boolean isSubstringHelper(String substring, String text, int offset) {
        // i is used as an index for substring, offset is used for text
        for (int i = 0; // The character with index 0 has already been tested.
                i < substring.length() && offset < text.length(); i++, offset++) {
            if (text.charAt(offset) != substring.charAt(i) || text.length() < substring.length()) {
                return false;
            }
        }
        return true;
    }

    protected static int getLength(String s) {
        return s.length();
    }
}
