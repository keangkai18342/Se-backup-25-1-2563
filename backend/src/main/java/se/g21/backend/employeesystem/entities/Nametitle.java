package se.g21.backend.employeesystem.entities;

import lombok.*;
import se.g21.backend.studentsystem.entities.Student;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Nametitle")
public class Nametitle {
    @Id
    @SequenceGenerator(name = "Nametitle_seq", sequenceName = "Nametitle_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Nametitle_seq")
    @Column(name = "Nametitle_ID", unique = true, nullable = true)
    private @NonNull Long id;

    @Column(name = "Nametitle")
    private @NonNull String nametitle;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<Employee> employee;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<Student> student;
}
