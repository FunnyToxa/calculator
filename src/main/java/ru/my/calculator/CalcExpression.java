package ru.my.calculator;

/**
 * Вычислительное выражение
 */
class CalcExpression {

    private static final String SPACE = " ";

    private int number1;
    private int number2;
    private Operation operation;
    private boolean isRomanNumber;

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public Operation getOperation() {
        return operation;
    }

    public boolean isRomanNumber() {
        return isRomanNumber;
    }

    //закртый констурктор, получаем объект только статического метода преобразования
    private CalcExpression(int number1, int number2, boolean isRomanNumber, Operation operation){
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
        this.isRomanNumber = isRomanNumber;
    }

    /**
     * Получение объекта вычислительного выражения из строки
     * @param strExpression входная строка
     * @return объект CalcExpression
     * @throws Exception исключение в случае невозможности преобразования
     */
    public static CalcExpression getCalcExpression(String strExpression) throws Exception {
        //получаем массив элементов выражения и валидируем кол-во элементов
        String[] params = strExpression.split(SPACE);
        if (params.length != 3) throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор");

        //валидируем и получаем операнды
        int num1, num2;
        boolean isRimNumber;
        try {
            if (RomanNumber.isRomanNumber(params[0])
                    && RomanNumber.isRomanNumber(params[2])){
                isRimNumber = true;
                num1 = RomanNumber.valueOf(params[0]).getArabicNum();
                num2 = RomanNumber.valueOf(params[2]).getArabicNum();
            } else {
                isRimNumber = false;
                num1 = Integer.valueOf(params[0]);
                num2 = Integer.valueOf(params[2]);
            }
            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                throw new Exception("Входные числа должны быть в диапазоне от 1 до 10");
            }
        } catch (NumberFormatException e) {
            throw new Exception("Элемент выражения не является целым арабским или римским числом");
        }

        //валидируем и получаем оператор выражения
        if (!Operation.isOperation(params[1])) throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        Operation operation = Operation.fromString(params[1]);

        return new CalcExpression(num1, num2, isRimNumber, operation);
    }
}
