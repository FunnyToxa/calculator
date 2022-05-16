package ru.my.calculator;

/**
 * Класс Калькулятор; для рассчета арифметических выражений
 */
class MyCalculator implements Calculator{

    @Override
    public int calculate(int a, int b, Operation operation) throws Exception {
        switch (operation) {
            case PLUS:
                return a + b;
            case MINUS:
                return a - b;
            case MULTIPLY:
                return a * b;
            case DIVIDE:
                return a / b;
            default:
                throw new Exception("Операция не поддерживается");
        }
    }
}
