import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        String filename = "students.dat";

        // Load existing students from file
        List<Student> loadedStudents = FileHandler.loadFromFile(filename);
        loadedStudents.forEach(studentManager::addStudent);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Student Record System");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Find Student");
            System.out.println("5. List Students");
            System.out.println("6. Save to File");
            System.out.println("7. Load from File");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    studentManager.addStudent(new Student(id, name, age));
                    break;
                case 2:
                    System.out.print("Enter ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new Age: ");
                    int newAge = scanner.nextInt();
                    studentManager.updateStudent(updateId, newName, newAge);
                    break;
                case 3:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = scanner.nextInt();
                    studentManager.deleteStudent(deleteId);
                    break;
                case 4:
                    System.out.print("Enter ID to find: ");
                    int findId = scanner.nextInt();
                    Student student = studentManager.findStudent(findId);
                    if (student != null) {
                        System.out.println("Found: " + student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    List<Student> students = studentManager.listStudents();
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        students.forEach(System.out::println);
                    }
                    break;
                case 6:
                    FileHandler.saveToFile(studentManager.listStudents(), filename);
                    System.out.println("Data saved to file.");
                    break;
                case 7:
                    loadedStudents = FileHandler.loadFromFile(filename);
                    loadedStudents.forEach(studentManager::addStudent);
                    System.out.println("Data loaded from file.");
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}