public class Task7 {

    /**
     * Рахує кількість слів у реченні.
     * Слово = комбінація літер та/або цифр (A–Z, a–z, 0–9).
     * @param sentence речення
     * @return кількість слів
     */
    public static int countWords(String sentence) {
        if (sentence == null) {
            throw new NullPointerException("Речення не може бути null");
        }

        String trimmed = sentence.trim();

        if (trimmed.isEmpty()) {
            return 0;
        }

        // Розбиваємо по пробільних символах
        String[] parts = trimmed.split("\\s+");

        int count = 0;
        for (String part : parts) {
            // Дозволені слова: лише [A-Za-z0-9]+
            if (part.matches("[A-Za-z0-9]+")) {
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {

        // Тестові рядки
        String[] tests = {
            "Hello world 123",
            "The user with the nickname koala757677 this month left 3 times more comments than the user with the nickname croco181dile181920 4 months ago",
            "  test   123   hello ",
            "",
            "!!! ???",
            null  // щоб показати роботу виключення
        };

        for (String s : tests) {
            try {
                int result = countWords(s);
                System.out.println("Input: \"" + s + "\" → Words: " + result);
            } catch (Exception e) {
                System.out.println("Input: \"" + s + "\" → Error: " + e);
            }
        }
    }
}
