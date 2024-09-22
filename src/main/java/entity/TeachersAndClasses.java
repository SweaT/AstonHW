package entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Data
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

    public static TeachersAndClasses setTeacherAndClass(Teacher teacher, SchoolClass schoolClass){
        return TeachersAndClasses.builder()
                .teacher(teacher).schoolClass(schoolClass).createdAt(Instant.now()).build();
    }

}
