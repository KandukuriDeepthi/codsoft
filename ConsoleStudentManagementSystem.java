package codsoft;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student implements Serializable {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private List<Student> students;
    private String dataFilePath;

    public StudentManagementSystem(String dataFilePath) {
        students = new ArrayList<>();
        this.dataFilePath = dataFilePath;
        loadStudentData();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void saveStudentData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataFilePath))) {
            oos.writeObject(students);
            System.out.println("Student data saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving student data: " + e.getMessage());
        }
    }

    public void loadStudentData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dataFilePath))) {
            students = (List<Student>) ois.readObject();
            System.out.println("Student data loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading student data: " + e.getMessage());
        }
    }
}

public class ConsoleStudentManagementSystem {
    public static void main(String[] args) {
    	String currentDir = System.getProperty("user.dir");
        System.out.println("Current working directory: " + currentDir);
        String dataFilePath = "student_data.ser";
        StudentManagementSystem sms = new StudentManagementSystem(dataFilePath);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Save Student Data");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();

                    if (!name.isEmpty() && rollNumber > 0 && !grade.isEmpty()) {
                        sms.addStudent(new Student(name, rollNumber, grade));
                        System.out.println("Student added successfully.");
                    } else {
                        System.out.println("Invalid input. Please provide valid data.");
                    }
                    break;

                case 2:
                    System.out.print("Enter roll number of student to edit: ");
                    int rollToEdit = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Student studentToEdit = sms.searchStudent(rollToEdit);
                    if (studentToEdit != null) {
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new grade: ");
                        String newGrade = scanner.nextLine();

                        if (!newName.isEmpty() && !newGrade.isEmpty()) {
                            studentToEdit.setName(newName);
                            studentToEdit.setGrade(newGrade);
                            System.out.println("Student information updated successfully.");
                        } else {
                            System.out.println("Invalid input. Please provide valid data.");
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter roll number to search: ");
                    int rollToSearch = scanner.nextInt();
                    Student foundStudent = sms.searchStudent(rollToSearch);
                    if (foundStudent != null) {
                        System.out.println("Found student: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.println("List of all students:");
                    sms.displayAllStudents();
                    break;

                case 5:
                    sms.saveStudentData();
                    break;

                case 6:
                    System.out.println("Exiting the program.");
                    sms.saveStudentData(); // Save data before exit
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}
