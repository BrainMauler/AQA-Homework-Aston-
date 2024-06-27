public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException(String mes) {
        super(mes);   // С помощью конструктора RuntimeException будем выводить сообщение с исключением
    }
}
