package ch.iw.edumago.persistency.repository;

import ch.iw.edumago.persistency.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
}
