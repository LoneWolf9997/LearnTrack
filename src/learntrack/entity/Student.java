package learntrack.entity;

public class Student extends Person {
    private String batch;
    private boolean active;
    public void activate() {
        this.active = true;
    }

    // Constructor without email (Overloading)
    public Student(int id, String firstName, String lastName, String batch) {
        super(id, firstName, lastName, null);
        this.batch = batch;
        this.active = true;
    }

    // Constructor with email
    public Student(int id, String firstName, String lastName, String email, String batch) {
        super(id, firstName, lastName, email);
        this.batch = batch;
        this.active = true;
    }

    @Override
    public String getDisplayName() {
        return "Student: " + super.getDisplayName();
    }

    public String getBatch() { return batch; }
    public boolean isActive() { return active; }

    public void setBatch(String batch) { this.batch = batch; }
    public void deactivate() { this.active = false; }
}
