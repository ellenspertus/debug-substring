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

        if (substring.isEmpty() || text.isEmpty()) {
            return false;
        }

        for (int i = 0; i < text.length(); i++) {
            // Check current character of the full string matches start of substring.
            if (text.charAt(i) == substring.charAt(0)) {
                // Check the rest of the strings matches substring without first character.
                if (isSubstringHelper(substring, text, i + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isSubstringHelper(String substring, String text, int offset) {
        // Return false if length of substring is greater than length of rest of text.
        if ((substring.length() - 1) > (text.length() - offset))
            return false;

        // check substring appears at the given offset in text.
        for (int i = 1; i < substring.length(); i++, offset++) {
            if (text.charAt(offset) != substring.charAt(i))
                return false;
        }
        return true;
    }
}
