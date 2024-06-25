public class Cat extends Animal {
    String name;
    int appet; // поле апппетита животных, т.е. сколько им нужно съесть для сытости
    static int catCount = 0;
    static boolean full;
    Cat (String name, int appet){
        super();
        this.name = name;
        this.appet = appet;
        this.full = false;
        catCount++;
    }
    @Override
    public void run(int rdist) {
        if (rdist > 200)
            System.out.println("\nКошка/кот " + name + " выбилась(ся) из сил, не добежав " + (rdist - 200) + "м");
        else
            System.out.println("\nКошка/кот " + name + " пробежал(а) " + rdist + " м");
    }
    @Override
    public void swim(int sdist) {
        System.out.println("Кошка/кот " + name + " решительно отказывается плавать");
    }
    public static int retCatCount(){
        return catCount;
    }
    public boolean feed(int food) {
        if (food >= appet) {
            full = true;
            System.out.println("\nКошка/кот " + name + " с аппетитом съел(а) " + appet + " у.е. еды, теперь в миске "
                    + (food - appet) + " у.е. еды");
        }
        else {
            full = false;
            System.out.println("\nКошка/кот " + name + " высокомерно отказывается от жалких крох из миски");
        }
        return full;
    }
}
