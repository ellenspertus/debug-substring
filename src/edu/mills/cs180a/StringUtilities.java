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
                // if substring is only one char no need to check further
                if (substring.length() == 1) {
                    return true;
                }
                // Otherwise, see if the rest of the strings match.
                if (isSubstringHelper(substring, text, i + 1)) {
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
        if (offset < text.length()) {
            // The character with index 0 has already been tested.
            for (int i = 1; i < substring.length() && offset < text.length(); i++, offset++) {
                if (text.charAt(offset) != substring.charAt(i)) {
                    return false;
                }
                if (offset + 1 == text.length() && i + 1 != substring.length()) {
                    // need to check if we are at the end of the text but not at end of substring
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    protected static int getLength(String s) {
        return s.length();
    }
}
