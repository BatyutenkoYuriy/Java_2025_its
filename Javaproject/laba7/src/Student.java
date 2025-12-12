public class Student {
    private String firstName;
    private String lastName;
    private String bookNumber;
    private double averageScore;

    public Student(String firstName, String lastName, String bookNumber, double averageScore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bookNumber = bookNumber;
        this.averageScore = averageScore;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return getFullName() + " (" + bookNumber + "), avg=" + averageScore;
    }
}
