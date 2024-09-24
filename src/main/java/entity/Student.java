package entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Students", schema = "public")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence_generator")
    @SequenceGenerator(name = "student_sequence_generator", sequenceName = "students_student_id_seq", allocationSize = 1)
    @Column(name = "student_id")
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private SchoolClass schoolClass;

}
