package javase.extend;

public class Student {
    public String name;
    private double score;

    public Student() {
        System.out.println("Student constructor");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
