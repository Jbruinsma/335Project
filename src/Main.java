import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String inputFileName = "unsorted_students.txt";
        String outputFileName = "sorted_students.txt";

        List<Student> studentList = new ArrayList<>();

        // Read from the student records input file

        try {
            List<String> lines = Files.readAllLines(Path.of(inputFileName));

            for (String line : lines) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",");

                if (parts.length == 4) {
                    try {
                        String id = parts[0].trim();
                        String name = parts[1].trim();
                        int age = Integer.parseInt(parts[2].trim());
                        float gpa = Float.parseFloat(parts[3].trim());

                        Student student = new Student(id, name, age, gpa);
                        studentList.add(student);

                    } catch (NumberFormatException e) {
                        System.err.println("Skipping line because of invalid age or GPA: " + line);
                    } catch (IllegalArgumentException e) {
                        // Handles the invalid age or gpa exceptions I force in the Student constructor
                        System.err.println("Skipping invalid data line: " + e.getMessage() + " | Line: " + line);
                    }
                } else {
                    System.err.println("Skipping line (wrong number of fields): " + line);
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }

        Student[] studentArray = studentList.toArray(new Student[0]);

        // c1. Print each student before sorting
        printStudents(studentArray, "before");

        // Sort the students using Binary Insertion Sort
        BinaryInsertionSort.binaryInsertionSort(studentArray);

        // c2. Print each student after sorting
        printStudents(studentArray, "after");

        // b. Write the sorted students to a new output file

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

            for (Student student : studentArray) {
                String line = String.format("%s,%s,%d,%.2f",
                        student.id,
                        student.name,
                        student.age,
                        student.gpa
                );

                writer.write(line);
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

    public static void printStudents(Student[] students, String verb) {
        System.out.println("--- Students " + verb + " Sorting: (" + students.length + ") ---\n");
        printStudentObjects(students);
        System.out.println("----------------------------------------\n\n");
    }

    public static void printStudentObjects(Student[] students) {
        for (Student student : students) {
            System.out.println(student + "\n");
        }
    }

}
