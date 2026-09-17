import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public static void saveStudent(Student student) {

        try {

            FileWriter writer =
                    new FileWriter(
                            "data/student_"
                                    + student.getStudentId()
                                    + ".txt"
                    );

            writer.write(
                    "STUDENT ACADEMIC RECORD\n"
            );

            writer.write(
                    "========================\n"
            );

            writer.write(
                    "Student ID: "
                            + student.getStudentId()
                            + "\n"
            );

            writer.write(
                    "Name: "
                            + student.getName()
                            + "\n"
            );

            writer.write(
                    "Department: "
                            + student.getDepartment()
                            + "\n"
            );

            writer.write("\nCOURSES\n");

            for (Course course : student.getCourses()) {

                writer.write(
                        course.getCourseName()
                                + " : "
                                + course.getMarks()
                                + "\n"
                );
            }

            writer.write(
                    "\nTotal Marks: "
                            + student.calculateTotalMarks()
                            + "\n"
            );

            writer.write(
                    "Average Marks: "
                            + student.calculateAverageMarks()
                            + "\n"
            );

            writer.write(
                    "Overall Grade: "
                            + student.calculateGrade()
                            + "\n"
            );

            writer.write("\nATTENDANCE\n");

            writer.write(
                    "Total Classes: "
                            + student.getAttendance()
                            .getTotalClasses()
                            + "\n"
            );

            writer.write(
                    "Attended Classes: "
                            + student.getAttendance()
                            .getAttendedClasses()
                            + "\n"
            );

            writer.write(
                    "Attendance Percentage: "
                            + student.getAttendance()
                            .calculatePercentage()
                            + "%\n"
            );

            writer.close();

            System.out.println(
                    "Student record saved successfully."
            );

        } catch (IOException e) {

            System.out.println(
                    "Error while saving student record."
            );
        }
    }

    // Java I/O stream example
    public static void readStudentRecord(int studentId) {

        String fileName =
                "data/student_" + studentId + ".txt";

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(fileName)
                    );

            String line;

            System.out.println();

            System.out.println(
                    "========== SAVED RECORD =========="
            );

            while ((line = reader.readLine()) != null) {

                System.out.println(line);
            }

            reader.close();

            System.out.println(
                    "=================================="
            );

        } catch (IOException e) {

            System.out.println(
                    "Saved student record not found."
            );
        }
    }
}