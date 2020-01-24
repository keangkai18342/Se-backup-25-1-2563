package se.g21.backend.studentsystem.repository;

import se.g21.backend.studentsystem.entities.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findById(long id);
}