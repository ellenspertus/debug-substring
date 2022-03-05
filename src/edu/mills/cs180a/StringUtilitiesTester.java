package edu.mills.cs180a;

import static org.junit.jupiter.api.Assertions.assertFalse;
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

    @ParameterizedTest
    @CsvSource({"A, ABC", "B, ABC", "C, ABC", "D, D"})
    void isSubstringReturnsTrueForLengthOneSubstring(String substring, String text) {
        assertTrue(StringUtilities.isSubstring(substring, text));
    }

    @ParameterizedTest
    @CsvSource({"12, 57394712839", "$$$, GetMoney$$$$", "Abcd, Abcdefg"})
    void isSubstringReturnsTrueForVariedLengthSubstring(String substring, String text) {
        assertTrue(StringUtilities.isSubstring(substring, text));
    }

    @ParameterizedTest
    @CsvSource({"It was, It was the best", " ate , He ate the apple", " out., Let's go out."})
    void isSubstringReturnsTrueForSubstringsWithWhitespace(String substring, String text) {
        assertTrue(StringUtilities.isSubstring(substring, text));
    }

    @ParameterizedTest
    @CsvSource({"a, cde"})
    void isSubstringReturnsFalseForNoSubstring(String substring, String text) {
        assertFalse(StringUtilities.isSubstring(substring, text));
    }
}
