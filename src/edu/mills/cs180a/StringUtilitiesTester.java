package edu.mills.cs180a;

import static org.junit.Assert.assertFalse;
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
    void isSubstring_False_EmptyString() {
        assertFalse(StringUtilities.isSubstring("foo", ""));
    }

    @Test
    void isSubstring_False_EmptySubstring() {
        assertFalse(StringUtilities.isSubstring("", "foo"));
    }

    @Test
    void isSubstring_True_Length1Substring() {
        assertTrue(StringUtilities.isSubstring("A", "ABC"));
    }

    @Test
    void isSubstring_True_LastLengthSubstring() {
        assertTrue(StringUtilities.isSubstring("A", "XYZA"));
    }

    @ParameterizedTest
    @CsvSource({"A, BAAA", "B, ZXCVB", "E, qwqwqwqwqwqwE", "F, asdFFF"})
    void isSubstring_True_ContainSingleSubstring(String substring, String Text) {
        assertTrue(StringUtilities.isSubstring(substring, Text));
    }

    @ParameterizedTest
    @CsvSource({"ZABC, ZABC", "ABC, ZABC", "BCEFG, ZABCEFGHIFK"})
    void isSubstring_True_ContainMultiSubstring(String substring, String Text) {
        assertTrue(StringUtilities.isSubstring(substring, Text));
    }

    @ParameterizedTest
    @CsvSource({"X, ZABC", "X, ZABC", "9, ZABC"})
    void isSubstring_False_NotContainSingleSubstring(String substring, String Text) {
        assertFalse(StringUtilities.isSubstring(substring, Text));
    }

    @ParameterizedTest
    @CsvSource({"XZ, ZABC", "ZX, ZABC", "CX, ZABC", "AC, ZABC"})
    void isSubstring_False_NotContain2Substring(String substring, String Text) {
        assertFalse(StringUtilities.isSubstring(substring, Text));
    }

    @ParameterizedTest
    @CsvSource({"ZABCDE, ZABC", "ABCD, ZABC", "BCEFG, ZABC"})
    void isSubstring_False_LargeSubstring(String substring, String Text) {
        assertFalse(StringUtilities.isSubstring(substring, Text));
    }
}
