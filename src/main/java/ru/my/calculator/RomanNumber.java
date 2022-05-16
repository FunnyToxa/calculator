package ru.my.calculator;

import java.util.TreeMap;

/**
    Римские числа от 1 до 10
 */
enum RomanNumber {
    I(1),
    II(2),
    III(3),
    IV(4),
    V(5),
    VI(6),
    VII(7),
    VIII(8),
    IX(9),
    X(10);

    RomanNumber(int num){
        this.num = num;
    }

    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    private int num;

    /**
     * получение арабского числа - эквивалента римской
     * @return арабоское число в формате int
     */
    public int getArabicNum(){
        return num;
    }

    /**
     * Преобразование арабского числа в римское
     * @param number входное арабское число
     * @return римское число в формате String
     */
    public final static String toRoman(int number) throws Exception {
        if (number < 1) throw new Exception("В римской системе нет отрицательных чисел");
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number-l);
    }

    /**
     * Проверка, что входящая строка является римским числом из элементов перечисления
     * @param input входная строка
     * @return true - является, false - нет
     */
    public static boolean isRomanNumber(String input){
        for (RomanNumber romanNumber: RomanNumber.values()) {
            if (romanNumber.name().equalsIgnoreCase(input)) return true;
        }
        return false;
    }
}
