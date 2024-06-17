import java.util.Arrays;
import java.util.Scanner;
public class Lesson5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);         // Для реализации ввода с консоли импортируется
        System.out.print("Введите номер задания\n"); // и в дальнейшем используется зарезервированный
        int num = in.nextInt();                      // класс Scanner(здесь для проверки конкретного метода
        switch(num){                                 // из подзаданий, чтобы не прогонять все сразу, или
            case 1:                                  // не комментить остальные).
                printThreeWords();
                break;
            case 2:
                checkSumSign();
                break;
            case 3:
                printColor();
                break;
            case 4:
                compareNumbers();
                break;
            case 5:
                System.out.print("Первый параметр метода а=");
                int a = in.nextInt();
                System.out.println();
                System.out.print("Второй параметр метода b=");
                int b = in.nextInt();
                System.out.println();
                boolean c = checkSumDec(a,b);
                System.out.println(c);
                break;
            case 6:
                System.out.print("Параметр метода a=");
                int d = in.nextInt();
                System.out.println();
                positCheck(d);
                break;
            case 7:
                System.out.print("Параметр метода e=");
                int e = in.nextInt();
                System.out.println();
                boolean f = positCheckB(e);
                System.out.println(f);
                break;
            case 8:
                System.out.println("Введите строку");
                String g = in.next();
                System.out.println();
                System.out.println("Сколько раз строку прописать?");
                int h = in.nextInt();
                System.out.println();
                strRep(g,h);
                break;
            case 9:
                boolean k = yearCheck();
                System.out.println(k);
                break;
            case 10:
                invertMas();
                break;
            case 11:
                hundrMas();
                break;
            case 12:
                doubleMas();
                break;
            case 13:
                diagMas();
                break;
            case 14:
                System.out.println("Введите параметр len");
                int len = in.nextInt();
                System.out.println();
                System.out.println("Введите параметр initial Value");
                int initialValue = in.nextInt();
                System.out.println();
                int[] mas = paramMas(len,initialValue);
                for (int m=0; m < len; m++) {
                    System.out.print(mas[m]+" ");
                }
                break;
            default:
                System.out.print("Такого задания нет");
        }
    }
    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }
    public static void checkSumSign() {
        Scanner in = new Scanner(System.in);
        System.out.print("a=");
        int a = in.nextInt();
        System.out.println();
        System.out.print("b=");
        int b = in.nextInt();
        if ((a+b)>=0)
            System.out.println("Сумма а и в положительная");
            else
                System.out.println("Сумма а и в отрицательная");
    }
    public static void printColor() {
        Scanner in = new Scanner(System.in);
        System.out.print("value=");
        int value = in.nextInt();
        if (value<=0)
            System.out.println("Красный");
        if ((value > 0) && (value <= 100))
            System.out.println("Желтый");
        if (value > 100)
            System.out.println("Зеленый");
    }
    public static void compareNumbers() {
       Scanner in = new Scanner(System.in);
       System.out.print("а=");
       int a = in.nextInt();
        System.out.println();
        System.out.print("в=");
       int b = in.nextInt();
        System.out.println();
       if (a>=b)
           System.out.println("а >= b");
           else System.out.println("а < b");
    }
    public static boolean checkSumDec(int a, int b) {
        if (((a+b)>=10) && ((a+b)<=20))
                return true;
                        else return false;
    }
    public static void positCheck(int a) {
        if (a>=0) System.out.println("Число а положительное");
            else System.out.println("число а отрицательное");
    }
    public static boolean positCheckB(int a) {
        if (a<0) return true;
            else return false;
    }
    public static void strRep(String s, int a) {
        for (int i=0; i<a; i++) {
            System.out.println(s);
        }
    }
    public static boolean yearCheck() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите год");
        int y = in.nextInt();
        System.out.println();
        if (((y % 4)==0) && ((y % 100)!=0) || ((y % 400)==0))
            return true;
            else return false;
    }
    public static void invertMas() {
        int[] mas = new int[]{1,1,0,0,1,0,1,1,0,0};
        for (int i=0; i < mas.length; i++) {
            if (mas[i] == 1)
                mas[i] = 0;
                else mas[i] = 1;
            System.out.print(mas[i]+" ");
        }
    }
    public static void hundrMas() {
        int[] mas = new int[100];
        for (int i=0; i < mas.length; i++) {
            mas[i] = i + 1;
            System.out.print(mas[i]+" ");
        }
    }
    public static void doubleMas() {
        int[] mas = new int[]{1,5,3,2,11,4,5,2,4,8,9,1};
        for (int i=0; i < mas.length; i++) {
            if (mas[i] < 6)
                mas[i] = mas[i] * 2;
            System.out.print(mas[i]+" ");
        }
    }
    public static void diagMas() {
        int[][] mas = new int[4][4];
        System.out.println("Массив до преобразований");
        for (int i=0; i < mas.length; i++) {
            for (int j=0; j < mas[i].length; j++) {
                mas[i][j] = 0;
                if (j < mas[i].length-1)
                System.out.print(mas[i][j]+" ");
                else
                    System.out.println(mas[i][j]+" ");
            }
        }
        System.out.println("Массив после преобразований");
        for (int i=0; i < mas.length; i++) {
            for (int j=0; j < mas[i].length; j++) {
                if (i == j)
                    mas[i][j] = 1;
            }
        }
        int k = mas[mas.length-1].length-1;
        for (int i=0; i < mas.length; i++) {
            mas[i][k] = 1;
            k--;
        }
        for (int i=0; i < mas.length; i++) {
            for (int j=0; j < mas[i].length; j++) {
                if (j < mas[i].length-1)
                    System.out.print(mas[i][j]+" ");
                else
                    System.out.println(mas[i][j]+" ");
            }
        }
    }
    public static int[] paramMas(int len, int initialValue) {
        int[] mas = new int[len];
        Arrays.fill(mas, initialValue);
        return mas;
    }
}
