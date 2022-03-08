package edu.mills.cs180a;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
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
    @CsvSource({"AQ, AQSRT", "ST, AFGSTAG","HXB, KXMDCBUHXB", "ABC, ABC"}) 
    void isSubstringReturnsTrueForLengthTwoAndHigherSubstring(String substring, String text) {
        assertTrue(StringUtilities.isSubstring(substring, text));
    }
    
    @ParameterizedTest
    @CsvSource({"ST, AQSRT", "EQ, GEHSVQ", "ABCDEF, ABC"})
    //fails: ABCDEF, ABC expected false, but returns true
    void isSubstringReturnsFalseForLengthTwoAndHigherSubstring(String substring, String text) {
        assertFalse(StringUtilities.isSubstring(substring, text));
    }
    
    
    
    
    
//  @ParameterizedTest
//  @CsvSource({"AQ, AQSRT, true", "ST, AFGSTAG, true","HXB, KXMDCBUHXB, true", "EQ, GEHSVQ, false"}) 
//  void isSubstringReturnsTrueForLengthTwoSubstring(String substring, String text, boolean expected) {
//    boolean actual = StringUtilities.isSubstring(substring, text);
//      assertEquals(expected, actual);
//  }
    
}
