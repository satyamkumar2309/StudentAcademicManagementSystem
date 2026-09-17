import java.util.ArrayList;

public class Student extends Person implements Printable {

    private String department;
    private ArrayList<Course> courses;
    private Attendance attendance;

    // Constructor
    public Student(int studentId, String name, String department) {

        // Calling base class constructor using super
        super(studentId, name);

        this.department = department;
        this.courses = new ArrayList<>();
        this.attendance = new Attendance();
    }

    public int getStudentId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Method overloading
    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addCourse(String courseName, double marks) {
        courses.add(new Course(courseName, marks));
    }

    public double calculateTotalMarks() {

        double total = 0;

        for (Course course : courses) {
            total += course.getMarks();
        }

        return total;
    }

    public double calculateAverageMarks() {

        if (courses.isEmpty()) {
            return 0;
        }

        return calculateTotalMarks() / courses.size();
    }

    // Static method
    public static String calculateGrade(double average) {

        if (average >= 90) {
            return "A+";

        } else if (average >= 80) {
            return "A";

        } else if (average >= 70) {
            return "B";

        } else if (average >= 60) {
            return "C";

        } else if (average >= 50) {
            return "D";

        } else {
            return "F";
        }
    }

    // Method overloading
    public String calculateGrade() {
        return calculateGrade(calculateAverageMarks());
    }

    // Method overriding
    @Override
    public void displayInfo() {

        System.out.println("Student ID   : " + id);
        System.out.println("Student Name : " + name);
        System.out.println("Department   : " + department);
    }

    // Interface implementation
    @Override
    public void printDetails() {

        displayInfo();

        System.out.println(
                "Number of Courses : " + courses.size()
        );

        System.out.println(
                "Average Marks     : "
                        + calculateAverageMarks()
        );

        System.out.println(
                "Overall Grade     : "
                        + calculateGrade()
        );
    }

    public void displayStudent() {

        System.out.println(
                "------------------------------------------"
        );

        // Calling base class method using super
        super.displayInfo();

        System.out.println(
                "Department       : " + department
        );

        System.out.println("\nCourse Details:");

        if (courses.isEmpty()) {

            System.out.println("No course records.");

        } else {

            for (Course course : courses) {
                course.displayCourse();
            }

            System.out.println(
                    "Total Marks      : "
                            + calculateTotalMarks()
            );

            System.out.println(
                    "Average Marks    : "
                            + calculateAverageMarks()
            );

            System.out.println(
                    "Overall Grade    : "
                            + calculateGrade()
            );
        }

        System.out.println("\nAttendance:");

        attendance.displayAttendance();

        System.out.println(
                "------------------------------------------"
        );
    }
}