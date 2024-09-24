package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Classes", schema = "public")
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classes_sequence_generator")
    @SequenceGenerator(name = "classes_sequence_generator", sequenceName = "classes_class_id_seq", allocationSize = 1)
    @Column(name = "class_id")
    private int id;
    @Column(name = "class_name")
    private String name;

    @Builder.Default
    @ToString.Exclude
    @OneToMany(mappedBy = "schoolClass",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<TeachersAndClasses> teachersAndClasses = new ArrayList<>();

    public String getTeacherNames() {
        StringBuilder stringBuilder = new StringBuilder();
        teachersAndClasses.forEach(obj -> stringBuilder.append(obj.getTeacher().getName()).append(" "));
        return stringBuilder.toString();
    }

}
