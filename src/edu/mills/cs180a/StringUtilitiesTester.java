package edu.mills.cs180a;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        // TODO: write rest
        assertTrue(StringUtilities.isSubstring("B", "CBB"));
        assertTrue(StringUtilities.isSubstring("C", "MJCK"));
        assertTrue(StringUtilities.isSubstring("AG", "ZAGF"));
    }

    @ParameterizedTest
    @CsvSource({"A, ADR", "S, WQSRT", "A, QasE"})
    void paramisSubstring(String input, String str) {
        assertEquals(true, StringUtilities.isSubstring(input, str));
    }
}
