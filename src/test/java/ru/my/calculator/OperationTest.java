package ru.my.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class OperationTest {

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "/", "*"})
    public void isOperationTrueTest(String operation){
        assertTrue(Operation.isOperation(operation));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "//", "---", "&"})
    public void isOperationFalseTest(String operation){
        assertFalse(Operation.isOperation(operation));
    }

    @Test
    public void fromStringTest(){
        assertEquals(Operation.PLUS, Operation.fromString("+"));
        assertEquals(Operation.MINUS, Operation.fromString("-"));
        assertEquals(Operation.MULTIPLY, Operation.fromString("*"));
        assertEquals(Operation.DIVIDE, Operation.fromString("/"));

        assertNull(Operation.fromString("++"));
    }
}
