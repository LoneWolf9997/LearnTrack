package learntrack.ui;
import learntrack.entity.*;
import learntrack.service.*;
import learntrack.util.IdGenerator;
import learntrack.exception.EntityNotFoundException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();

        while (true) {
            System.out.println("\n--- LearnTrack Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Add Course");
            System.out.println("4. View Courses");
            System.out.println("5. Assign Course to Student");
            System.out.println("6. View Student Enrollments");
            System.out.println("7. Update Student Status");
            System.out.println("8. Exit");


            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("First Name: ");
                        String fn = sc.nextLine();
                        System.out.print("Last Name: ");
                        String ln = sc.nextLine();
                        System.out.print("Batch: ");
                        String batch = sc.nextLine();

                        Student s = new Student(
                                IdGenerator.nextStudentId(),
                                fn, ln, batch
                        );
                        studentService.addStudent(s);
                        System.out.println("Student added!");
                        break;

                    case 2:
                        for (Student st : studentService.listStudents()) {
                            System.out.println(st.getId() + " | " +
                                    st.getDisplayName() + " | Active: " + st.isActive());
                        }
                        break;

                    case 3:
                        System.out.print("Course Name: ");
                        String cn = sc.nextLine();
                        System.out.print("Description: ");
                        String desc = sc.nextLine();
                        System.out.print("Duration (weeks): ");
                        int weeks = Integer.parseInt(sc.nextLine());

                        Course c = new Course(
                                IdGenerator.nextCourseId(),
                                cn, desc, weeks
                        );
                        courseService.addCourse(c);
                        System.out.println("Course added!");
                        break;

                    case 4:
                        for (Course co : courseService.listCourses()) {
                            System.out.println(co.getId() + " | " + co.getCourseName());
                        }
                        break;

                    case 5:
                        System.out.print("Enter Student ID: ");
                        int studentId = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Course ID: ");
                        int courseId = Integer.parseInt(sc.nextLine());

                        // Validate existence
                        studentService.findById(studentId);
                        courseService.findById(courseId);

                        enrollmentService.enrollStudent(
                                studentId,
                                courseId,
                                IdGenerator.nextEnrollmentId()
                        );

                        System.out.println("Course assigned to student successfully!");
                        break;

                    case 6:
                        System.out.print("Enter Student ID: ");
                        int sid = Integer.parseInt(sc.nextLine());

                        // Fetch and display student details
                        Student student = studentService.findById(sid);
                        System.out.println("\n--- Student Details ---");
                        System.out.println(student);

                        // Fetch enrollments
                        var enrollments = enrollmentService.getEnrollmentsByStudent(sid);

                        System.out.println("\n--- Assigned Courses ---");
                        if (enrollments.isEmpty()) {
                            System.out.println("No courses assigned to this student.");
                        } else {
                            for (Enrollment e : enrollments) {
                                c = courseService.findById(e.getCourseId());
                                System.out.println(
                                        "Enrollment ID: " + e.getId() +
                                                " | Course: " + c.getCourseName() +
                                                " | Status: " + e.getStatus()
                                );
                            }
                        }
                        break;

                    case 7:
                        System.out.print("Enter Student ID: ");
                        int stId = Integer.parseInt(sc.nextLine());

                        Student st = studentService.findById(stId);

                        System.out.println("Current Status: " + (st.isActive() ? "ACTIVE" : "INACTIVE"));
                        System.out.println("1. Activate Student");
                        System.out.println("2. Deactivate Student");
                        System.out.print("Choose option: ");

                        int statusChoice = Integer.parseInt(sc.nextLine());

                        if (statusChoice == 1) {
                            studentService.updateStudentStatus(stId, true);
                            System.out.println("Student activated successfully.");
                        } else if (statusChoice == 2) {
                            studentService.updateStudentStatus(stId, false);
                            System.out.println("Student deactivated successfully.");
                        } else {
                            System.out.println("Invalid option.");
                        }
                        break;

                    case 8:System.out.println("Exiting LearnTrack...");
                        return;
                    default: System.out.println("Invalid option!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid numeric input.");
            } catch (EntityNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}