package ru.kursio.application.dao;

import ru.kursio.application.model.entity.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
//	@Query(value = "SELECT user_id FROM user WHERE user_name = ?1", nativeQuery = true)
//	Long findUserIdByUserName(String userName);

	User findByUserName(String userName);
	User findByEmail(String email);
}
