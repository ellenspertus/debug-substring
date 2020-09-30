package edu.mills.cs180a;

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
    void isSubstring_False_EmptyString() {
        assertTrue(StringUtilities.isSubstring("", "foo"));
        // TODO: write rest
    }

    @Test
    void isSubstring_True_Length1Substring() {
        assertTrue(StringUtilities.isSubstring("A", "ABC"));
    }

    @ParameterizedTest
    @CsvSource({"AB, ABC", "BC, ABC"})
    void isSubstring_True_Length2Substring(String substring, String text) {
        assertTrue(StringUtilities.isSubstring(substring, text));
    }

    @ParameterizedTest
    @CsvSource({"ABD", "BDE", "ED"})
    void isSubstring_False_SubstringOutOfSequence(String substring)
    {
        String line = "ABCDEFG";

        assertFalse(StringUtilities.isSubstring(substring, line));
    }

    @ParameterizedTest
    @CsvSource({"She","Seashore","y T", "ells", "he S"})
    void isSubstring_True_SentenceWithSpaces(String substring)
    {
        String sentence = "She Sells Sea Shells By The Seashore";
        assertTrue(StringUtilities.isSubstring(substring, sentence));
    }

    @ParameterizedTest
    @CsvSource({"She","Seashore","yT", "ells", "heS"})
    void isSubstring_True_SentenceNoSpaces(String substring)
    {
        String sentence = "SheSellsSeaShellsByTheSeashore";
        assertTrue(StringUtilities.isSubstring(substring, sentence));
    }

    @ParameterizedTest
    @CsvSource({"ABC","CDE","ACE","BD"})
    void isSubstring_True_MultipleSequences(String substring)
    {
        String line = "ABCDEACEBD";
        assertTrue(StringUtilities.isSubstring(substring,line));
    }

    @ParameterizedTest
    @CsvSource({"DEF,ABCDE","lies,charlie","bells,jingle bell","lands, island"})
    void isSubstring_False_SubtringExtraChar(String substring, String text)
    {
        assertFalse(StringUtilities.isSubstring(substring, text));
    }

    @ParameterizedTest
    @CsvSource({"ABCD,ABC","Charlies,Charlie","islands,island"})
    void isSubstring_False_SubstringLargerThanText(String substring, String text)
    {
        assertFalse(StringUtilities.isSubstring(substring, text));
    }

    @ParameterizedTest
    @CsvSource({"she", "seashore", "y t", "ellS", "Hes"})
    void isSubtring_False_CaseSensitive(String substring)
    {
        String sentence = "She Sells Sea Shells By The Seashore";
        assertFalse(StringUtilities.isSubstring(substring, sentence));
    }
}
