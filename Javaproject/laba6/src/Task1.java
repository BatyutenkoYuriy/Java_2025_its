public class Task1 {

    /**
     * Перетворює int у HEX string (великі літери)
     * @param i число
     * @return HEX-представлення
     */
    public static String intToHexString(int i) {
        String hex = Integer.toHexString(i).toUpperCase();

        if (hex.isEmpty()) {
            throw new IllegalArgumentException("Не вдалося перетворити число у HEX");
        }

        return hex;
    }


    public static void main(String[] args) {

        // Масив чисел для демонстрації
        int[] testValues = {51966, 255, 0, 12345, -1};

        for (int value : testValues) {
            try {
                String hex = intToHexString(value);
                System.out.println("Input: " + value + " → HEX: " + hex);
            } catch (Exception e) {
                System.out.println("Помилка для числа " + value + ": " + e);
            }
        }

        // Невалідний приклад для демонстрації виключення
        try {
            System.out.println(intToHexString(Integer.parseInt("not number")));
        } catch (Exception e) {
            System.out.println("Очікувана помилка: " + e);
        }
    }
}
