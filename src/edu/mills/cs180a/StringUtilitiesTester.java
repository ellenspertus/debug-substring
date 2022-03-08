package edu.mills.cs180a;

import static edu.mills.cs180a.StringUtilities.isSubstring;
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

    @Test
    void isEmptyStringReturnsFalseForAnySubString() {
        assertFalse(StringUtilities.isSubstring("foo", ""));
    }

    @Test
    void isSubstringReturnsTrueForLengthOneSubstring() {
        assertTrue(StringUtilities.isSubstring("A", "ABC"));
        // TODO: write rest
    }

    @ParameterizedTest
    @CsvSource({"A,ABC", "B,ABC", "C,ABC", "ABC, ABC", "AB,ABC", "BC,ABC", "ABC,ABC"})
    void testSubstrings(String inputString, String expectedValue) {
        assertTrue(isSubstring(inputString, expectedValue));
        // tests If all letters of ABC are accepted individually as substring or do they all need to
        // start or end the same to pass?
    }

    @ParameterizedTest
    @CsvSource({"ABCA,ABC", "ABAB,B", "BABA,BA"})
    void testSubstringsThatAreBiggerInLength(String inputString, String expectedValue) {
        assertFalse(isSubstring(inputString, expectedValue));
        // tests If all letters of ABC are accepted individually as substring or do they all need to
        // start or end the same to pass?
    }

    @ParameterizedTest
    @CsvSource({"A,ABCD", "B,ABCD", "C,ABCD", "D, ABCD", "AB,ABCD", "BC,ABCD", "CD,ABCD",
            "ABC,ABCD", "BCD,ABCD", "ABCD,ABCD"})
    void testStringsOfLengths(String inputString, String expectedValue) {
        assertTrue(isSubstring(inputString, expectedValue));
        // tests If all letters of ABC are accepted individually as substring or do they all need to
        // start or end the same to pass?
    }

    @ParameterizedTest
    @CsvSource({"A,BAA", "B,ABBB", "C,CCCDC", "D, ABDCD", "AB,CDAB", "BC,BCBC"})
    void testStringsWithDoublePatterns(String inputString, String expectedValue) {
        assertTrue(isSubstring(inputString, expectedValue));
    }

    @ParameterizedTest
    @CsvSource({"A,AAAAAAAAAA", "B,AAAAAAAAAAAAAAAB", "C,CCCCCCCCC", "D, ABDCDDDDDDDDD",
            "AB,CDABABABABAB", "BC,BCBCCBCBCBB"})
    void testStringsWithSamePattern(String inputString, String expectedValue) {
        assertTrue(isSubstring(inputString, expectedValue));
    }

}
