import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        // 1. СТВОРЕННЯ (Завжди зліва пишемо інтерфейс Map, а справа реалізацію HashMap)
        Map<String, Integer> phoneBook = new HashMap<>();

        // 2. ДОДАВАННЯ ЕЛЕМЕНТІВ (метод put)
        phoneBook.put("Олег", 931112233);
        phoneBook.put("Марія", 674445566);
        phoneBook.put("Ігор", 509998877);

        // Спроба додати Олега ще раз — перепише його старий номер телефону!
        phoneBook.put("Олег", 990000000);

        // 3. ОТРИМАННЯ ЗНАЧЕННЯ (метод get)
        // Передаємо ключ "Марія", отримуємо її номер
        Integer mariasNumber = phoneBook.get("Марія");
        System.out.println("Номер Марії: " + mariasNumber);

        // 4. ПЕРЕВІРКА НАЯВНОСТІ (методи containsKey та containsValue)
        if (phoneBook.containsKey("Ігор")) {
            System.out.println("Ігор є в списку контактів.");
        }

        // 5. ВИДАЛЕННЯ ЕЛЕМЕНТА (метод remove)
        phoneBook.remove("Ігор"); // Ігор і його номер зникають з мапи

        // Дізнатися розмір мапи (скільки там зараз пар)
        System.out.println("Кількість контактів: " + phoneBook.size());
    }
}

// Бігаємо по кожній "парі" (Entry) всередині нашої телефонної книги
for (Map.Entry<String, Integer> contact : phoneBook.entrySet()) {
        // У кожної пари беремо окремо Ключ (getKey) та Значення (getValue)
        System.out.println("Ім'я: " + contact.getKey() + ", Телефон: " + contact.getValue());
        }