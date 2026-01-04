import java.util.ArrayList;

public class Course {
    private String courseCode;
    private String courseName;
    private String instructorId;
    private int credits;
    private int capacity;
    private String semester; // e.g., "Fall 2024"

    private ArrayList<String> enrolledStudents;

    private String[] sessionTimes;
    private int sessionCount;

    public Course(String courseCode, String courseName, String instructorId,
                  int credits, int capacity, String semester) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructorId = instructorId;
        this.credits = credits;
        this.capacity = capacity;
        this.semester = semester;
        this.enrolledStudents = new ArrayList<String>();
        this.sessionTimes = new String[5]; // Maximum 5 sessions per week
        this.sessionCount = 0;
    }

    public Course(String courseCode, String courseName, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.instructorId = "";
        this.capacity = 50; // Default capacity
        this.semester = "";
        this.enrolledStudents = new ArrayList<String>();
        this.sessionTimes = new String[5];
        this.sessionCount = 0;
    }

    public Course(String courseCode, String courseName) {
        this(courseCode, courseName, 3); // Calls the above constructor
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public ArrayList<String> getEnrolledStudents() {
        return enrolledStudents;
    }

    public String[] getSessionTimes() {
        return sessionTimes;
    }

    public int getSessionCount() {
        return sessionCount;
    }

    public boolean addStudent(String studentId) {
        enrolledStudents.add(studentId);
        return true;
    }

    public boolean removeStudent(String studentId) {
        return enrolledStudents.remove(studentId);
    }

    public int getEnrollmentCount() {
        return enrolledStudents.size();
    }

    public boolean isFull() {
        return enrolledStudents.size() >= capacity;
    }

    public boolean addSessionTime(String time) {
        sessionTimes[sessionCount] = time;
        sessionCount++;
        return true;
    }

    public void displayCourseInfo() {
        System.out.println("=== Course Information ===");
        System.out.println("Code: " + courseCode);
        System.out.println("Name: " + courseName);
        System.out.println("Instructor ID: " + instructorId);
        System.out.println("Credits: " + credits);
        System.out.println("Capacity: " + capacity);
        System.out.println("Enrolled: " + getEnrollmentCount());
        System.out.println("Semester: " + semester);
    }
}
