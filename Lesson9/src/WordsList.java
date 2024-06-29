import java.util.ArrayList;

public class WordsList {
    public static void wordsList() {
        ArrayList<String> words = new ArrayList<>(10);
        words.add(0,"первый");
        words.add(1,"второй");
        words.add(2,"первый");
        words.add(3,"третий");
        words.add(4,"четвертый");
        words.add(5,"Четвертый");
        words.add(6,"Первый");
        words.add(7,"первыЙ");
        words.add(8,"ЧЕТВЕРТЫЙ");
        words.add(9,"пятый");
        System.out.println("Необработанный список:\n" + words);
        String[] w = new String[words.size()];
        words.toArray(w);
        words.clear();
        System.out.println("\nПриведем все слова к единому регистру(нижнему) и сосчитаем дубликаты: ");
        int s = 0;
        for (int i = 0; i < w.length; i ++) {
            s = 1;
            for (int j = 0; j < w.length; j++) {
                if (i != j)
                    if (w[j].equalsIgnoreCase(w[i])) {
                        w[j] = "remove";
                        s ++;
                    }
            }
            if (! w[i].equalsIgnoreCase("remove"))
                System.out.println("\nСлово " + "<" + w[i] + ">" + " повторяется " + s + " раз");
        }
        System.out.println("\nДубликаты заменили на триггер remove, которые впоследствии удалим:");
        for (int i = 0; i < w.length; i ++)
            System.out.print(w[i] + " ");
        for (int i = 0; i < w.length; i ++) {
            if (! w[i].equals("remove"))
                words.add(w[i]);
        }
        System.out.println("\n\nВ итоге получаем список с уникальными эл-ми:\n" + words);
    }

}
