package entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Teachers_And_Classes", schema = "public")
public class TeachersAndClasses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @Setter(AccessLevel.NONE)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "class_id")
    @Setter(AccessLevel.NONE)
    private SchoolClass schoolClass;

    private Instant createdAt;

//    добавление в конкретный класс конкретного teacher происходит
//    только через данный entity через данный метод
    public static TeachersAndClasses setTeacherAndClass(Teacher teacher, SchoolClass schoolClass){
        return TeachersAndClasses.builder()
                .teacher(teacher).schoolClass(schoolClass).createdAt(Instant.now()).build();
    }


    // Убрал lombok @Data аннотацию, для переопределения toString() метода для корректной работы
    // в ManyToMany связи

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeachersAndClasses that = (TeachersAndClasses) o;
        return Objects.equals(id, that.id) && Objects.equals(teacher, that.teacher) && Objects.equals(schoolClass, that.schoolClass) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt);
    }

    @Override
    public String toString() {
        return "TeachersAndClasses{" +
                "createdAt=" + createdAt +
                ", id=" + id +
                ", teacher=" + teacher.getName() +
                ", schoolClass=" + schoolClass.getName() +
                '}';
    }
}
