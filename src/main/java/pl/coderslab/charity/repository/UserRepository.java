package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);

    User findUserById(Long id);

//    @Query(value = "SELECT friends_id FROM user_friends WHERE user_id =:userId", nativeQuery = true)
//    List<Long> finduserFriendsByID(@Param("userId") Long userId);

    @Query(value = "SELECT u FROM User u")
    List<User> findAll();


}
