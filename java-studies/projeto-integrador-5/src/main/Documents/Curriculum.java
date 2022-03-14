package main.Documents;

public class Curriculum extends Document {
    private String name;
    private String skills;

    public Curriculum(String name, String skills) {
        this.name = name;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "name='" + name + '\'' +
                ", skills='" + skills + '\'' +
                '}';
    }
}
