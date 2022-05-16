package ru.my.calculator;

enum Operation {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    Operation(char sign) {
        this.sign = sign;
    }

    private char sign;

    public char getSign(){
        return sign;
    }

    /**
     * метод проверки - является ли строка оператором
     * @param str входная строка
     * @return true - является, false - нет
     */
    public static boolean isOperation(String str) {
        if (str.length() > 1) return false;
        char c = str.charAt(0);
        return (MINUS.getSign() == c
                || PLUS.getSign() == c
                || MULTIPLY.getSign() == c
                || DIVIDE.getSign() == c);
    }

    /**
     * Получаем оператор из строки
     * @param str входная строка
     * @return оператор
     */
    public static Operation fromString(String str) {
        if (isOperation(str)) {
            for(Operation operation: Operation.values()) {
                if (operation.getSign() == str.charAt(0)) return operation;
            }
        }
        return null;
    }
}
