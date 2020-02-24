package ch.iw.edumago.persistency.repository;

import ch.iw.edumago.persistency.entity.ERole;
import ch.iw.edumago.persistency.entity.RoleEntity;
import org.springframework.boot.CommandLineRunner;

public class DbInIt implements CommandLineRunner {

    private RoleRepository roleRepository;

    public DbInIt(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        roleRepository.deleteAll();

        roleRepository.save(RoleEntity.builder().name(ERole.ROLE_ADMIN).build());

        roleRepository.save(RoleEntity.builder().name(ERole.ROLE_MENAGER).build());

        roleRepository.save(RoleEntity.builder().name(ERole.ROLE_TEACHER).build());

        roleRepository.save(RoleEntity.builder().name(ERole.ROLE_PARENT).build());

        roleRepository.save(RoleEntity.builder().name(ERole.ROLE_STUDENT).build());
    }
}
