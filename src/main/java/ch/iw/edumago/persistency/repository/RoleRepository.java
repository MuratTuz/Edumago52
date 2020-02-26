package ch.iw.edumago.persistency.repository;

import ch.iw.edumago.persistency.entity.ERole;
import ch.iw.edumago.persistency.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByName(ERole eRole);
}
