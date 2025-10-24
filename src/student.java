import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Добавляем implements Serializable, чтобы объекты можно было сериализовать
class Student implements Serializable {
    private static final long serialVersionUID = 1L; // Для версионирования при сериализации

    String name;
    int studentId;

    // Конструктор по умолчанию (может быть неявно создан, но для ясности добавим)
    public Student() {
    }

    // Конструктор для задания имени и ID
    public Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    // Геттеры (можно добавить сеттеры, если нужно будет изменять поля позже)
    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }

    // Переопределяем toString для удобного вывода информации
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentId=" + studentId +
                '}';
    }
}

public class student implements Serializable {
    private static final long serialVersionUID = 1L;

    String name;
    int studentId;
    private List<String> courses; // Поле для хранения курсов

    // Конструктор по умолчанию
    public student() {
        this.name = "Unknown"; // Значение по умолчанию
        this.studentId = 0;    // Значение по умолчанию
        this.courses = new ArrayList<>(); // Инициализация списка курсов
    }

    // Конструктор, принимающий name и studentId
    public student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
        this.courses = new ArrayList<>(); // Инициализация списка курсов
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }

    // --- Задание 3: Метод printInfo и updateName ---
    public void printInfo() {
        System.out.println("Student Info: Name='" + name + "', ID=" + studentId);
    }

    public void updateName(String newName) {
        if (newName != null && !newName.trim().isEmpty()) {
            this.name = newName;
            System.out.println("Name updated to: " + newName);
        } else {
            System.out.println("Cannot update name with empty or null value.");
        }
    }

    // --- Задание 4: Методы addCourse и listCourses ---
    public void addCourse(String course) {
        if (course != null && !course.trim().isEmpty()) {
            this.courses.add(course);
            System.out.println("Course '" + course + "' added for " + this.name);
        } else {
            System.out.println("Cannot add empty or null course.");
        }
    }

    // Метод listCourses, который принимает BufferedWriter для записи в файл
    public void listCourses(BufferedWriter writer) throws IOException {
        System.out.println("Courses for " + this.name + " (ID: " + this.studentId + "):");
        writer.write("Courses for " + this.name + " (ID: " + this.studentId + "):");
        writer.newLine();

        if (courses.isEmpty()) {
            System.out.println("  No courses registered.");
            writer.write("  No courses registered.");
            writer.newLine();
        } else {
            for (String course : courses) {
                System.out.println("  - " + course);
                writer.write("  - " + course);
                writer.newLine();
            }
        }
    }

    // Переопределяем toString для удобного вывода информации
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentId=" + studentId +
                ", courses=" + courses + // Включим курсы в toString
                '}';
    }
}