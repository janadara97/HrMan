package voidX.project.hrMan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import voidX.project.hrMan.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    public Optional <User> findByEmail(String email);
    public Optional<User> findByUsername(String username);
    public Boolean existsByEmail(String email);

}
