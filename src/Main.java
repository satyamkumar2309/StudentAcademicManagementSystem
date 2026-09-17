import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static BufferedReader input =
            new BufferedReader(
                    new InputStreamReader(System.in)
            );

    static ArrayList<Student> students =
            new ArrayList<>();

    public static void main(String[] args) {

        int choice = 0;

        System.out.println();

        System.out.println(
                "=========================================="
        );

        System.out.println(
                "   STUDENT ACADEMIC MANAGEMENT SYSTEM"
        );

        System.out.println(
                "=========================================="
        );

        do {

            try {

                displayMenu();

                System.out.print(
                        "Enter your choice: "
                );

                choice =
                        Integer.parseInt(
                                input.readLine()
                        );

                switch (choice) {

                    case 1:
                        addStudent();
                        break;

                    case 2:
                        displayAllStudents();
                        break;

                    case 3:
                        searchStudent();
                        break;

                    case 4:
                        updateStudent();
                        break;

                    case 5:
                        deleteStudent();
                        break;

                    case 6:
                        addCourse();
                        break;

                    case 7:
                        addAttendance();
                        break;

                    case 8:
                        generateReport();
                        break;

                    case 9:
                        saveStudentRecord();
                        break;

                    case 10:
                        readStudentRecord();
                        break;

                    case 11:
                        demonstratePolymorphism();
                        break;

                    case 12:
                        calculateFactorial();
                        break;

                    case 13:
                        System.out.println(
                                "\nThank you for using the system!"
                        );
                        break;

                    default:
                        System.out.println(
                                "Invalid choice."
                        );
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );

            } catch (IOException e) {

                System.out.println(
                        "Input error occurred."
                );
            }

        } while (choice != 13);
    }

    static void displayMenu() {

        System.out.println();

        System.out.println(
                "--------------- MENU ----------------"
        );

        System.out.println("1. Add Student");

        System.out.println("2. Display All Students");

        System.out.println("3. Search Student");

        System.out.println("4. Update Student");

        System.out.println("5. Delete Student");

        System.out.println("6. Add Course Marks");

        System.out.println("7. Add Attendance");

        System.out.println("8. Generate Academic Report");

        System.out.println("9. Save Student Record");

        System.out.println("10. Read Saved Student Record");

        System.out.println("11. Demonstrate Runtime Polymorphism");

        System.out.println("12. Calculate Factorial");

        System.out.println("13. Exit");

        System.out.println(
                "-------------------------------------"
        );
    }

    static void addStudent() {

        try {

            System.out.print(
                    "Enter Student ID: "
            );

            int id =
                    Integer.parseInt(
                            input.readLine()
                    );

            for (Student student : students) {

                if (student.getStudentId() == id) {

                    System.out.println(
                            "Student ID already exists."
                    );

                    return;
                }
            }

            System.out.print(
                    "Enter Student Name: "
            );

            String name =
                    input.readLine();

            if (name.trim().isEmpty()) {

                System.out.println(
                        "Name cannot be empty."
                );

                return;
            }

            System.out.print(
                    "Enter Department: "
            );

            String department =
                    input.readLine();

            if (department.trim().isEmpty()) {

                System.out.println(
                        "Department cannot be empty."
                );

                return;
            }

            Student student =
                    new Student(
                            id,
                            name,
                            department
                    );

            students.add(student);

            System.out.println(
                    "Student added successfully."
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "Invalid Student ID."
            );

        } catch (IOException e) {

            System.out.println(
                    "Error while reading input."
            );
        }
    }

    static void displayAllStudents() {

        if (students.isEmpty()) {

            System.out.println(
                    "No students available."
            );

            return;
        }

        for (Student student : students) {

            student.displayStudent();
        }
    }

    static Student findStudent(int id) {

        for (Student student : students) {

            if (student.getStudentId() == id) {

                return student;
            }
        }

        return null;
    }

    static void searchStudent() {

        try {

            System.out.print(
                    "Enter Student ID: "
            );

            int id =
                    Integer.parseInt(
                            input.readLine()
                    );

            Student student =
                    findStudent(id);

            if (student == null) {

                System.out.println(
                        "Student not found."
                );

            } else {

                student.displayStudent();
            }

        } catch (NumberFormatException e) {

            System.out.println(
                    "Invalid Student ID."
            );

        } catch (IOException e) {

            System.out.println(
                    "Input error."
            );
        }
    }

    static void updateStudent() {

        try {

            System.out.print(
                    "Enter Student ID: "
            );

            int id =
                    Integer.parseInt(
                            input.readLine()
                    );

            Student student =
                    findStudent(id);

            if (student == null) {

                System.out.println(
                        "Student not found."
                );

                return;
            }

            System.out.print(
                    "Enter new name: "
            );

            String name =
                    input.readLine();

            System.out.print(
                    "Enter new department: "
            );

            String department =
                    input.readLine();

            if (name.trim().isEmpty()
                    || department.trim().isEmpty()) {

                System.out.println(
                        "Fields cannot be empty."
                );

                return;
            }

            student.setName(name);

            student.setDepartment(department);

            System.out.println(
                    "Student updated successfully."
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "Invalid Student ID."
            );

        } catch (IOException e) {

            System.out.println(
                    "Input error."
            );
        }
    }

    static void deleteStudent() {

        try {

            System.out.print(
                    "Enter Student ID: "
            );

            int id =
                    Integer.parseInt(
                            input.readLine()
                    );

            Student student =
                    findStudent(id);

            if (student == null) {

                System.out.println(
                        "Student not found."
                );

                return;
            }

            students.remove(student);

            System.out.println(
                    "Student deleted successfully."
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "Invalid Student ID."
            );

        } catch (IOException e) {

            System.out.println(
                    "Input error."
            );
        }
    }

    static void addCourse() {

        try {

            System.out.print(
                    "Enter Student ID: "
            );

            int id =
                    Integer.parseInt(
                            input.readLine()
                    );

            Student student =
                    findStudent(id);

            if (student == null) {

                System.out.println(
                        "Student not found."
                );

                return;
            }

            System.out.print(
                    "Enter Course Name: "
            );

            String courseName =
                    input.readLine();

            if (courseName.trim().isEmpty()) {

                System.out.println(
                        "Course name cannot be empty."
                );

                return;
            }

            System.out.print(
                    "Enter Marks (0-100): "
            );

            double marks =
                    Double.parseDouble(
                            input.readLine()
                    );

            if (marks < 0 || marks > 100) {

                System.out.println(
                        "Marks must be between 0 and 100."
                );

                return;
            }

            // Using overloaded method
            student.addCourse(
                    courseName,
                    marks
            );

            System.out.println(
                    "Course marks added successfully."
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "Please enter valid numeric values."
            );

        } catch (IOException e) {

            System.out.println(
                    "Input error."
            );
        }
    }

    static void addAttendance() {

        try {

            System.out.print(
                    "Enter Student ID: "
            );

            int id =
                    Integer.parseInt(
                            input.readLine()
                    );

            Student student =
                    findStudent(id);

            if (student == null) {

                System.out.println(
                        "Student not found."
                );

                return;
            }

            System.out.print(
                    "Enter Total Classes: "
            );

            int total =
                    Integer.parseInt(
                            input.readLine()
                    );

            System.out.print(
                    "Enter Attended Classes: "
            );

            int attended =
                    Integer.parseInt(
                            input.readLine()
                    );

            if (total <= 0) {

                System.out.println(
                        "Total classes must be greater than zero."
                );

                return;
            }

            if (attended < 0
                    || attended > total) {

                System.out.println(
                        "Invalid attendance values."
                );

                return;
            }

            student.getAttendance()
                    .setAttendance(
                            total,
                            attended
                    );

            System.out.println(
                    "Attendance added successfully."
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "Please enter valid numbers."
            );

        } catch (IOException e) {

            System.out.println(
                    "Input error."
            );
        }
    }

    static void generateReport() {

        try {

            System.out.print(
                    "Enter Student ID: "
            );

            int id =
                    Integer.parseInt(
                            input.readLine()
                    );

            Student student =
                    findStudent(id);

            if (student == null) {

                System.out.println(
                        "Student not found."
                );

                return;
            }

            // Using overloaded static method
            AcademicReport.generateReport(
                    student,
                    true
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "Invalid Student ID."
            );

        } catch (IOException e) {

            System.out.println(
                    "Input error."
            );
        }
    }

    static void saveStudentRecord() {

        try {

            System.out.print(
                    "Enter Student ID: "
            );

            int id =
                    Integer.parseInt(
                            input.readLine()
                    );

            Student student =
                    findStudent(id);

            if (student == null) {

                System.out.println(
                        "Student not found."
                );

                return;
            }

            FileManager.saveStudent(student);

        } catch (NumberFormatException e) {

            System.out.println(
                    "Invalid Student ID."
            );

        } catch (IOException e) {

            System.out.println(
                    "Input error."
            );
        }
    }

    static void readStudentRecord() {

        try {

            System.out.print(
                    "Enter Student ID: "
            );

            int id =
                    Integer.parseInt(
                            input.readLine()
                    );

            FileManager.readStudentRecord(id);

        } catch (NumberFormatException e) {

            System.out.println(
                    "Invalid Student ID."
            );

        } catch (IOException e) {

            System.out.println(
                    "Input error."
            );
        }
    }

    // Runtime polymorphism / dynamic method dispatch
    static void demonstratePolymorphism() {

        if (students.isEmpty()) {

            System.out.println(
                    "Add a student first."
            );

            return;
        }

        Person person = students.get(0);

        System.out.println(
                "\nRuntime Polymorphism Demonstration"
        );

        System.out.println(
                "Person reference is referring to a Student object."
        );

        person.displayInfo();
    }

    // Factorial using looping statements
    static void calculateFactorial() {

        try {

            System.out.print(
                    "Enter a non-negative integer: "
            );

            int number =
                    Integer.parseInt(
                            input.readLine()
                    );

            if (number < 0) {

                System.out.println(
                        "Number cannot be negative."
                );

                return;
            }

            long factorial = 1;

            for (int i = 1; i <= number; i++) {

                factorial *= i;
            }

            System.out.println(
                    "Factorial of "
                            + number
                            + " = "
                            + factorial
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "Please enter a valid integer."
            );

        } catch (IOException e) {

            System.out.println(
                    "Input error."
            );
        }
    }
}