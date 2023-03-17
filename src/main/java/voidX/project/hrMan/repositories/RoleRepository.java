package voidX.project.hrMan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import voidX.project.hrMan.model.Role;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    Optional<Role> findByRoleName(String name);
    Role findById(int id);
}
