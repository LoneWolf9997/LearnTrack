package learntrack.service;

import learntrack.exception.EntityNotFoundException;
import learntrack.entity.Student;

import java.util.ArrayList;

public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();

    public void updateStudentStatus(int id, boolean active) throws EntityNotFoundException {
        Student student = findById(id);
        if (active) {
            student.activate();
        } else {
            student.deactivate();
        }
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public ArrayList<Student> listStudents() {
        return students;
    }

    public Student findById(int id) throws EntityNotFoundException {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        throw new EntityNotFoundException("Student not found");
    }

    public void deactivateStudent(int id) throws EntityNotFoundException {
        Student s = findById(id);
        s.deactivate();
    }
}
