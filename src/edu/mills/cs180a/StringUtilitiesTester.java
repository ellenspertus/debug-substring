package edu.mills.cs180a;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

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
        assertTrue(StringUtilities.isSubstring("", "bar"));
        assertTrue(StringUtilities.isSubstring("", ""));
    }

    @Test
    void isSubstring_True_Length1Substring() {
        assertTrue(StringUtilities.isSubstring("A", "ABC"));
    }

    @Test
    void isSubstring_False_Length1Substring() {
        assertFalse(StringUtilities.isSubstring("A", "DEF"));
    }

    @Test
    void isSubstring_True_Length3Substring() {
        assertTrue(StringUtilities.isSubstring("ABC", "DEF"));
    }

    @Test
    void getLength_True_Length6_4_9String() {
        assertTrue(StringUtilities.getLength("length") == 6);
        assertTrue(StringUtilities.getLength("size") == 4);
        assertTrue(StringUtilities.getLength("bigstring") == 9);
    }
}
