package edu.mills.cs180a;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    @CsvSource(value = {"A:ABC","B:ABC","C:ABC"}, delimiter = ':')
    void isSubstringReturnsTrueForLengthOneSubstring(String substring, String text) {
        assertTrue(StringUtilities.isSubstring(substring, text));
    }
    
    @ParameterizedTest
    @CsvSource(value = {"D:ABC","B:ABC","A:ABC", "E:ABC"}, delimiter = ':')
    void isSubstringReturnsFalseForLengthOneSubstring(String substring, String text) {
        assertFalse(StringUtilities.isSubstring(substring, text));
    }
    
    @ParameterizedTest
    @CsvSource(value = {"AB:ABC","BC:ABC","CD:ABCD"}, delimiter = ':')
    void isSubstringReturnsTrueForLengthTwoSubstring(String substring, String text) {
        assertTrue(StringUtilities.isSubstring(substring, text));
    }
    
    @ParameterizedTest
    @CsvSource(value = {"DE:ABC", "EF:ABCDE"}, delimiter = ':')
    void isSubstringReturnsFalseForLengthTwoSubstring(String substring, String text) {
        assertFalse(StringUtilities.isSubstring(substring, text));
    }
}
