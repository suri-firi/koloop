import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class exwriterreader {
    public static void main(String[] args) {
        // Задаємо відносний шлях. Файл створиться в папці "документи", 
        // яка має лежати в корені твого проекту.
        String filePath = "src/documents/notes.txt";

        // 1. ПРАВИЛЬНИЙ ЗАПИС У ФАЙЛ
        // Створюємо Writer прямо в дужках try — це гарантує його закриття операційною системою
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            writer.write("Рядок 1: Привіт, Світ!\n");
            writer.write("Рядок 2: Навчання Java — це круто.\n");
            writer.write("Рядок 3: Кінець файлу.");

            System.out.println("✅ Файл успішно записано за шляхом: " + filePath);

        } catch (IOException e) {
            // Якщо папки src/documents не існує, або немає прав на запис — ми впадемо сюди
            System.err.println("❌ Помилка під час запису файлу: " + e.getMessage());
        }

        System.out.println("----------------------------------------------");

        // 2. ПРАВИЛЬНЕ ЧИТАННЯ З ФАЙЛУ
        // BufferedReader читає файл не по одній букві, а великими шматками в пам'ять (швидко!)
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String currentLine;
            System.out.println("📖 Читаємо вміст файлу:");

            // Читаємо файл построково, поки не дойдемо до кінця (null)
            while ((currentLine = reader.readLine()) != null) {
                System.out.println(currentLine);
            }

        } catch (IOException e) {
            // Якщо файлу за цим шляхом немає — Java викине FileNotFoundException, і ми його тут зловимо
            System.err.println("❌ Помилка під час читання файлу: " + e.getMessage());
        }
    }
}