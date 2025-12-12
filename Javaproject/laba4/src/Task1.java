public class Task1 {
    
    /**
     * Знаходить кількість додатних елементів у масиві
     * @param array вхідний масив
     * @return кількість додатних елементів
     * @throws NullPointerException якщо масив null
     */
    public static int countPositiveElements(int[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null");
        }
        
        int count = 0;
        // Використовуємо for-each для перебору елементів
        for (int element : array) {
            if (element > 0) {
                count++;
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Завдання 1: Кількість додатних елементів ===\n");
        
        // Тест 1: Звичайний масив зі змішаними значеннями
        int[] array1 = {5, -3, 8, 0, -1, 12, 7, -9};
        System.out.println("Масив 1: " + java.util.Arrays.toString(array1));
        System.out.println("Кількість додатних елементів: " + countPositiveElements(array1));
        System.out.println();
        
        // Тест 2: Всі елементи додатні
        int[] array2 = {1, 2, 3, 4, 5};
        System.out.println("Масив 2: " + java.util.Arrays.toString(array2));
        System.out.println("Кількість додатних елементів: " + countPositiveElements(array2));
        System.out.println();
        
        // Тест 3: Всі елементи від'ємні
        int[] array3 = {-1, -2, -3, -4};
        System.out.println("Масив 3: " + java.util.Arrays.toString(array3));
        System.out.println("Кількість додатних елементів: " + countPositiveElements(array3));
        System.out.println();
        
        // Тест 4: Масив з нулями
        int[] array4 = {0, 0, 1, 0, -1};
        System.out.println("Масив 4: " + java.util.Arrays.toString(array4));
        System.out.println("Кількість додатних елементів: " + countPositiveElements(array4));
        System.out.println();
        
        // Тест 5: Порожній масив
        int[] array5 = {};
        System.out.println("Масив 5: " + java.util.Arrays.toString(array5));
        System.out.println("Кількість додатних елементів: " + countPositiveElements(array5));
        System.out.println();
        
        // Тест 6: Заборонений випадок - null
        System.out.println("Тест з null:");
        try {
            countPositiveElements(null);
        } catch (NullPointerException e) {
            System.out.println("Виключення: " + e.getMessage());
        }
    }
}
