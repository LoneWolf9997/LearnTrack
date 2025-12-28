package learntrack.entity;

public class Course {
    private final int id;
    private final String courseName;
    private boolean active;

    public Course(int id, String courseName, String description, int durationInWeeks) {
        this.id = id;
        this.courseName = courseName;
        this.active = true;
    }

    public int getId() { return id; }
    public String getCourseName() { return courseName; }
    public boolean isActive() { return active; }

    public void deactivate() { this.active = false; }
    public void activate() { this.active = true; }
}
