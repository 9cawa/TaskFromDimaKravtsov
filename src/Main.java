import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = sc.nextLine();
        System.out.println("Ответ: " + lengthOfMaxSubstring(input));
    }

    static int lengthOfMaxSubstring(String s) {
        StringBuilder result = new StringBuilder();
        int start = 0;
        String substring;
        List<Integer> subStrings= new ArrayList<>(); //Список, в который будем добавлять
        // значения кол-ва символов в подходящих подстроках

        while (start + 2 < s.length()) {
            char first = s.charAt(start); //Первый доступный в подстроке символ
            char second = s.charAt(start + 1); //Второй доступный в подстроке символ
            result.append(first).append(second);

            //Обработка случая когда в строке идут подряд одни и те же символы,
            // т.е. ищем второй символ отличающийся от первого
            while (first == second && start + 2 < s.length()) {
                start++;
                second = s.charAt(start + 1);
                result.append(second);
            }

            substring = s.substring(start + 2); //В этой переменной храним подстроку от start до конца

            //Парсим substring: идем по каждой букве, добавляем те что равны first или second.
            // Прерываем цикл, если встречается отличный от них символ
            for (int i = 0; i < substring.length(); i++) {
                if (substring.charAt(i) == first || substring.charAt(i) == second)
                    result.append(substring.charAt(i));
                else
                    break;
            }

            subStrings.add(result
                    .toString()
                    .length());    //Добавляем в список длину полученной подстроки

            start++;
            result.setLength(0); //Обнуляем StringBuilder
        }
        Collections.sort(subStrings); //Сортировка коллекции по возрастанию
        return subStrings.get(subStrings.size() - 1); //Возвращаем последний элемент списка
    }
}
