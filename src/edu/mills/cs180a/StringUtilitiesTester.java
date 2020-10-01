package edu.mills.cs180a;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringUtilitiesTester {

    @Test
    void isSubstring_False_null() {
        assertThrows(NullPointerException.class, () -> StringUtilities.isSubstring(null, "foo"));
        assertThrows(NullPointerException.class, () -> StringUtilities.isSubstring("foo", null));
        assertThrows(NullPointerException.class, () -> StringUtilities.isSubstring(null, null));
    }

    @Test
    void isSubstring_True_EmptyString() {
        assertTrue(StringUtilities.isSubstring("", "foo"));
    }

    @ParameterizedTest
    @CsvSource(value = {"A, ABC", "BC, ABCDE", "ABCD, ABCD", "D, ABCD", "A, A"})
    void isSubstring_True_ValidSubstring(String substring, String text) {
        assertTrue(StringUtilities.isSubstring(substring, text));
    }

    @ParameterizedTest
    @CsvSource(value = {"Z, ABC", "ABD, ABC", "ABC, FBC", "CBC, ABC"})
    void isSubstring_False_InvalidSubstring(String substring, String text) {
        assertFalse(StringUtilities.isSubstring(substring, text));
    }

    @Test
    void isSubstring_False_SubstringMatchesEndButIsLonger() {
        assertFalse(StringUtilities.isSubstring("BCD", "ABC"));
    }

    @Test
    void getLength_returnsLength_ValidString() {
        assertEquals(6, StringUtilities.getLength("String"));
    }
}
