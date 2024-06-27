public class Lesson8 {
    public static void main(String[] args) {
        try {
            System.out.println("\nСумма всех эл-в массива mas1 равна " + Runner.myArrayExc(Runner.mas1));   // Прогонка контрольного массива без искл.
        }
        catch (MyArrayDataException | MyArraySizeException e) {
            System.out.println("\n" + e);
            System.out.println("Просчитать сумму всех эл-в массива mas1 невозможно, или массив не соответствует требованиям");
        }
        try {
            System.out.println("\nСумма всех эл-в массива mas2 равна " + Runner.myArrayExc(Runner.mas2));   // Прогонка с искл. по пазмеру
        }
        catch (MyArrayDataException | MyArraySizeException e) {
            System.out.println("\n" + e);
            System.out.println("Просчитать сумму всех эл-в массива mas2 невозможно, или массив не соответствует требованиям");
        }
        try {
            System.out.println("\nСумма всех эл-в массива mas3 равна " + Runner.myArrayExc(Runner.mas3));   // прогонка с искл. по формату эл-в
        }
        catch (MyArrayDataException | MyArraySizeException e) {
            System.out.println("\n" + e);
            System.out.println("Просчитать сумму всех эл-в массива mas3 невозможно, или массив не соответствует требованиям");
        }
    }
}
