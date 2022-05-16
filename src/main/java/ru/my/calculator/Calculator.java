package ru.my.calculator;

interface Calculator {
    /**
     * метод вычисления арифметического действия между двумя числами
     * @param a первое число
     * @param b второе число
     * @param operation арифметическое действие - сложение, вычинание, умножение или деление
     * @return возвращает результат вычисления
     * @throws Exception ошибка
     */
    int calculate(int a, int b, Operation operation) throws Exception;
}
