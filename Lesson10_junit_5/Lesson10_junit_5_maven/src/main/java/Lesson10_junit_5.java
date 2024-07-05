import java.util.Scanner;

public class Lesson10_junit_5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Число для нахождения факториала: ");
        int x = in.nextInt();
        System.out.println(" Факториал числа " + x + " равен " + Factorial.factorial(x));
    }
}
