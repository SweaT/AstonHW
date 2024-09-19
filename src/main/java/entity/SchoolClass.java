package entity;

public class SchoolClass {
    private int id;
    private String name;

    public SchoolClass(String name) {
        this.name = name;
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
        return "Classes{" +
               "id=" + id +
               ", name='" + name + '\'' +
               '}';
    }
}
