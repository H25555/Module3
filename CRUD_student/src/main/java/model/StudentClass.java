package model;

public class StudentClass {
    private int id;
    private String name;

    public StudentClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public StudentClass() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
