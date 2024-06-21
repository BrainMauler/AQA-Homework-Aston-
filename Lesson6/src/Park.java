public class Park {
    public class Attract {
        private String name;
        private String time;
        private double price;
        public Attract(String name, String time, double price) {
            this.name = name;       // Поля внутреннего класса
            this.time = time;
            this.price = price;
        }
        public void attrinfo() {
            System.out.print("\nНазвание аттракциона: " + name + ";\n"
                             + "Время работы: " + time + ";\n"
                             + "Цена за вход: " + price + "\n");
        }
    }
}
