package edu.mills.cs180a;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
  @ValueSource(strings =  {"is", "land", "isl", "ands"})
  void isSubstring_True_Substrings(String input) {
    assertTrue(StringUtilities.isSubstring(input, "island"));
  }

  @ParameterizedTest
  @ValueSource(strings =  {"iz", "lanp", "islaz", "anda"})
  void isSubstring_False_Substrings(String input) {
    assertFalse(StringUtilities.isSubstring(input, "island"));
  }

}
