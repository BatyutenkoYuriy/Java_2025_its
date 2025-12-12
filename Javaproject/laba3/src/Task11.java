public class Task11 {
    public static void main(String[] args) {
        printResults(0.01);     // нормальна точність
        printResults(1e-6);     // більша точність
        printResults(-0.5);     // помилка: ε <= 0
        printResults(0);        // помилка: ε <= 0
    }

    public static double infiniteSum(double eps) {
        if (eps <= 0) {
            throw new IllegalArgumentException("eps = " + eps + " (must be > 0)");
        }

        double sum = 0.0;
        int i = 1;
        while (true) {
            double term = 1.0 / (i * i);
            if (term < eps) {
                break;
            }
            sum += term;
            i++;
        }
        return sum;
    }

    static void printResults(double eps) {
        System.out.print("eps:" + eps + " result:");
        try {
            System.out.println(infiniteSum(eps));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
