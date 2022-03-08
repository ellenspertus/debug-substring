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

    @Test
    void isSubstringReturnsTrueForLengthOneSubstring() {
        assertTrue(StringUtilities.isSubstring("A", "ABC"));
    }

    @ParameterizedTest
    @CsvSource({"AB, ABC", "XY, XYZ",})
    void isSubstringReturnsTrueForLengthTwoSubstring(String subString, String string) {
        assertTrue(StringUtilities.isSubstring(subString, string));
    }

    @Test
    void isSubstringReturnsTrueForSubstringAnyLength() {
        assertTrue(StringUtilities.isSubstring("Dave", "Dave"));
    }

    @Test
    void isSubstringReturnsFalseForSubstringAnyLength() {
        assertFalse(StringUtilities.isSubstring("Dave", "Davi"));
    }

    @Test
    void isSubstringReturnsTrueForSubstringNotFirstLetter() {
        assertTrue(StringUtilities.isSubstring("hair", "chair"));
    }

    @Test
    void isSubstringReturnsFalseForSubstringLongerThanString() {
        assertFalse(StringUtilities.isSubstring("bobcat", "bob"));
        assertFalse(StringUtilities.isSubstring("chant", "ant"));
    }

}
