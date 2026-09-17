public class ReportThread extends Thread {

    private Student student;

    public ReportThread(Student student) {

        this.student = student;
    }

    @Override
    public void run() {

        System.out.println(
                "\nGenerating report in a separate thread..."
        );

        AcademicReport.generateReport(student);
    }
}