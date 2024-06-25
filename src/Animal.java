public class Animal {
    static int anCount = 0;
    Animal(){
        anCount++;
    }
    void run (int rdist) {
        System.out.println("Под наследников" + rdist);
    }
    void swim (int sdist){
        System.out.println("Под наследников" + sdist);
    }
    public static int retAnCount(){
        return anCount;
    }
}
