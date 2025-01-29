import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void updateStudent(int id, String name, int age) {
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                students.add(new Student(id, name, age));
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public Student findStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public List<Student> listStudents() {
        return students;
    }
}