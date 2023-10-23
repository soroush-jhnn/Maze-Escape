public class Student {
    private String studentID;
    private String studentName;
    private double overallScore;

    public Student(String studentID, String studentName, double overallScore) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.overallScore = overallScore;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public double getOverallScore() {
        return overallScore;
    }

    // You can add setter methods for updating student information if needed.

    @Override
    public String toString() {
        return "Student ID: " + studentID + ", Name: " + studentName + ", Overall Score: " + overallScore;
    }
}
