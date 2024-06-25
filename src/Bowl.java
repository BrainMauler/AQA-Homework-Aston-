public class Bowl {
    static int food;
    public Bowl(int food) {
        this.food = food;
    }
    public static void addFood(int add) {
        if (add>0) {
            food += add;
            System.out.println("В миске на " + add + " у.е. еды больше, а именно: " + food + " у.е. еды");
        }
        else
            System.out.println("Ничего не добавлено, так и осталось " + food + " у.е. еды");
    }
}
