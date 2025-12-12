public class Task31 {
    
    /**
     * Знаходить суму мінімального додатного елемента та його індексу
     * @param array вхідний масив
     * @return сума мінімального додатного елемента та його індексу
     * @throws NullPointerException якщо масив null
     * @throws IllegalArgumentException якщо у масиві немає додатних елементів
     */
    public static int findMinPositiveSum(int[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null");
        }
        
        int minPositive = Integer.MAX_VALUE;
        int minIndex = -1;
        
        // Використовуємо звичайний цикл for
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0 && array[i] < minPositive) {
                minPositive = array[i];
                minIndex = i;
            }
        }
        
        if (minIndex == -1) {
            throw new IllegalArgumentException("У масиві немає додатних елементів");
        }
        
        return minPositive + minIndex;
    }
    
    /**
     * Допоміжний метод для детального виведення результату
     */
    private static void displayResult(int[] array) {
        int minPositive = Integer.MAX_VALUE;
        int minIndex = -1;
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0 && array[i] < minPositive) {
                minPositive = array[i];
                minIndex = i;
            }
        }
        
        if (minIndex != -1) {
            System.out.println("Мінімальний додатний елемент: " + minPositive);
            System.out.println("Його індекс: " + minIndex);
            System.out.println("Сума: " + minPositive + " + " + minIndex + " = " + (minPositive + minIndex));
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Завдання 31: Сума мінімального додатного елемента та його номера ===\n");
        
        // Тест 1: Звичайний масив
        int[] array1 = {-5, 3, 8, -2, 1, 12, 7};
        System.out.println("Масив 1: " + java.util.Arrays.toString(array1));
        displayResult(array1);
        System.out.println("Результат: " + findMinPositiveSum(array1));
        System.out.println();
        
        // Тест 2: Мінімальний додатний елемент на початку
        int[] array2 = {2, 10, 5, -3, 8};
        System.out.println("Масив 2: " + java.util.Arrays.toString(array2));
        displayResult(array2);
        System.out.println("Результат: " + findMinPositiveSum(array2));
        System.out.println();
        
        // Тест 3: Мінімальний додатний елемент в кінці
        int[] array3 = {100, 50, -10, 25, 1};
        System.out.println("Масив 3: " + java.util.Arrays.toString(array3));
        displayResult(array3);
        System.out.println("Результат: " + findMinPositiveSum(array3));
        System.out.println();
        
        // Тест 4: Один додатний елемент
        int[] array4 = {-1, -2, 5, -3, -4};
        System.out.println("Масив 4: " + java.util.Arrays.toString(array4));
        displayResult(array4);
        System.out.println("Результат: " + findMinPositiveSum(array4));
        System.out.println();
        
        // Тест 5: Заборонений випадок - немає додатних елементів
        int[] array5 = {-1, -2, -3, 0, -5};
        System.out.println("Масив 5: " + java.util.Arrays.toString(array5));
        try {
            findMinPositiveSum(array5);
        } catch (IllegalArgumentException e) {
            System.out.println("Виключення: " + e.getMessage());
        }
        System.out.println();
        
        // Тест 6: Заборонений випадок - null
        System.out.println("Тест з null:");
        try {
            findMinPositiveSum(null);
        } catch (NullPointerException e) {
            System.out.println("Виключення: " + e.getMessage());
        }
    }
}
