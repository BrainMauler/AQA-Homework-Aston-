public class Runner {
    public static void animals() {
        int rdist = 120;   //Расстояние, которое нужно пробежать
        int sdist = 12;   //Расстояние, которое нужно проплыть(из-за большого разброса по бегу и плаванию, решил их разделить)
        int food = 10;   //Начальное кол-во еды в миске
        int add = 10;   //Размер добавки
        Animal[] animals = new Animal[7];
        animals[0] = new Cat("Мурка", 10);
        animals[1] = new Dog("Шарик");
        animals[2] = new Cat("Барсик", 20);
        animals[3] = new Dog("Маркиза");
        animals[4] = new Cat("Дымок", 15);
        animals[5] = new Dog("Бобик");
        animals[6] = new Cat("Снежинка", 12);
        System.out.println("Кошек/котов всего " + Cat.retCatCount() + ";");
        System.out.println("Собак/псов всего " + Dog.retDogCount() + ";");
        System.out.println("Животных всего " + Animal.retAnCount() + ";");
        for (int i = 0; i < animals.length; i++) {
            animals[i].run(rdist);
            animals[i].swim(sdist);
        }
        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Мурка", 10);
        cats[1] = new Cat("Барсик", 10);
        cats[2] = new Cat("Дымок", 10);
        cats[3] = new Cat("Снежинка", 10);
        Bowl.food = food;
        for (int i = 0; i < cats.length; i++) {
            cats[i].feed(Bowl.food);
            if (!cats[i].full) {
                System.out.println("Кошка/кот " + cats[i].name + " так и осталась(ся) голодной(ым)");
                Bowl.addFood(add);
                }
                else
                    {
                        System.out.println("Кошка/кот " + cats[i].name + " поел(а) и теперь сыт(а)");
                        Bowl.food -= cats[i].appet;
                    }

        }
    }
    public static void figures() {
        Circle Circle1 = new Circle(12, "Черный", "Красный");
        Circle1.info();
        Triangle Triangle1 = new Triangle(3, 5, 7, "Черный", "Красный");
        Triangle1.info();
        Rectrangle Rectrangle1 = new Rectrangle(2, 4, "Черный", "Красный");
        Rectrangle1.info();
    }
}
