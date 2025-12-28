# LearnTrack 📘  
### Student & Course Management System (Core Java)

LearnTrack is a **console-based Student and Course Management System** built using **Core Java**.  
The project is designed to strengthen **Java fundamentals**, focusing on OOP concepts, collections, exception handling, and clean code practices.

This application allows an admin to manage students, courses, and enrollments through a menu-driven console interface.

---

## 🚀 Features

### Student Management
- Add new students
- View all students
- View detailed student information
- Activate / Deactivate student status

### Course Management
- Add new courses
- View available courses
- Activate / Deactivate courses

### Enrollment Management
- Assign courses to students
- View all courses assigned to a student
- Track enrollment status (ACTIVE, COMPLETED, CANCELLED)

---

## 🛠️ Technologies Used
- **Java (Core Java)**
- JDK 8+ (Recommended: JDK 17)
- Console-based UI
- In-memory data storage using `ArrayList`

---

## 📂 Project Structure



airtribr_learners_track/
│
├── src/
│   └── learntrack/
│       ├── entity/
│       │   ├── Person.java
│       │   ├── Student.java
│       │   ├── Course.java
│       │   └── Enrollment.java
│       │
│       ├── service/
│       │   ├── StudentService.java
│       │   ├── CourseService.java
│       │   └── EnrollmentService.java
│       │
│       ├── exception/
│       │   ├── EntityNotFoundException.java
│       │   └── InvalidInputException.java
│       │
│       ├── util/
│       │   ├── IdGenerator.java
│       │   └── InputValidator.java
│       │
│       └── ui/
│           └── Main.java
│
├── docs/
│   ├── Setup_Instructions.md
│   ├── JVM_Basics.md
│   └── Design_Notes.md
│
└── README.md
