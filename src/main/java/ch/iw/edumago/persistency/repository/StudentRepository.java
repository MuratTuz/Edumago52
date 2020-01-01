package ch.iw.edumago.persistency.repository;

import ch.iw.edumago.persistency.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
