package entity;

import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Teachers", schema = "public")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "object_id")
    private Subject subject;

    @Builder.Default
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.REMOVE,  orphanRemoval = true)
    private List<TeachersAndClasses> teachersAndClasses = new ArrayList<>();

    public void addSchoolClass(SchoolClass schoolClass) {
        teachersAndClasses.add
                (TeachersAndClasses.builder().schoolClass(schoolClass).teacher(this).build());
    }

}
