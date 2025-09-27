import static java.lang.Math.*;

public class Laba2 {
    public static void main(String[] args) {
        // Завдання 1: a = -1.49, b = 23.4, c = 1.23, d = 2.542
        double result1 = calculateTask1(-1.49, 23.4, 1.23, 2.542);
        
        // Завдання 2: a = 2.34, b = 0.756, c = 2.23, d = -1.653
        double result2 = calculateTask2(2.34, 0.756, 2.23, -1.653);
        
        // Завдання 3: a = 1.234, b = -3.12, c = 5.45, d = 2.0
        double result3 = calculateTask3(1.234, -3.12, 5.45, 2.0);

        System.out.println("Завдання 1: y = " + result1 + "\n");
        System.out.println("Завдання 2: y = " + result2 + "\n");
        System.out.println("Завдання 3: y = " + result3 + "\n");
    }

    public static double calculateTask1(double a, double b, double c, double d) {
        // y = √|sin(a) - (4 * ln(b)) / c^d|
        double result = sqrt(abs(sin(a) - (4 * log(b)) / pow(c, d)));
        return result;
    }

    public static double calculateTask2(double a, double b, double c, double d) {
        // y = (e^a + 3 * lg(c)) / √(b^c) * |arctan(d)|
        double result = (exp(a) + 3 * log10(c)) / sqrt(pow(b, c));
        result *= abs(atan(d));
        return result;
    }

    public static double calculateTask3(double a, double b, double c, double d) {
        // y = (2 * sin(a) + cos(b * √c))^d
        double result = pow((2 * sin(a) + cos(b * sqrt(c))), d);
        return result;
    }
}