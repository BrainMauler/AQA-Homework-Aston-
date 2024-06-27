public class Runner {
    public static String[][] mas1 = {{"11", "12", "13", "14"},{"21", "22", "23", "24"},{"31", "32", "33", "34"},{"41", "42", "43", "44"}};
    public static String[][] mas2 = {{"11", "12", "13", "14"},{"21", "22", "23", "24"},{"31", "32", "33", "34"}};
    public static String[][] mas3 = {{"11", "12", "13", "14"},{"21", "22", "23", "24"},{"3!", "32", "33", "34"},{"41", "42", "43", "44"}};
    public static int myArrayExc(String[][] mas) {
        if ((mas.length != 4) || (mas[0].length != 4))   // Массив квадратный, достаточно проверить 1-й столбец
            throw new MyArraySizeException("Массив не соответствует размерности 4х4");
        int s = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                try {
                    s += Integer.parseInt(mas[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException("Элемент массива [ " + i + " ][ " + j + " ] имеет некорректный формат");
                }
            }
        }
        return s;
    }
}
