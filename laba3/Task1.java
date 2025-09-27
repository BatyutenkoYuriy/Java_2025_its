public class Task1 {
    public static void main(String[] args) {
        printResults(2, 5);     // нормальні параметри
        printResults(1, 30);    // граничне значення k
        printResults(3, 0);     // помилка: k <= 0
        printResults(2, 31);    // помилка: k > 30
        printResults(-1, 5);    // помилка: m <= 0
    }

    public static double seriesSum(int m, int k) {
        if (m <= 0) {
            throw new IllegalArgumentException("param m = " + m + " (must be > 0)");
        }
        if (k <= 0 || k > 30) {
            throw new IllegalArgumentException("param k = " + k + " (must be 1..30)");
        }

        double sum = 0.0;
        for (int i = 1; i <= k; i++) {
            double term = m * (1.0 / i) * Math.sin(m * i);
            if (term < 0) {
                throw new IllegalArgumentException("sqrt of negative value at i=" + i);
            }
            sum += Math.sqrt(term);
        }
        return sum;
    }

    static void printResults(int m, int k) {
        System.out.print("m:" + m + " k:" + k + " result:");
        try {
            System.out.println(seriesSum(m, k));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
