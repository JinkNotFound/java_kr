package ru.pavel.api.dz;

import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        String[] data = {
                "123456 Иванов",
                "321456 Васильев",
                "234561 Петрова",
                "234432 Иванов",
                "654321 Иванов",
                "654321 Петрова"
        };

        task1(data);

        String[] phoneBookData = {
                "Иванов 123456",
                "Петрова 234561",
                "Иванов 654321",
                "Васильев 321456",
                "Петрова 654321",
                "Иванов 234432"
        };

        task4(phoneBookData);
    }

    public static void task1(String[] data) {
        for (String item : data) {
            System.out.println(item);
        }
    }

    public static void task4(String[] phoneBookData) {
        HashMap<String, HashSet<String>> phoneBook = new HashMap<>();

        for (String entry : phoneBookData) {
            String[] parts = entry.split(" ");
            String name = parts[0];
            String phoneNumber = parts[1];

            if (phoneBook.containsKey(name)) {
                phoneBook.get(name).add(phoneNumber);
            } else {
                HashSet<String> phoneNumbers = new HashSet<>();
                phoneNumbers.add(phoneNumber);
                phoneBook.put(name, phoneNumbers);
            }
        }

        List<Map.Entry<String, HashSet<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));

        for (Map.Entry<String, HashSet<String>> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size() + " телефон(ов)");
        }
    }
}

