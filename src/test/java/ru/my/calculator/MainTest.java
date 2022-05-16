package ru.my.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainTest {

    @Test
    public void calcArabicPositiveTest() throws Exception {
        //арабские
        //сложение
        assertEquals("3", Main.calc("1 + 2"));
        //вычитание
        assertEquals("1", Main.calc("3 - 2"));
        //умножение
        assertEquals("6", Main.calc("3 * 2"));
        //деление
        assertEquals("2", Main.calc("5 / 2"));

        //Римские
        //сложение
        assertEquals("III", Main.calc("I + II"));
        //вычитание
        assertEquals("I", Main.calc("III - II"));
        //умножение
        assertEquals("VI", Main.calc("III * II"));
        //деление
        assertEquals("II", Main.calc("V / II"));

    }

    @Test
    public void negativeInputNumsTest(){
        assertThrows(Exception.class, () -> Main.calc("1 + 11"));
        assertThrows(Exception.class, () -> Main.calc("I + XI"));
        assertThrows(Exception.class, () -> Main.calc("1 + XI"));
        assertThrows(Exception.class, () -> Main.calc("1 + 2 + 3"));
    }
}
