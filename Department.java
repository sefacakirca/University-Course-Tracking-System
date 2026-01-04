import java.util.ArrayList;

public class Department {
    private String departmentCode;
    private String departmentName;

    private ArrayList<AttendanceRecord> attendanceRecords;

    private Student[] students;
    private int studentCount;

    private Course[] courses;
    private int courseCount;

    public Department(String departmentCode, String departmentName) {
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.attendanceRecords = new ArrayList<AttendanceRecord>();
        this.students = new Student[100];
        this.studentCount = 0;
        this.courses = new Course[50];
        this.courseCount = 0;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public ArrayList<AttendanceRecord> getAttendanceRecords() {
        return attendanceRecords;
    }

    public Student[] getStudents() {
        return students;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public Course[] getCourses() {
        return courses;
    }

    public int getCourseCount() {
        return courseCount;
    }

    public boolean addStudent(Student student) {
        students[studentCount] = student;
        studentCount++;
        return true;
    }

    public boolean addCourse(Course course) {
        courses[courseCount] = course;
        courseCount++;
        return true;
    }

    public boolean addAttendanceRecord(AttendanceRecord record) {
        attendanceRecords.add(record);
        return true;
    }

    public boolean validateStudentEnrollment(String studentId, String courseCode) {
        Course targetCourse = null;
        int i = 0;

        while (i < courseCount) {
            Course c = courses[i];
            boolean isMatch = c.getCourseCode().equals(courseCode);
            targetCourse = isMatch ? c : targetCourse;
            i++;
        }

        boolean isEnrolled = false;
        ArrayList<String> enrolled = targetCourse.getEnrolledStudents();
        int j = 0;
        while (j < enrolled.size()) {
            isEnrolled = enrolled.get(j).equals(studentId) ? true : isEnrolled;
            j++;
        }

        return isEnrolled;
    }

    public boolean checkDuplicateAttendance(String studentId, String courseCode, String date) {
        boolean hasDuplicate = false;
        int i = 0;

        while (i < attendanceRecords.size()) {
            AttendanceRecord rec = attendanceRecords.get(i);
            boolean sameStudent = rec.getStudentId().equals(studentId);
            boolean sameCourse = rec.getCourseCode().equals(courseCode);
            boolean sameDate = rec.getDate().equals(date);

            hasDuplicate = (sameStudent && sameCourse && sameDate) ? true : hasDuplicate;
            i++;
        }

        return hasDuplicate;
    }

    public double calculateAttendancePercentage(String studentId, String courseCode) {
        int totalRecords = 0;
        int presentCount = 0;
        int i = 0;

        while (i < attendanceRecords.size()) {
            AttendanceRecord rec = attendanceRecords.get(i);
            boolean matches = rec.getStudentId().equals(studentId) &&
                    rec.getCourseCode().equals(courseCode);

            totalRecords = matches ? totalRecords + 1 : totalRecords;
            presentCount = (matches && rec.isPresent()) ? presentCount + 1 : presentCount;
            i++;
        }

        double percentage = 0.0;
        percentage = totalRecords > 0 ? (presentCount * 100.0) / totalRecords : 0.0;

        return percentage;
    }

    public boolean meetsAttendanceRequirement(String studentId, String courseCode) {
        double percentage = calculateAttendancePercentage(studentId, courseCode);
        return percentage >= 75.0;
    }

    public double calculateDepartmentAverageAttendance() {
        double totalPercentage = 0.0;
        int validCombinations = 0;
        int i = 0;

        // Iterate through all students
        while (i < studentCount) {
            Student student = students[i];
            int j = 0;

            while (j < student.getCourseCount()) {
                String courseCode = student.getEnrolledCourses()[j];
                double percentage = calculateAttendancePercentage(student.getStudentNumber(), courseCode);

                totalPercentage = totalPercentage + percentage;
                validCombinations++;
                j++;
            }
            i++;
        }

        double average = validCombinations > 0 ? totalPercentage / validCombinations : 0.0;
        return average;
    }

    public int getTotalAttendanceRecords() {
        return attendanceRecords.size();
    }

    public int countTotalPresentRecords() {
        int presentCount = 0;
        int i = 0;

        while (i < attendanceRecords.size()) {
            AttendanceRecord rec = attendanceRecords.get(i);
            presentCount = rec.isPresent() ? presentCount + 1 : presentCount;
            i++;
        }

        return presentCount;
    }

    // Method to count total absent records
    public int countTotalAbsentRecords() {
        int absentCount = 0;
        int i = 0;

        while (i < attendanceRecords.size()) {
            AttendanceRecord rec = attendanceRecords.get(i);
            absentCount = rec.isAbsent() ? absentCount + 1 : absentCount;
            i++;
        }

        return absentCount;
    }

    // Method to display department statistics
    public void displayDepartmentStats() {
        System.out.println("=== Department Statistics ===");
        System.out.println("Department: " + departmentName + " (" + departmentCode + ")");
        System.out.println("Total Students: " + studentCount);
        System.out.println("Total Courses: " + courseCount);
        System.out.println("Total Attendance Records: " + getTotalAttendanceRecords());
        System.out.println("Total Present Records: " + countTotalPresentRecords());
        System.out.println("Total Absent Records: " + countTotalAbsentRecords());
        System.out.println("Department Average Attendance: " +
                String.format("%.2f", calculateDepartmentAverageAttendance()) + "%");
    }
}