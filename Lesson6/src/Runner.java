public class Runner {
    public static void employee() {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Миронов Кирилл Александрович",
                                    "ученик", "mka@mail.ru",
                                    "+7986543210", 1000000, 31);
        employees[1] = new Employee("Иванов Иван Иванович",
                                    "ученик", "iii@mail.ru",
                                    "+787968577", 100, 30);
        employees[2] = new Employee("Федоров Федор Федорович",
                                    "ученик", "fff@mail.ru",
                                    "+7948756", 100, 29);
        employees[3] = new Employee("Петров Петр Петрович",
                                    "ученик", "ppp@mail.ru",
                                    "+79487689467", 100, 28);
        employees[4] = new Employee("Сидоров Сидор Сидорович",
                                    "ученик", "sss@mail.ru",
                                    "+78934768934674578", 100, 27);
        for (int i = 0; i < employees.length; i++)
            employees[i].empinfo();
    }
    public static void park() {
        Park.Attract attr = new Park(). new Attract("Колесо оборзения",
                                                    "12:00 - 00:00", 700);
        attr.attrinfo();
    }
}
