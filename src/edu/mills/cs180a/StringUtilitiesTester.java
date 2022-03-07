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
    @CsvSource({"A,ABC", "m,Camel", "Z ,XYZ", "S,Ss"})
    void isSubstringReturnsTrueForLengthOneSubstring(String substring, String text) {
        boolean actual = StringUtilities.isSubstring(substring, text);
        assertTrue(actual);
    }

    @CsvSource({"AB,ABC", "mel,Camel", "bee.,applebee.", "SSSSSSSSSS,SSSSS"})
    void isSubstringReturnsTrueForLengthAnySubstring(String substring, String text) {
        boolean actual = StringUtilities.isSubstring(substring, text);
        assertTrue(actual);
    }

    @ParameterizedTest
    @CsvSource({"ABCD,ABC", "Camels,Camel", "YZZ,XYZ", "al Characters,Special Character"})
    void isSubstringReturnsFalseForLongerSubstring(String substring, String text) {
        boolean actual = StringUtilities.isSubstring(substring, text);
        assertFalse(actual);
    }

    @Test
    void isSubstringReturnsTrueForEscapeSubstring() {
        boolean actual =
                StringUtilities.isSubstring("Jane", "Jane Campion directed \"The Piano\" in 1993.");
        assertTrue(actual);
    }

    @ParameterizedTest
    @CsvSource({"w is M, Yes tomorrow is Monday.", "7,7 8675654567887767567"})
    void isSubstringReturnsTrueForLongSubstring(String substring, String text) {
        boolean actual = StringUtilities.isSubstring(substring, text);
        assertTrue(actual);
    }

    @ParameterizedTest
    @CsvSource({"https://mail.gmail.com/mail/u/0/#inbox, https://gmail.com"})
    void isSubstringReturnsFalseForUrlSubstring(String substring, String text) {
        boolean actual = StringUtilities.isSubstring(substring, text);
        assertFalse(actual);
    }

    @Test
    void isSubstringReturnsTrueForWhiteSpace() {
        boolean actual = StringUtilities.isSubstring(" ", "This is an object");
        assertTrue(actual);
    }

}
