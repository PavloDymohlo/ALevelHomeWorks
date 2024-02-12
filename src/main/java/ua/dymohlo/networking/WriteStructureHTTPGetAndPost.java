package ua.dymohlo.networking;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteStructureHTTPGetAndPost {
    public static void writingTextToFile() {
        File httpStructure = new File("C:\\Users\\DELL\\IdeaProjects\\HomeWorks\\src\\main\\java\\ua\\dymohlo\\networking\\httpStructure.txt");

        String text = "Структура GET-запиту: " + "\n" +
                      "- використовується для отримання даних;" + "\n" +
                      "- GET-запит виконується шляхом надсилання запиту на сервер із використанням HTTP-методу GET " + "\n" +
                      "- запит не має тіла, тому всі дані відправляються через Заголовок." + "\n" +
                      "- GET-запит повинен бути безпечним та іденпотентичним" + "\n" +
                      "Структура POST-запиту: " + "\n" +
                      "- використовується для передачі даних;" + "\n" +
                      "- Дані передаються в тілі запиту;" + "\n" +
                      "- Формат даних може визначатись за допомогою Заголовків Content-Type(наприклад: application/x-www-form-urlencoded);" + "\n" +
                      "- всі дані передаються в тілі запиту, тому вони не відображаються в URL" + "\n" +
                      "- POST-запити можуть впливати на стан сервера та не завжди ідемпотентні " + "\n" + "\n" +
                      "Приклад POST запиту з JSON тілом: " + "\n" +
                      "Створюємо нового користувача на сервері, і відправляємо POST-запит із таким JSON тілом:" + "\n" +
                      "{\n" +
                      "  \"username\": \"new user name\",\n" +
                      "  \"email\": \"user's email address\",\n" +
                      "  \"password\": \"user's password\"\n" +
                      "}\n" +
                      "Це JSON тіло буде включено до POST-запиту і відправлене на сервер, де його можна обробити для створення нового користувача з вказаними даними." + "\n" + "\n" +
                      "Інформація після надсилання GET-запиту на  адресу https://dummyjson.com/products/1:" + "\n" +
                      "C:\\Users\\DELL>curl https://dummyjson.com/products/1\n" +
                      "{\"id\":1,\"title\":\"iPhone 9\",\"description\":\"An apple mobile which is nothing like apple\",\"price\":549,\"discountPercentage\":" + "\n" +
                      "12.96,\"rating\":4.69,\"stock\":94,\"brand\":\"Apple\",\"category\":" + "\n" +
                      "\"smartphones\",\"thumbnail\":\"https://cdn.dummyjson.com/product-images/1/thumbnail.jpg\",\"images\":" + "\n" +
                      "[\"https://cdn.dummyjson.com/product-images/1/1.jpg\",\"https://cdn.dummyjson.com/product-images/1/2.jpg\"," + "\n" +
                      "\"https://cdn.dummyjson.com/product-images/1/3.jpg\",\"https://cdn.dummyjson.com/product-images/1/4.jpg\",\"https://cdn.dummyjson.com/product-images/1/thumbnail.jpg\"]}";

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(httpStructure))) {
            bufferedWriter.write(text);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
