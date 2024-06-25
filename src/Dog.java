public class Dog extends Animal {
    String name;
    static int dogCount = 0;
    Dog (String name){
        super();
        this.name = name;
        dogCount++;
    }
    @Override
    public void run(int rdist) {
        if (rdist > 500)
            System.out.println("\nСобака/пес " + name + " выбилась(ся) из сил, не добежав " + (rdist - 200) + "м");
        else
            System.out.println("\nСобака/пес " + name + " пробежал(а) " + rdist + " м");
    }
    @Override
    public void swim(int sdist) {
        if (sdist > 10)
            System.out.println("Собака/пес " + name + " утоп(ла), не доплыв " + (sdist - 10) + "м");
        else
            System.out.println("Собака/пес " + name + " проплыл(а) " + sdist + " м");
    }
    public static int retDogCount(){
        return dogCount;
    }
}
