public class Task1 {
    public static void main(String[] args) {
        printResults(2, 5);     // нормальні параметри
        printResults(1, 30);    // граничне значення k
        printResults(3, 0);     // помилка: k <= 0
        printResults(2, 31);    // помилка: k > 30
        printResults(-1, 5);    // помилка: m <= 0
    }

    // Метод для обчислення суми ряду
    public static double seriesSum(int m, int k) {
        if (m <= 0) {
            throw new IllegalArgumentException("param m = " + m + " (must be > 0)");
        }
        if (k <= 0 || k > 30) {
            throw new IllegalArgumentException("param k = " + k + " (must be 1..30)");
        }

        double sum = 0.0;
        for (int i = 1; i <= k; i++) {
            // Формула: S += sqrt(m / i) * sin(m * i)
            double term = Math.sqrt((double) m / i) * Math.sin(m * i);
            sum += term;
        }
        return sum;
    }

    // Метод для виведення результатів з обробкою винятків
    static void printResults(int m, int k) {
        System.out.print("m:" + m + " k:" + k + " result: ");
        try {
            System.out.println(seriesSum(m, k));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}