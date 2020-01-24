package se.g21.backend.coursesystem.repository;

import se.g21.backend.coursesystem.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findById(long id);
}
