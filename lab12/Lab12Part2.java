import java.util.*;
import java.util.stream.Collectors;

public class Lab12Part2 {
    public static void main(String[] args) {
        Institute institute = new Institute("Інститут якийсь");

        Faculty faculty1 = new Faculty("Факультет інформатики та обчислювальної техніки");
        Faculty faculty2 = new Faculty("Факультет електроніки");

        faculty1.addStudent(new Student("Іван", "Іванович", 1001, 85.5));
        faculty1.addStudent(new Student("Марія", "Іванова", 1002, 78.9));
        faculty2.addStudent(new Student("Олег", "Сидоров", 2001, 90.3));
        faculty2.addStudent(new Student("Наталія", "Коваленко", 2002, 82.7));

        institute.addFaculty(faculty1);
        institute.addFaculty(faculty2);

        // Завдання 2. Виводимо список студентів інституту з середнім балом вищим за середній бал по інституту
        List<Student> studentsWithHigherGrade = institute.getStudentsWithHigherAverageGrade();
        System.out.println("Список студентів інституту з середнім балом вищим за середній бал по інституту:");
        studentsWithHigherGrade.forEach(System.out::println);
    }
}

class Student {
    private String firstName;
    private String lastName;
    private int studentId;
    private double averageGrade;

    public Student(String firstName, String lastName, int studentId, double averageGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.averageGrade = averageGrade;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (ID: " + studentId + ")";
    }
}

class Faculty {
    private String name;
    private List<Student> students;

    public Faculty(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }
}

class Institute {
    private String name;
    private List<Faculty> faculties;

    public Institute(String name) {
        this.name = name;
        this.faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    // Метод для отримання списку всіх студентів інституту з середнім балом вищим за середній бал по інституту
    public List<Student> getStudentsWithHigherAverageGrade() {
        // Розраховуємо середній бал по інституту
        double instituteAverageGrade = faculties.stream()
                .flatMap(faculty -> faculty.getStudents().stream())
                .mapToDouble(Student::getAverageGrade)
                .average()
                .orElse(0.0);

        // Фільтруємо студентів з середнім балом вищим за середній бал по інституту
        return faculties.stream()
                .flatMap(faculty -> faculty.getStudents().stream())
                .filter(student -> student.getAverageGrade() > instituteAverageGrade)
                .collect(Collectors.toList());
    }
}