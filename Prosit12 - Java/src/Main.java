import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        // Creating some student instances
        Etudiant student1 = new Etudiant(1, "Alice", 20);
        Etudiant student2 = new Etudiant(2, "Bob", 22);
        Etudiant student3 = new Etudiant(3, "Charlie", 21);

        // Creating a list of students
        List<Etudiant> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        // Creating an instance of StudentManagement
        StudentManagement studentManagement = new StudentManagement();

        // Displaying all students using forEach
        System.out.println("All students:");
        studentManagement.displayStudents(students, System.out::println);

        // Displaying students filtered by age
        System.out.println("\nStudents older than 20:");
        Predicate<Etudiant> filterByAge = student -> student.getAge() > 20;
        studentManagement.displayStudentsByFilter(students, filterByAge, System.out::println);

        // Getting names of all students
        System.out.println("\nNames of all students:");
        Function<Etudiant, String> getStudentName = Etudiant::getNom;
        String allNames = studentManagement.returnStudentsNames(students, getStudentName);
        System.out.println(allNames);

        // Creating a new student using Supplier
        System.out.println("\nCreating a new student:");
        Supplier<Etudiant> createNewStudent = () -> new Etudiant(4, "David", 23);
        Etudiant newStudent = studentManagement.createStudent(createNewStudent);
        System.out.println(newStudent);

        // Sorting students by ID
        System.out.println("\nSorting students by ID:");
        Comparator<Etudiant> compareById = Comparator.comparingInt(Etudiant::getId);
        List<Etudiant> sortedStudents = studentManagement.sortStudentsById(students, compareById);
        sortedStudents.forEach(System.out::println);

        // Converting students list to a stream
        System.out.println("\nConverting students list to a stream:");
        studentManagement.convertToStream(students).forEach(System.out::println);
    }
}
