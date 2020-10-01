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

    @ParameterizedTest
    @CsvSource({"'',''", "'',foo"})
    void isSubstring_True_EmptySubString(String subString, String superString) {
        assertTrue(StringUtilities.isSubstring(subString, superString));
    }

    @Test
    void isSubstring_False_EmptySuperString() {
        assertFalse(StringUtilities.isSubstring("foo", ""));
    }

    @ParameterizedTest
    @CsvSource({"'',0", "A,1", "AB,2"})
    void getLength_CorrectLength_Strings(String input, int expected) {
        assertEquals(StringUtilities.getLength(input), expected);
    }

    @ParameterizedTest
    @CsvSource({"A,ABC", "B,ABC", "C,ABC"})
    void isSubstring_True_Length1Substring(String subString, String superString) {
        assertTrue(StringUtilities.isSubstring(subString, superString));
    }

    @ParameterizedTest
    @CsvSource({"AB,ABCD", "BC,ABCD", "CD,ABCD"})
    void isSubstring_True_Length2Substring(String subString, String superString) {
        assertTrue(StringUtilities.isSubstring(subString, superString));
    }

    @ParameterizedTest
    @CsvSource({"ABC,ABCD", "BCD,ABCD"})
    void isSubstring_True_Length3Substring(String subString, String superString) {
        assertTrue(StringUtilities.isSubstring(subString, superString));
    }

    @ParameterizedTest
    @CsvSource({"AB,A", "BC,C", "ABC,AB", "BCD,CD", "ABCDE,ABCD", "ABCDE,BCDE"})
    void isSubstring_False_SubLongerThanSuper(String subString, String superString) {
        assertFalse(StringUtilities.isSubstring(subString, superString));
    }
}
