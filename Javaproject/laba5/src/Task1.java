import java.util.Arrays;

public class Task1 {
    
    /**
     * Сортування бульбашкою (Bubble Sort)
     * Порівнює сусідні елементи та обмінює їх, якщо вони в неправильному порядку
     */
    public static void bubbleSort(byte[] arr) {
        int n = arr.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            // Останні i елементів вже на своїх місцях
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Обмін елементів
                    byte temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // Якщо не було обмінів, масив вже відсортований
            if (!swapped) {
                break;
            }
        }
    }
    
    /**
     * Сортування вибором (Selection Sort)
     * Знаходить мінімальний елемент і ставить його на початок
     */
    public static void selectionSort(byte[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            // Знаходимо індекс мінімального елемента
            int minIdx = i;
            
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            
            // Обмінюємо знайдений мінімальний елемент з першим
            if (minIdx != i) {
                byte temp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = temp;
            }
        }
    }
    
    /**
     * Допоміжний метод для виведення масиву
     */
    public static void printArray(byte[] arr, String label) {
        System.out.println(label + ": " + Arrays.toString(arr));
    }
    
    /**
     * Головний метод для тестування
     */
    public static void main(String[] args) {
        // Тестові дані
        byte[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        byte[] arr2 = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("=== СОРТУВАННЯ БУЛЬБАШКОЮ (BUBBLE SORT) ===");
        printArray(arr1, "Початковий масив");
        
        long startTime = System.nanoTime();
        bubbleSort(arr1);
        long endTime = System.nanoTime();
        
        printArray(arr1, "Відсортований масив");
        System.out.println("Час виконання: " + (endTime - startTime) + " нс\n");
        
        System.out.println("=== СОРТУВАННЯ ВИБОРОМ (SELECTION SORT) ===");
        printArray(arr2, "Початковий масив");
        
        startTime = System.nanoTime();
        selectionSort(arr2);
        endTime = System.nanoTime();
        
        printArray(arr2, "Відсортований масив");
        System.out.println("Час виконання: " + (endTime - startTime) + " нс\n");
        
        // Додатковий тест з різними випадками
        System.out.println("=== ДОДАТКОВІ ТЕСТИ ===");
        
        // Вже відсортований масив
        byte[] sortedArr = {1, 2, 3, 4, 5};
        byte[] sortedArr2 = sortedArr.clone();
        System.out.println("\nВже відсортований масив:");
        testBothMethods(sortedArr, sortedArr2);
        
        // Зворотно відсортований масив
        byte[] reverseArr = {5, 4, 3, 2, 1};
        byte[] reverseArr2 = reverseArr.clone();
        System.out.println("\nЗворотно відсортований масив:");
        testBothMethods(reverseArr, reverseArr2);
        
        // Масив з однаковими елементами
        byte[] sameArr = {3, 3, 3, 3, 3};
        byte[] sameArr2 = sameArr.clone();
        System.out.println("\nМасив з однаковими елементами:");
        testBothMethods(sameArr, sameArr2);
    }
    
    /**
     * Тестування обох методів сортування
     */
    private static void testBothMethods(byte[] arr1, byte[] arr2) {
        printArray(arr1, "Початковий");
        
        long start1 = System.nanoTime();
        bubbleSort(arr1);
        long time1 = System.nanoTime() - start1;
        
        long start2 = System.nanoTime();
        selectionSort(arr2);
        long time2 = System.nanoTime() - start2;
        
        System.out.println("Bubble Sort: " + time1 + " нс");
        System.out.println("Selection Sort: " + time2 + " нс");
    }
}