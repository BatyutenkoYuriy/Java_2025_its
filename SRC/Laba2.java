public class Laba2 {
    public static void main(String[] args) {
        // Завдання 1: a = -1.49, b = 23.4, c = 1.23, d = 2.542
        double a1 = -1.49, b1 = 23.4, c1 = 1.23, d1 = 2.542;
        double y1 = Math.sqrt(Math.abs(Math.sin(a1) - (4 * Math.log(b1)) / Math.pow(c1, d1)));
        System.out.println("Завдання qweq 1: y = " + y1);

        // Завдання 2: a = 2.34, b = 0.756, c = 2.23, d = -1.653
        double a2 = 2.34, b2 = 0.756, c2 = 2.23, d2 = -1.653;
        double y2 = (Math.pow(Math.E, a2) + 3 * (Math.log10(c2))) / Math.sqrt(Math.pow(b2, c2));
        y2 *= Math.abs(Math.atan(d2));
        System.out.println("Завдання 2: y = " + y2);

        // Завдання 3: a = 1.234, b = -3.12, c = 5.45, d = 2.0
        double a3 = 1.234, b3 = -3.12, c3 = 5.45, d3 = 2.0;
        double y3 = Math.pow((2 * Math.sin(a3) + Math.cos(b3 * Math.sqrt(c3))), d3);
        System.out.println("Завдання 3: y = " + y3);
    }
}
