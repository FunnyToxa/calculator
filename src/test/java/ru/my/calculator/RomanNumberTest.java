package ru.my.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumberTest {

    @ParameterizedTest
    @CsvSource({"1, I", "2, II", "3, III", "4, IV", "5, V", "6, VI", "7, VII", "8, VIII", "9, IX", "10, X"})
    void getArabicNumTest(int result, RomanNumber romanNumber) {
        assertEquals(romanNumber.getArabicNum(), result);
    }

    @Test
    void toRomanTest() throws Exception {
        assertEquals("XI", RomanNumber.toRoman(11));

        assertThrows(Exception.class, () -> {
            RomanNumber.toRoman(-1);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"})
    void isRomanNumberTrueTest(String strRomanNumber) {
        assertTrue(RomanNumber.isRomanNumber(strRomanNumber));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abracadabra", "XI"})
    void isRomanNumberFalseTest(String strRomanNumber) {
        assertFalse(RomanNumber.isRomanNumber(strRomanNumber));
    }
}