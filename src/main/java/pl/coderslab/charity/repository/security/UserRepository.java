package pl.coderslab.charity.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.user_security.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);

    @Query("SELECT e FROM User e where e.email=:email")
    User findByEmail(@Param("email") String email);

    @Query(value = "SELECT u FROM User u")
    List<User> findAll();

}
