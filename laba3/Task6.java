public class Task6 {
    public static void main(String[] args) {
        printResults(4, 1);   // sqrt(t)
        printResults(9, 2);   // 1/sqrt(t)
        printResults(2, 5);   // сума
        printResults(-4, 1);  // помилка: sqrt від від’ємного
        printResults(0, 2);   // помилка: ділення на нуль
        printResults(3, 0);   // помилка: i <= 0
    }

    public static double xFunc(double t, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("param i = " + i + " (must be > 0)");
        }

        switch (i) {
            case 1:
                if (t < 0) {
                    throw new IllegalArgumentException("sqrt of negative t = " + t);
                }
                return Math.sqrt(t);
            case 2:
                if (t <= 0) {
                    throw new IllegalArgumentException("t must be > 0 for 1/sqrt(t)");
                }
                return 1.0 / Math.sqrt(t);
            default:
                double sum = 0.0;
                for (int k = 1; k <= i; k++) {
                    sum += k * t;
                }
                return sum;
        }
    }

    static void printResults(double t, int i) {
        System.out.print("t:" + t + " i:" + i + " result:");
        try {
            System.out.println(xFunc(t, i));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}