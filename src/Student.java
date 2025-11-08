public class Student {
    String id;
    String name;
    int age;
    float gpa;

    public Student(String id, String name, int age, float gpa) {
        this.id = id;
        this.name = name;

        if (age > 0) this.age = age;
        else throw new IllegalArgumentException("Age must be positive");

        if (gpa >= 0.0f && gpa <= 4.0f) this.gpa = gpa;
        else throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, Age: %d, GPA: %.2f", id, name, age, gpa);
    }

}
