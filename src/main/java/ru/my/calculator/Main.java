package ru.my.calculator;

import java.util.Scanner;

public class Main {
    private static final Calculator calculator = new MyCalculator();

    public static void main(String[] args) throws Exception {
        //Считываем строку из консоли
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        //производим рассчет и выводим результат в консоль в отдельную строку
        System.out.println(calc(input));
    }

    /**
     * Метод рассчета арифметического выражения
     * @param input строка с арифметическим выражением
     * @return результат выполнения арифметического выражения
     */
    public static String calc(String input) throws Exception {
        //Получаем выражение в виде объекта
        CalcExpression calcExpression = CalcExpression.getCalcExpression(input);

        //производим рассчет
        int result = calculator.calculate(calcExpression.getNumber1(), calcExpression.getNumber2(), calcExpression.getOperation());

        //формируем ответ
        if (calcExpression.isRomanNumber())
            return RomanNumber.toRoman(result);
        return String.valueOf(result);
    }
}
