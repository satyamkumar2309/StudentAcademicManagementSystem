public class AcademicReport {

    // Static method
    public static void generateReport(Student student) {

        System.out.println();

        System.out.println(
                "=========================================="
        );

        System.out.println(
                "       ACADEMIC PERFORMANCE REPORT"
        );

        System.out.println(
                "=========================================="
        );

        System.out.println(
                "Student ID   : "
                        + student.getStudentId()
        );

        System.out.println(
                "Student Name : "
                        + student.getName()
        );

        System.out.println(
                "Department   : "
                        + student.getDepartment()
        );

        System.out.println("\nCourse Performance:");

        if (student.getCourses().isEmpty()) {

            System.out.println(
                    "No course records available."
            );

        } else {

            for (Course course : student.getCourses()) {
                course.displayCourse();
            }

            System.out.println(
                    "\nTotal Marks   : "
                            + student.calculateTotalMarks()
            );

            System.out.println(
                    "Average Marks : "
                            + student.calculateAverageMarks()
            );

            System.out.println(
                    "Overall Grade : "
                            + student.calculateGrade()
            );
        }

        System.out.println("\nAttendance:");

        student.getAttendance().displayAttendance();

        System.out.println(
                "=========================================="
        );
    }

    // Static method overloading
    public static void generateReport(
            Student student,
            boolean detailed) {

        if (detailed) {

            generateReport(student);

        } else {

            System.out.println();

            System.out.println(
                    "Student : " + student.getName()
            );

            System.out.println(
                    "Average : "
                            + student.calculateAverageMarks()
            );

            System.out.println(
                    "Grade   : "
                            + student.calculateGrade()
            );
        }
    }
}