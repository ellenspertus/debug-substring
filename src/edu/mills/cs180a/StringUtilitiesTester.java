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

  @Test
  void isSubstring_True_Length2Substring() {
    assertTrue(StringUtilities.isSubstring("C D", "ABC DEF"));
  }

  @Test
  void isSubstring_True_Length3Substring() {
    assertTrue(StringUtilities.isSubstring("GHI", "ABC DEF GHI"));
  }


  @ParameterizedTest
  @CsvSource({"The cat is in the hat,cat is in", "Tra lalalalala,tra", "Mo Ghile Mear,Ghile"})
  void isSubstring_True_VariedStringsAndSubstrings(String input, String subInput) {
    assertTrue(StringUtilities.isSubstring(subInput, input));
  }

  @ParameterizedTest
  @CsvSource({"The cat is in the hat,hotpot", "Tra lalalalala,homeward is",
      "Mo Ghile Mear,run away"})
  void isSubstring_False_VariedStringsAndSubstrings(String input, String subInput) {
    assertFalse(StringUtilities.isSubstring(subInput, input));
  }
}
