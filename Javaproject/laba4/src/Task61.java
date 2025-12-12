public class Task61 {
    
    /**
     * Формує масив C на основі масивів A та B згідно з правилами
     * @param arrayA перший вхідний масив
     * @param arrayB другий вхідний масив
     * @return результуючий масив C
     * @throws NullPointerException якщо будь-який з масивів null
     * @throws IllegalArgumentException якщо масиви мають різну довжину
     */
    public static int[] formArrayC(int[] arrayA, int[] arrayB) {
        if (arrayA == null || arrayB == null) {
            throw new NullPointerException("Масиви не можуть бути null");
        }
        
        if (arrayA.length != arrayB.length) {
            throw new IllegalArgumentException(
                "Масиви повинні мати однакову довжину. " +
                "Довжина A: " + arrayA.length + ", довжина B: " + arrayB.length
            );
        }
        
        int n = arrayA.length;
        int[] arrayC = new int[n];
        
        // Використовуємо звичайний цикл for
        for (int i = 0; i < n; i++) {
            if (arrayA[i] > 0 && arrayB[i] > 0) {
                // Обидва додатні - сума
                arrayC[i] = arrayA[i] + arrayB[i];
            } else if (arrayA[i] < 0 && arrayB[i] < 0) {
                // Обидва від'ємні - добуток
                arrayC[i] = arrayA[i] * arrayB[i];
            } else {
                // Інші випадки - нуль
                arrayC[i] = 0;
            }
        }
        
        return arrayC;
    }
    
    /**
     * Допоміжний метод для виведення детальної інформації про операції
     */
    private static void displayDetailedResult(int[] arrayA, int[] arrayB, int[] arrayC) {
        System.out.println("Детальна інформація про операції:");
        for (int i = 0; i < arrayA.length; i++) {
            String operation;
            if (arrayA[i] > 0 && arrayB[i] > 0) {
                operation = String.format("%d + %d = %d (обидва додатні)", 
                    arrayA[i], arrayB[i], arrayC[i]);
            } else if (arrayA[i] < 0 && arrayB[i] < 0) {
                operation = String.format("%d * %d = %d (обидва від'ємні)", 
                    arrayA[i], arrayB[i], arrayC[i]);
            } else {
                operation = String.format("%d, %d → 0 (різні знаки або є нуль)", 
                    arrayA[i], arrayB[i]);
            }
            System.out.println("  C[" + i + "]: " + operation);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Завдання 61: Формування масиву C з масивів A і B ===\n");
        
        // Тест 1: Змішані значення
        int[] a1 = {5, -3, 4, -2, 0, 6};
        int[] b1 = {3, -4, -1, -5, 2, 7};
        System.out.println("Тест 1:");
        System.out.println("Масив A: " + java.util.Arrays.toString(a1));
        System.out.println("Масив B: " + java.util.Arrays.toString(b1));
        int[] c1 = formArrayC(a1, b1);
        System.out.println("Масив C: " + java.util.Arrays.toString(c1));
        displayDetailedResult(a1, b1, c1);
        System.out.println();
        
        // Тест 2: Всі додатні
        int[] a2 = {1, 2, 3};
        int[] b2 = {4, 5, 6};
        System.out.println("Тест 2 (всі додатні):");
        System.out.println("Масив A: " + java.util.Arrays.toString(a2));
        System.out.println("Масив B: " + java.util.Arrays.toString(b2));
        int[] c2 = formArrayC(a2, b2);
        System.out.println("Масив C: " + java.util.Arrays.toString(c2));
        displayDetailedResult(a2, b2, c2);
        System.out.println();
        
        // Тест 3: Всі від'ємні
        int[] a3 = {-1, -2, -3};
        int[] b3 = {-4, -5, -6};
        System.out.println("Тест 3 (всі від'ємні):");
        System.out.println("Масив A: " + java.util.Arrays.toString(a3));
        System.out.println("Масив B: " + java.util.Arrays.toString(b3));
        int[] c3 = formArrayC(a3, b3);
        System.out.println("Масив C: " + java.util.Arrays.toString(c3));
        displayDetailedResult(a3, b3, c3);
        System.out.println();
        
        // Тест 4: Різні знаки (результат - нулі)
        int[] a4 = {1, -2, 3, 0};
        int[] b4 = {-1, 2, -3, 5};
        System.out.println("Тест 4 (різні знаки):");
        System.out.println("Масив A: " + java.util.Arrays.toString(a4));
        System.out.println("Масив B: " + java.util.Arrays.toString(b4));
        int[] c4 = formArrayC(a4, b4);
        System.out.println("Масив C: " + java.util.Arrays.toString(c4));
        displayDetailedResult(a4, b4, c4);
        System.out.println();
        
        // Тест 5: Заборонений випадок - різна довжина
        int[] a5 = {1, 2, 3};
        int[] b5 = {4, 5};
        System.out.println("Тест 5 (різна довжина масивів):");
        System.out.println("Масив A: " + java.util.Arrays.toString(a5));
        System.out.println("Масив B: " + java.util.Arrays.toString(b5));
        try {
            formArrayC(a5, b5);
        } catch (IllegalArgumentException e) {
            System.out.println("Виключення: " + e.getMessage());
        }
        System.out.println();
        
        // Тест 6: Заборонений випадок - null
        System.out.println("Тест 6 (null масив):");
        try {
            formArrayC(null, b1);
        } catch (NullPointerException e) {
            System.out.println("Виключення: " + e.getMessage());
        }
    }
}