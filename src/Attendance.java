public class Attendance {

    private int totalClasses;
    private int attendedClasses;

    public Attendance() {

        totalClasses = 0;
        attendedClasses = 0;
    }

    public void setAttendance(
            int totalClasses,
            int attendedClasses) {

        this.totalClasses = totalClasses;
        this.attendedClasses = attendedClasses;
    }

    public int getTotalClasses() {
        return totalClasses;
    }

    public int getAttendedClasses() {
        return attendedClasses;
    }

    public double calculatePercentage() {

        if (totalClasses == 0) {
            return 0;
        }

        return ((double) attendedClasses
                / totalClasses) * 100;
    }

    public String getStatus() {

        if (calculatePercentage() >= 75) {
            return "Satisfactory";
        }

        return "Low Attendance";
    }

    public void displayAttendance() {

        System.out.println(
                "  Total Classes    : "
                        + totalClasses
        );

        System.out.println(
                "  Classes Attended : "
                        + attendedClasses
        );

        System.out.println(
                "  Percentage       : "
                        + calculatePercentage()
                        + "%"
        );

        System.out.println(
                "  Status           : "
                        + getStatus()
        );
    }
}