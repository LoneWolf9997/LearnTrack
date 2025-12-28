package learntrack.entity;

import java.time.LocalDate;

public class Enrollment{

        private final int id;
        private final int studentId;
        private final int courseId;
    private String status;

        public Enrollment(int id, int studentId, int courseId) {
            this.id = id;
            this.studentId = studentId;
            this.courseId = courseId;
            LocalDate enrollmentDate = LocalDate.now();
            this.status = "ACTIVE";
        }

        public int getId() {
            return id;
        }

        public int getStudentId() {
            return studentId;
        }

        public int getCourseId() {
            return courseId;
        }

        public String getStatus() {
            return status;
        }

        public void complete() {
            this.status = "COMPLETED";
        }

        public void cancel() {
            this.status = "CANCELLED";
        }
    }
