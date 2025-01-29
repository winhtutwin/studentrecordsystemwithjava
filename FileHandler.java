import java.io.*;
import java.util.ArrayList; // Import ArrayList
import java.util.List;

public class FileHandler {
    public static void saveToFile(List<Student> students, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Student> loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Student>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            return new ArrayList<>(); // Return empty list if file not found
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading from file: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}