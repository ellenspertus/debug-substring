package edu.mills.cs180a;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class StringUtilitiesTester {
    @Test
    void isSubstringThrowsExceptionForNullArg() {
        assertThrows(NullPointerException.class, () -> StringUtilities.isSubstring(null, "foo"));
        assertThrows(NullPointerException.class, () -> StringUtilities.isSubstring("foo", null));
        assertThrows(NullPointerException.class, () -> StringUtilities.isSubstring(null, null));
    }

    @Test
    void isSubstringReturnsTrueForEmptySubstring() {
        assertTrue(StringUtilities.isSubstring("", "foo"));
    }

    @Test
    void isSubstringReturnsFalseForEmptyString() {
        assertFalse(StringUtilities.isSubstring("foo", ""));
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "B", "C", " "})
    void isSubstringReturnsTrueForLengthOneSubstring(String substr) {
        assertTrue(StringUtilities.isSubstring(substr, "ABC "));
    }

    @ParameterizedTest
    @CsvSource({"race, racecar", "ke ice, I like ice cream", "!9550nfkf, 11111hhello!9550nfkf",
            "foo, foo"})
    void isSubstringReturnsTrueForValidSubstring(String substr, String str) {
        assertTrue(StringUtilities.isSubstring(substr, str));
    }

    @ParameterizedTest
    @CsvSource({"lightning mcgee, racecar", "ke icE, I like ice cream",
            "!9550nfkfr, 11111hhello!9550nfkf"})
    void isSubstringReturnsFalseForInvalidSubstring(String substr, String str) {
        assertFalse(StringUtilities.isSubstring(substr, str));
    }
}
