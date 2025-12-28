package learntrack.service;
import learntrack.entity.Enrollment;

import java.util.ArrayList;

public class EnrollmentService {

    private final ArrayList<Enrollment> enrollments = new ArrayList<>();
    public void enroll(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public void enrollStudent(int studentId, int courseId, int enrollmentId) {
        enrollments.add(new Enrollment(enrollmentId, studentId, courseId));
    }

    public ArrayList<Enrollment> getEnrollmentsByStudent(int studentId) {
        ArrayList<Enrollment> result = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getStudentId() == studentId) {
                result.add(e);
            }
        }
        return result;
    }

    public Enrollment findEnrollment(int enrollmentId) {
        for (Enrollment e : enrollments) {
            if (e.getId() == enrollmentId) {
                return e;
            }
        }
        return null;
    }
}
