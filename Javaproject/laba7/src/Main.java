import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Student> s1 = new ArrayList<>();
        s1.add(new Student("Ivan", "Ivanov", "AB123", 97));
        s1.add(new Student("Petro", "Petrenko", "AB124", 88));

        List<Student> s2 = new ArrayList<>();
        s2.add(new Student("Olga", "Stepanenko", "BC001", 95));
        s2.add(new Student("Max", "Koval", "BC002", 79));
        s2.add(new Student("Anna", "Lysenko", "BC003", 99));

        Faculty f1 = new Faculty("Faculty of IT", s1);
        Faculty f2 = new Faculty("Faculty of Telecom", s2);

        Institute inst = new Institute("KPI", List.of(f1, f2));

        // ---- ЗАДАЧА 1 (нетипізований iterator) ----
        int totalStudents = 0;
        Iterator facIter = inst.getFaculties().iterator(); // без generics

        while (facIter.hasNext()) {
            Faculty fac = (Faculty) facIter.next();
            totalStudents += fac.getStudents().size();
        }
        System.out.println("Загальна кількість студентів: " + totalStudents);

        // ---- ЗАДАЧА 2 (типізований iterator) ----
        Faculty maxFaculty = null;
        int maxCount = -1;

        Iterator<Faculty> typedIter = inst.getFaculties().iterator();
        while (typedIter.hasNext()) {
            Faculty fac = typedIter.next();
            int count = fac.getStudents().size();
            if (count > maxCount) {
                maxCount = count;
                maxFaculty = fac;
            }
        }
        System.out.println("Факультет з найбільшою кількістю студентів: " + maxFaculty.getName());

        // ---- ЗАДАЧА 3 (for-each) ----
        List<Student> excellent = new ArrayList<>();

        for (Faculty faculty : inst.getFaculties()) {
            for (Student st : faculty.getStudents()) {
                if (st.getAverageScore() >= 95 && st.getAverageScore() <= 100) {
                    excellent.add(st);
                }
            }
        }

        System.out.println("Студенти з середнім балом 95..100:");
        excellent.forEach(System.out::println);
    }
}
