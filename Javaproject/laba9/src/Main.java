import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee {
    String firstName;
    String lastName;
    double salary;

    public Employee(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + salary + ")";
    }
}

class Department {
    String name;
    Employee head;
    List<Employee> employees;

    public Department(String name, Employee head, List<Employee> employees) {
        this.name = name;
        this.head = head;
        this.employees = employees;
    }

    public Employee getHead() {
        return head;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}

class Company {
    String name;
    Employee director;
    List<Department> departments;

    public Company(String name, Employee director, List<Department> departments) {
        this.name = name;
        this.director = director;
        this.departments = departments;
    }

    public Employee getDirector() {
        return director;
    }

    public List<Department> getDepartments() {
        return departments;
    }
}

public class Main {
    public static void main(String[] args) {

        // 🔹 Працівники
        Employee e1 = new Employee("Іван", "Іваненко", 1000);
        Employee e2 = new Employee("Петро", "Петренко", 2000);
        Employee e3 = new Employee("Олег", "Олегов", 1500);

        Employee e4 = new Employee("Марія", "Марченко", 3000);
        Employee e5 = new Employee("Анна", "Ананьєва", 1200);

        // 🔹 Начальники
        Employee head1 = new Employee("Сергій", "Сергієнко", 1800);
        Employee head2 = new Employee("Оксана", "Оксаненко", 2500);

        // 🔹 Директор
        Employee director = new Employee("Директор", "Головний", 5000);

        // 🔹 Відділи
        Department d1 = new Department("IT", head1, Arrays.asList(e1, e2, e3));
        Department d2 = new Department("HR", head2, Arrays.asList(e4, e5));

        Company company = new Company("MyCompany", director, Arrays.asList(d1, d2));

        // =========================
        // ✅ 1. Максимальна зарплата (ЧИСТО через Stream)
        double maxSalary = Stream.concat(
                company.getDepartments().stream()
                        .flatMap(d -> Stream.concat(
                                d.getEmployees().stream(),
                                Stream.of(d.getHead())
                        )),
                Stream.of(company.getDirector())
        ).mapToDouble(Employee::getSalary)
         .max()
         .orElse(0);

        System.out.println("Max salary: " + maxSalary);

        // =========================
        // ✅ 2. Відділи де працівник > начальника
        List<Department> result = company.getDepartments().stream()
                .filter(dept -> dept.getEmployees().stream()
                        .anyMatch(emp -> emp.getSalary() > dept.getHead().getSalary()))
                .collect(Collectors.toList());

        System.out.println("Departments where employee earns more than head:");
        result.forEach(d -> System.out.println(d.name));

        // =========================
        // ✅ 3. Всі співробітники (через Stream)
        List<Employee> allEmployees = Stream.concat(
                company.getDepartments().stream()
                        .flatMap(dept -> Stream.concat(
                                dept.getEmployees().stream(),
                                Stream.of(dept.getHead())
                        )),
                Stream.of(company.getDirector())
        ).collect(Collectors.toList());

        System.out.println("All employees:");
        allEmployees.forEach(System.out::println);
    }
}