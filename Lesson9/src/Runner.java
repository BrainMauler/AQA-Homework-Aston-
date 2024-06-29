public class Runner {
    public static void phoneBook() {
        PhoneBook pB = new PhoneBook();
        pB.add("Иванов", "+7 999 888 65 43");
        pB.add("Петров", "+7 999 777 65 43");
        pB.add("Сидоров", "+7 999 666 65 43");
        pB.add("Иванов", "+7 999 888 65 43");
        pB.add("Петров", "+7 999 555 65 43");
        pB.get("Иванов");
        pB.get("Петров");
        pB.get("Сидоров");
    }
}
