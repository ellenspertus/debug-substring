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
        assertFalse(StringUtilities.isSubstring(" ", "foo"));
    }

    @ParameterizedTest
    @CsvSource(value = {"A:ABC", "a:ABC ","b:ABC ","B:ABC","c:ABC","C:ABC"}, delimiter = ':')
    void isSubstringReturnsTrueForLengthOneSubstring(String substring, String text) {
        assertTrue(StringUtilities.isSubstring("A", "ABC"));
        // TODO: write rest
    }
}
