package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @OneToMany(mappedBy = "schoolClass", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<TeachersAndClasses> teachersAndClasses = new ArrayList<>();

}
