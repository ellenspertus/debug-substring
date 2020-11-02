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

    @ParameterizedTest
    @CsvSource({"'',''", "'',' '", "'','   '", "'',XYZ", "'',X Z", "'', XYZ", "'',XYZ "})
    void isSubstring_True_EmptyString(String emptySubstring, String text) {
        assertTrue(StringUtilities.isSubstring(emptySubstring, text));
    }

    @ParameterizedTest
    @CsvSource({"' ',' '", "' ','   '", "' ','x z'", "' ','xyz '", "' ',' xyz'", "x,xyz", "y,xyz",
            "z,xyz"})
    void isSubstring_True_Length1Substring(String substring, String text) {
        assertTrue(StringUtilities.isSubstring(substring, text));
    }

    @ParameterizedTest
    @CsvSource({"' ',''", "X,xyz", "x,XYZ", "x,''", "a,xyz"})
    void isSubstring_False_Length1Substring(String substring, String text) {
        assertFalse(StringUtilities.isSubstring(substring, text));
    }

    @ParameterizedTest
    @CsvSource({"'  ','  '", "'  ','   '", "xy,xyz", "yz,xyz", "ab, ab", "AB,AB"})
    void isSubstring_True_Length2Substring(String substring, String text) {
        assertTrue(StringUtilities.isSubstring(substring, text));
    }

    @ParameterizedTest
    @CsvSource({"'  ',''", "'  ',' '", "xz,xyz", "Xy,xyz", "xY,xyz", "XY,xyz", "xy,XYZ",
            "ba,ab", "ab,AB", "ab,a"})
    void isSubstring_False_Length2Substring(String substring, String text) {
        assertFalse(StringUtilities.isSubstring(substring, text));
    }

    @ParameterizedTest
    @CsvSource({"'   ','   '", "xyz,xyz", "xyz,' xyz '", "XYZ,XYZ"})
    void isSubstring_True_Length3Substring(String substring, String text) {
        assertTrue(StringUtilities.isSubstring(substring, text));
    }

    @ParameterizedTest
    @CsvSource({"'   ',''", "'   ',' '", "'   ','  '", "yzx,xyz", "Xyz,xyz", "xYz,xyz", "XYZ,xyz",
            "xyz,XYZ", "XyZ,xYz", "xyZ,xyz"})
    void isSubstring_False_Length3Substring(String substring, String text) {
        assertFalse(StringUtilities.isSubstring(substring, text));
    }
}
