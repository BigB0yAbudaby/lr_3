import java.io.*;

public class Main {

    public static void main(String[] args) {
        // --- Задание 1: Создание классов и объектов ---
        System.out.println("--- Задание 1: Запись студентов в students.txt ---");

        // Создаем два объекта Student
        student student1 = new student("Иван Петров", 101);
        student student2 = new student("Мария Сидорова", 102);

        // Путь к файлу
        String fileName1 = "students.txt";

        // Записываем информацию в файл (используем сериализацию для объектов)
        try (FileOutputStream fos = new FileOutputStream(fileName1);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(student1);
            oos.writeObject(student2);

            System.out.println("Информация о студентах успешно записана в " + fileName1);

        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл " + fileName1 + ": " + e.getMessage());
            e.printStackTrace();
        }

        // --- Задание 2: Конструкторы ---
        System.out.println("\n--- Задание 2: Использование конструкторов и запись в constructors.txt ---");

        // Создаем объекты с использованием конструктора (name, studentId)
        student student3 = new student("Алексей Иванов", 103);
        student student4 = new student("Елена Кузнецова", 104);

        // Создаем объект с использованием конструктора по умолчанию
        student student5 = new student();
        student5.name = "Петр Смирнов"; // Устанавливаем поля вручную, так как конструктор по умолчанию не принимал аргументов
        student5.studentId = 105;

        // Файл для конструкторов
        String fileName2 = "constructors.txt";

        // Записываем данные всех объектов в файл
        try (FileOutputStream fos = new FileOutputStream(fileName2);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(student3);
            oos.writeObject(student4);
            oos.writeObject(student5);

            System.out.println("Информация о студентах (с разными конструкторами) успешно записана в " + fileName2);

        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл " + fileName2 + ": " + e.getMessage());
            e.printStackTrace();
        }


        // --- Задание 3: Методы ---
        System.out.println("\n--- Задание 3: Использование метода printInfo и updateName ---");

        // Создаем объект для демонстрации методов
        student studentForMethods = new student("Сергей Волков", 106);

        // Вызываем метод printInfo
        System.out.println("Вызов studentForMethods.printInfo():");
        studentForMethods.printInfo(); // Предполагается, что метод printInfo уже добавлен в Student

        // Изменяем имя студента
        String oldName = studentForMethods.getName();
        String newName = "Сергей Белов";
        studentForMethods.updateName(newName); // Предполагается, что метод updateName уже добавлен

        // Записываем результат в update_log.txt
        String fileName3 = "update_log.txt";
        try (FileWriter fw = new FileWriter(fileName3);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write("Изменение имени студента '" + oldName + "' на '" + newName + "' (ID: " + studentForMethods.getStudentId() + ")");
            bw.newLine();
            bw.write("Новая информация:");
            bw.newLine();
            // Используем printInfo, но перенаправим вывод в файл (сложно без доп. классов)
            // Проще вывести здесь через toString
            bw.write(studentForMethods.toString());
            bw.newLine();

            System.out.println("Информация об изменении имени записана в " + fileName3);

        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл " + fileName3 + ": " + e.getMessage());
            e.printStackTrace();
        }


        // --- Задание 4: Параметры методов ---
        System.out.println("\n--- Задание 4: Использование методов addCourse и listCourses ---");

        // Создаем объект и добавляем курсы
        student studentForCourses = new student("Ольга Попова", 107);
        studentForCourses.addCourse("Java Programming");
        studentForCourses.addCourse("Database Systems");
        studentForCourses.addCourse("Algorithms and Data Structures"); // Добавим еще один курс для примера

        // Вывод списка курсов и запись в courses.txt
        String fileName4 = "courses.txt";
        try (FileWriter fw = new FileWriter(fileName4);
             BufferedWriter bw = new BufferedWriter(fw)) {

            System.out.println("Вызов studentForCourses.listCourses():");
            // Метод listCourses должен выводить в консоль И в файл
            studentForCourses.listCourses(bw); // Передаем writer для записи в файл

            System.out.println("Список курсов записан в " + fileName4);

        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл " + fileName4 + ": " + e.getMessage());
            e.printStackTrace();
        }
    }
}
