package entity;

public class Student {
    private int id;
    private String name;
    private int classID;

    public Student(int classID, String name) {
        this.classID = classID;
        this.name = name;
    }

    public Student(int id, String name, int classID) {
        this.classID = classID;
        this.id = id;
        this.name = name;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
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

    @Override
    public String toString() {
        return "Student{" +
               "classID=" + classID +
               ", id=" + id +
               ", name='" + name + '\'' +
               '}';
    }
}
