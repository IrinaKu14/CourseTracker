package ru.jafix.ct.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.jafix.ct.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByLogin(String login);


    List<User> findByAgeGreaterThan(int age);
//    @Query(value = "SELECT * FROM users u WHERE u.user_age <?1 AND u.login like ?2", nativeQuery = true)
//    List<User> findByLoginStartsWithLitterAndAgeBefore(@Param("maxAge") int maxAge,@Param("liter") String liter);

    @Query(value = "SELECT u FROM User u WHERE u.age < :maxAge AND u.login like :liter")
    List<User> findByLoginStartsWithLitterAndAgeBefore(@Param("maxAge") int maxAge,@Param("liter") String liter);


}
