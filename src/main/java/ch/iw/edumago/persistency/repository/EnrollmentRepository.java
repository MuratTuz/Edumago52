package ch.iw.edumago.persistency.repository;

import ch.iw.edumago.persistency.entity.EnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<EnrollmentEntity, Long> {
}
