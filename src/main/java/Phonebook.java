
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Phonebook {
    private Map<String, List<String>> map = new HashMap<>();

    void add(String phoneNum, String name) {
        if (map.containsKey(name)) {
            List<String> phoneNumbers = map.get(name);
            phoneNumbers.add(phoneNum);
        } else {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNum);
            map.put(name, phoneNumbers);
        }
    }

    String getPhoneNum(String phoneNum) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> phoneNumbers = entry.getValue();
            if (phoneNumbers.contains(phoneNum)) {
                stringBuilder.append(entry.getKey());
                stringBuilder.append(" : ");
                stringBuilder.append(entry.getValue());
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    String getByName(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        if (map.containsKey(name)) {
            List<String> phoneNumbers = map.get(name);
            for (String phoneNumber : phoneNumbers) {
                stringBuilder.append(phoneNumber);
                stringBuilder.append(" : ");
                stringBuilder.append(name);
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    String getAll() {
        StringBuilder stringBuilder = new StringBuilder();
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(map.entrySet());
        entries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));
        for (Map.Entry<String, List<String>> entry : entries) {
            List<String> phoneNumbers = entry.getValue();
            stringBuilder.append(entry.getKey());
            stringBuilder.append(" : ");
            stringBuilder.append(phoneNumbers);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Phonebook phoneBook = new Phonebook();
        phoneBook.add("894513541", "Иван");
        phoneBook.add("894573122", "Максим");
        phoneBook.add("791133546", "Евгений");
        phoneBook.add("789123456", "Екатерина");
        phoneBook.add("365942655", "Егор");
        phoneBook.add("+794516121", "Иван");
        phoneBook.add("+712156949", "Пётр");
        phoneBook.add("694644633", "Василиса");
        phoneBook.add("8800545656", "Михаил");
        phoneBook.add("795545645", "Егор");
        phoneBook.add("5505454546", "Максим");
        phoneBook.add("4114899511", "Максим");
        phoneBook.add("1248956655", "Викторя");
        phoneBook.add("9001548666", "Евгений");
        phoneBook.add("9784561332", "Виталий");
        System.out.println(phoneBook.getByName("Иван"));
        System.out.println(phoneBook.getAll());
    }
}
