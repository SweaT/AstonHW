package entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Subjects", schema = "public")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_sequence_generator")
    @SequenceGenerator(name = "subject_sequence_generator", sequenceName = "subjects_subject_id_seq", allocationSize = 1)
    @Column(name = "subject_id")
    private Integer id;

    @Column(name = "object_name")
    private String name;

}
