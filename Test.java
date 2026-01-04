public class Test {

    public static void main(String[] args) {
        System.out.println("===================================");
        System.out.println("COURSE ATTENDANCE TRACKING SYSTEM");
        System.out.println("===================================");

        testPersonPolymorphism();
        studentCreation();
        testInstructorCreation();
        testCourseOperations();
        testAttendanceRecordCreation();
        testDepartmentComplexRules();
        testSumAndAverageOperations();

        System.out.println();
        System.out.println("===================================");
        System.out.println("===================================");
    }
    public static void testPersonPolymorphism() {
        System.out.println();
        System.out.println("--- TEST 1: Person Polymorphism ---");

        Person s1 = new Student("P001", "Sefa Çakırca", "sefa.cakirca@stu.fsm.edu.tr", "5301223325", "2421051004", "Software Engineering", 3);

        Person i1 = new Instructor("P002", "Dr. Ali Nizam", "ali.nizam@fsm.edu.tr", "5301587325", "Dr.", "Software Engineering", 10);

        System.out.println("Person 1 Role: " + s1.getRole());
        System.out.println("Person 2 Role: " + i1.getRole());

        s1.displayInfo();
        System.out.println();
        i1.displayInfo();

        System.out.println();
    }

    public static void studentCreation() {

        Student s1 = new Student("P003", "Süleyman Hilmi Deniz", "shilmi.deniz@stu.fsm.edu.tr", "5301558025", "2421051031", "Software Engineering", 2);

        Student s2 = new Student("P004", "Can Öztürk", "2421051026", "Computer Engineering");

        s1.setGpa(3.45);
        s2.setGpa(3.67);
        s2.setSemester(4);

        Course course1 = new Course("CS101", "Introduction to Programming");
        Course course2 = new Course("CS102", "Data Structures");
        Course course3 = new Course("MATH201", "Calculus II");
        Course course4 = new Course("CS201", "Advanced Programming");

        s1.addCourse(course1.getCourseCode());
        s1.addCourse(course2.getCourseCode());
        s1.addCourse(course3.getCourseCode());

        s2.addCourse(course1.getCourseCode());
        s2.addCourse(course4.getCourseCode());

        s1.displayInfo();
        System.out.println("Enrolled Courses Count: " + s1.getCourseCount());

        System.out.println();
        s2.displayInfo();
        System.out.println("Enrolled Courses Count: " + s2.getCourseCount());

        String removedCourse = course3.getCourseCode();
        s1.removeCourse(removedCourse);
        System.out.println();
        System.out.println("After removing " + removedCourse + ", course count: " + s1.getCourseCount());
    }

    public static void testInstructorCreation() {
        System.out.println();

        Instructor i1 = new Instructor("P005", "Prof. Rabia Atamış", "rabia.atamis@fsm.edu.tr", "5360727080", "Prof.", "Computer Engineering", 15);

        Instructor i2 = new Instructor("P006", "Dr. Ali Koç", "Dr.", "Software Engineering");
        i2.setExperienceYears(8);

        i1.assignCourse("CS101");
        i1.assignCourse("CS301");

        i2.assignCourse("SE201");
        i2.assignCourse("SE301");
        i2.assignCourse("SE401");

        i1.displayInfo();
        System.out.println("Assigned Courses Count: " + i1.getCourseCount());
        /* System.out.print("Assigned courses are: ");
        i1.getAssignedCourses();
        */
        System.out.println();
        i2.displayInfo();
        System.out.println("Assigned Courses Count: " + i2.getCourseCount());

    }

    public static void testCourseOperations() {
        System.out.println();

        Course c1 = new Course("CS101", "Introduction to Programming", "P005", 4, 60, "Fall 2024");

        Course c2 = new Course("CS201", "Data Structures", 4);
        c2.setInstructorId("P006");
        c2.setCapacity(50);
        c2.setSemester("Fall 2024");

        Course c3 = new Course("MATH201", "Calculus II");

        c1.addStudent("2421051004");
        c1.addStudent("2421051015");
        c1.addStudent("2421051026");
        c1.addStudent("2421051033");
        c1.addStudent("2421051041");

        c2.addStudent("2421051004");
        c2.addStudent("2421051026");
        c2.addStudent("2421051041");

        // Add session times using array operations
        c1.addSessionTime("Monday 09:00-11:00");
        c1.addSessionTime("Wednesday 09:00-11:00");

        c2.addSessionTime("Tuesday 13:00-15:00");
        c2.addSessionTime("Thursday 13:00-15:00");

        c1.displayCourseInfo();
        System.out.println("Is Full: " + c1.isFull());
        System.out.println("Session Count: " + c1.getSessionCount());

        System.out.println();
        c2.displayCourseInfo();
        System.out.println("Is Full: " + c2.isFull());

        c1.removeStudent("2421051033");
        System.out.println();
        System.out.println("After removing one student from CS101:");
        System.out.println("Enrollment Count: " + c1.getEnrollmentCount());
        System.out.println();
        System.out.println("Course operations test passed!");
    }

    public static void testAttendanceRecordCreation() {
        System.out.println();
        System.out.println("--- TEST 5: Attendance Record Creation ---");

        AttendanceRecord r1 = new AttendanceRecord("ATT001", "2421051004", "CS101", "2024-10-01", "Present", 1);

        AttendanceRecord r2 = new AttendanceRecord("ATT002", "2421051015", "CS101", "2024-10-01");

        AttendanceRecord r3 = new AttendanceRecord("ATT003", "2421051026", "CS101", "Late");

        r3.setWeekNumber(1);
        r2.setWeekNumber(1);

        r1.setNotes("Participated actively in class");
        r3.setNotes("Arrived 15 minutes late");

        r1.displayRecord();
        System.out.println("Is Present: " + r1.isPresent());

        r2.displayRecord();
        System.out.println("Is Present: " + r2.isPresent());

        r3.displayRecord();
        System.out.println("Is Present: " + r3.isPresent());

    }

    public static void testDepartmentComplexRules() {
        System.out.println();
        System.out.println("--- TEST 6: Department Complex Rules ---");

        Department d = new Department("CS", "Computer Science Engineering");

        Student s1 = new Student("P101", "Sefa Çakırca", "2421051004", "CS");
        Student s2 = new Student("P102", "Muhammed Ensar Atamış", "2421051015", "CS");
        Student s3 = new Student("P103", "Ayşe Hüma Atamış", "2421051026", "CS");

        s1.setSemester(3);
        s1.setGpa(3.42);
        s2.setSemester(2);
        s2.setGpa(3.78);
        s3.setSemester(4);
        s3.setGpa(3.15);

        d.addStudent(s1);
        d.addStudent(s2);
        d.addStudent(s3);

        Course course1 = new Course("CS101", "Programming Fundamentals", 3);
        course1.setCapacity(50);

        Course course2 = new Course("CS201", "Object Oriented Programming", 4);
        course2.setCapacity(45);

        d.addCourse(course1);
        d.addCourse(course2);

        course1.addStudent("2421051004");
        course1.addStudent("2421051015");
        course1.addStudent("2421051026");

        course2.addStudent("2421051004");
        course2.addStudent("2421051026");

        s1.addCourse("CS101");
        s1.addCourse("CS201");
        s2.addCourse("CS101");
        s3.addCourse("CS101");
        s3.addCourse("CS201");

        System.out.println();
        System.out.println("Rule 1 - Student Enrollment Validation:");
        boolean isEnrolled1 = d.validateStudentEnrollment("2421051004", "CS101");
        System.out.println("Student 2421051004 enrolled in "+ course1.getCourseCode()+" : " + isEnrolled1);

        boolean isEnrolled2 = d.validateStudentEnrollment("2421051015", "CS201");
        System.out.println("Student 2421051015 enrolled in "+ course2.getCourseCode()+" : "+ isEnrolled2);

        AttendanceRecord att1 = new AttendanceRecord("ATT101", "2421051004", "CS101", "2024-10-01", "Present", 1);
        AttendanceRecord att2 = new AttendanceRecord("ATT102", "2421051015", "CS101", "2024-10-01", "Present", 1);
        AttendanceRecord att3 = new AttendanceRecord("ATT103", "2421051026", "CS101", "2024-10-01", "Absent", 1);

        d.addAttendanceRecord(att1);
        d.addAttendanceRecord(att2);
        d.addAttendanceRecord(att3);

        System.out.println();
        System.out.println("Rule 2 - Duplicate Attendance Check:");
        boolean hasDup = d.checkDuplicateAttendance("2421051004", "CS101", "2024-10-01");
        System.out.println("Duplicate attendance for student "+ s1.getStudentNumber()+" on "+ att1.getDate()+ ": " + hasDup);

        AttendanceRecord att4 = new AttendanceRecord("ATT104", "2421051004", "CS101", "2024-10-08", "Present", 2);
        AttendanceRecord att5 = new AttendanceRecord("ATT105", "2421051015", "CS101", "2024-10-08", "Present", 2);
        AttendanceRecord att6 = new AttendanceRecord("ATT106", "2421051026", "CS101", "2024-10-08", "Present", 2);

        d.addAttendanceRecord(att4);
        d.addAttendanceRecord(att5);
        d.addAttendanceRecord(att6);

        AttendanceRecord att7 = new AttendanceRecord("ATT107", "2421051004", "CS101", "2024-10-15", "Present", 3);
        AttendanceRecord att8 = new AttendanceRecord("ATT108", "2421051015", "CS101", "2024-10-15", "Absent", 3);
        AttendanceRecord att9 = new AttendanceRecord("ATT109", "2421051026", "CS101", "2024-10-15", "Present", 3);

        d.addAttendanceRecord(att7);
        d.addAttendanceRecord(att8);
        d.addAttendanceRecord(att9);

        AttendanceRecord att10 = new AttendanceRecord("ATT110", "2421051004", "CS101", "2024-10-22", "Present", 4);
        AttendanceRecord att11 = new AttendanceRecord("ATT111", "2421051015", "CS101", "2024-10-22", "Present", 4);
        AttendanceRecord att12 = new AttendanceRecord("ATT112", "2421051026", "CS101", "2024-10-22", "Absent", 4);

        d.addAttendanceRecord(att10);
        d.addAttendanceRecord(att11);
        d.addAttendanceRecord(att12);

        AttendanceRecord att13 = new AttendanceRecord("ATT113", "2421051004", "CS201", "2024-10-02", "Present", 1);
        AttendanceRecord att14 = new AttendanceRecord("ATT114", "2421051026", "CS201", "2024-10-02", "Present", 1);
        AttendanceRecord att15 = new AttendanceRecord("ATT115", "2421051004", "CS201", "2024-10-09", "Present", 2);
        AttendanceRecord att16 = new AttendanceRecord("ATT116", "2421051026", "CS201", "2024-10-09", "Absent", 2);

        d.addAttendanceRecord(att13);
        d.addAttendanceRecord(att14);
        d.addAttendanceRecord(att15);
        d.addAttendanceRecord(att16);

        System.out.println();
        System.out.println("Rule 3 - Attendance Percentage Calculation:");
        double pct1 = d.calculateAttendancePercentage("2421051004", "CS101");
        System.out.println("Student "+s1.getStudentNumber() +" attendance in "+course1.getCourseCode()+": " + pct1 + "%");

        double pct2 = d.calculateAttendancePercentage("2421051026", "CS101");
        System.out.println("Student "+s3.getStudentNumber() +" attendance in "+course1.getCourseCode()+": " + pct2 + "%");

        double pct3 = d.calculateAttendancePercentage("2421051004", "CS201");
        System.out.println("Student "+s1.getStudentNumber() +" attendance in "+course1.getCourseCode()+": " + pct3 + "%");


        System.out.println();
        System.out.println("Rule 4 - Minimum Attendance Requirement Check:");
        boolean meets1 = d.meetsAttendanceRequirement("2421051004", "CS101");
        System.out.println("Student "+s1.getStudentNumber()+" meets requirement in CS101: " + meets1);

        boolean meets2 = d.meetsAttendanceRequirement("2421051026", "CS101");
        System.out.println("Student "+s3.getStudentNumber()+" meets requirement in CS101: " + meets2);

        System.out.println();
        System.out.println("Rule 5 - Department Average Attendance:");
        double avgAttendance = d.calculateDepartmentAverageAttendance();
        System.out.println("Department Average Attendance Rate: " + avgAttendance + "%");

        System.out.println();
        System.out.println("Complex rules test passed!");
    }


    public static void testSumAndAverageOperations() {
        System.out.println("\n--- TEST 7: Sum and Average Operations ---");

        Department d = new Department("SEN", "Software Engineering");


        Student st1 = new Student("P201", "Sefa Çakırca", "2421051004", "SEN");
        Student st2 = new Student("P202", "Fatih Çakırca", "2421051005", "SEN");
        Student st3 = new Student("P203", "Akif Çakırca", "2421051006", "SEN");

        st1.setGpa(3.25);
        st2.setGpa(3.89);
        st3.setGpa(3.56);

        d.addStudent(st1);
        d.addStudent(st2);
        d.addStudent(st3);

        Course c1 = new Course("SEN22105E", "Computer Laboratory I", 3);
        d.addCourse(c1);

        c1.addStudent("2421051004");
        c1.addStudent("2421051005");
        c1.addStudent("2421051006");

        st1.addCourse("SEN22105E");
        st2.addCourse("SEN22105E");
        st3.addCourse("SEN22105E");

        // Add multiple attendance records
        AttendanceRecord rec1 = new AttendanceRecord("R01", "2421051004", "SEN22105E", "2024-09-01", "Present", 1);
        AttendanceRecord rec2 = new AttendanceRecord("R02", "2421051005", "SEN22105E", "2024-09-01", "Present", 1);
        AttendanceRecord rec3 = new AttendanceRecord("R03", "2421051006", "SEN22105E", "2024-09-01", "Absent", 1);
        AttendanceRecord rec4 = new AttendanceRecord("R04", "2421051004", "SEN22105E", "2024-09-08", "Present", 2);
        AttendanceRecord rec5 = new AttendanceRecord("R05", "2421051005", "SEN22105E", "2024-09-08", "Present", 2);
        AttendanceRecord rec6 = new AttendanceRecord("R06", "2421051006", "SEN22105E", "2024-09-08", "Present", 2);
        AttendanceRecord rec7 = new AttendanceRecord("R07", "2421051004", "SEN22105E", "2024-09-15", "Absent", 3);
        AttendanceRecord rec8 = new AttendanceRecord("R08", "2421051005", "SEN22105E", "2024-09-15", "Present", 3);
        AttendanceRecord rec9 = new AttendanceRecord("R09", "2421051006", "SEN22105E", "2024-09-15", "Present", 3);

        d.addAttendanceRecord(rec1);
        d.addAttendanceRecord(rec2);
        d.addAttendanceRecord(rec3);
        d.addAttendanceRecord(rec4);
        d.addAttendanceRecord(rec5);
        d.addAttendanceRecord(rec6);
        d.addAttendanceRecord(rec7);
        d.addAttendanceRecord(rec8);
        d.addAttendanceRecord(rec9);

        System.out.println();
        System.out.println("Sum Operations:");
        int totalRecords = d.getTotalAttendanceRecords();
        System.out.println("Total Attendance Records (Sum): " + totalRecords);

        int totalPresent = d.countTotalPresentRecords();
        System.out.println("Total Present Records (Sum): " + totalPresent);

        int totalAbsent = d.countTotalAbsentRecords();
        System.out.println("Total Absent Records (Sum): " + totalAbsent);


        System.out.println("Average Operations:");
        double avgAttendance = d.calculateDepartmentAverageAttendance();
        System.out.println("Average Attendance Rate: " + avgAttendance + "%");

        System.out.println();
        d.displayDepartmentStats();

        System.out.println("Sum and average operations test passed!");
    }
}