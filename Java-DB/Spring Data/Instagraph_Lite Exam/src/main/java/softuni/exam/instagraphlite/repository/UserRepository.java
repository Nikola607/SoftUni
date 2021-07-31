package softuni.exam.instagraphlite.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.models.entity.Users;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    boolean existsByUsername(String username);

    Optional<Users> findByUsername(String username);

    @Query("SELECT DISTINCT u FROM users u JOIN FETCH u.posts p ORDER BY SIZE (p) DESC, u.id")
    List<Users> findAllByPostsAndOrderByPostsCountDescThenByUserId();
}
