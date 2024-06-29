import java.util.HashMap;
import java.util.ArrayList;

public class PhoneBook {
    private final HashMap<String, ArrayList<String>> lines = new HashMap<>();
    public void add(String name, String number) {
        if (lines.get(name) != null) {
            if (!lines.get(name).contains(number)) {
                lines.get(name).add(number);
            }
        }
                else {
                    ArrayList<String> numblist = new ArrayList<>();
                    numblist.add(number);
                    lines.put(name, numblist);
                }
    }
    public void get(String name) {
        System.out.print(name + ":   телефон(ы):   ");
        System.out.println(lines.get(name));
    }
}
