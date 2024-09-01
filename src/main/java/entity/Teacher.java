package entity;

public class Teacher {
    private int id;
    private String name;
    private int objectID;

    public Teacher(int id, String name, int objectID) {
        this.id = id;
        this.name = name;
        this.objectID = objectID;
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

    public int getObjectID() {
        return objectID;
    }

    public void setObjectID(int objectID) {
        this.objectID = objectID;
    }

    @Override
    public String toString() {
        return "Teacher{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", objectID=" + objectID +
               '}';
    }
}
