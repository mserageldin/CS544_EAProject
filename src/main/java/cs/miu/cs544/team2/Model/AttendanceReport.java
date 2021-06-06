package cs.miu.cs544.team2.Model;


public class AttendanceReport {
    private String firstName;
    private String lastName;
    private String studentId;
    private int attendanceRecord;

    public AttendanceReport(String firstName, String lastName, String studentId, int attendanceRecord) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.attendanceRecord = attendanceRecord;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getAttendanceRecord() {
        return attendanceRecord;
    }

    public void setAttendanceRecord(int attendanceRecord) {
        this.attendanceRecord = attendanceRecord;
    }
}
