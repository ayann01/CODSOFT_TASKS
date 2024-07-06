import java.util.*;

public class Student {
    private String studentId;
    private String name;
    private Set<Course> registeredCourses;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new HashSet<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public Set<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public boolean registerCourse(Course course) {
        if (course.isAvailable() && registeredCourses.add(course)) {
            course.enrollStudent();
            return true;
        }
        return false;
    }

    public boolean dropCourse(Course course) {
        if (registeredCourses.remove(course)) {
            course.dropStudent();
            return true;
        }
        return false;
    }

    public String toString() {
        return String.format("Student ID: %s, Name: %s, Registered Courses: %s", 
                             studentId, name, registeredCourses);
    }
}
