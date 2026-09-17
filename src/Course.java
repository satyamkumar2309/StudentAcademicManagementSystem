public class Course {

    private String courseName;
    private double marks;

    public Course(String courseName, double marks) {

        this.courseName = courseName;
        this.marks = marks;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public void displayCourse() {

        System.out.println(
                "  " + courseName + " : " + marks
        );
    }
}