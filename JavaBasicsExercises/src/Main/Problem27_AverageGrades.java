package Main;

import java.util.*;

public class Problem27_AverageGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentsCount = Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<>(studentsCount);
        for (int i = 0; i < studentsCount; i++) {
            String studentData = scanner.nextLine();
            String[] dataSplitted = studentData.split(" ");
            String studentName = dataSplitted[0];
            List<Double> studentGrades = new ArrayList<>(dataSplitted.length);
            for (int gradeIndex = 1; gradeIndex < dataSplitted.length; gradeIndex++) {
                studentGrades.add(Double.parseDouble(dataSplitted[gradeIndex]));
            }

            Student student = new Student(studentName, studentGrades);
            students.add(student);
        }

        Student [] toPrintStudents =
                students
                .stream()
                .filter(student -> student.getAverageGrade() >= 5d)
                .sorted(Comparator.comparing((Student student) -> student.getName())
                        .thenComparing(Comparator.comparing((Student s) -> s.getAverageGrade())
                                .reversed()))
                .toArray(Student [] ::new);

        for (Student student : toPrintStudents) {
            System.out.printf("%s -> %.2f", student.getName(), student.getAverageGrade());
            System.out.println();
        }
    }
}

final class Student{
    private final String name;
    private final List<Double> grades;
    private final double averageGrade;

    public Student(String name, List<Double> grades) {
        this.name = name;
        this.grades = grades;
        this.averageGrade = this.calculateAverageGrade();
    }

    public final String getName() {
        return name;
    }

    public final double getAverageGrade(){
        return this.averageGrade;
    }

    private double calculateAverageGrade(){
        OptionalDouble  averageGrade = grades
                .stream()
                .mapToDouble(grade -> grade)
                .average();
        return averageGrade.orElse(0);
    }

}
