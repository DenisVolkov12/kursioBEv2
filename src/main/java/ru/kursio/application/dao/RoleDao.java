package ru.kursio.application.dao;

import ru.kursio.application.model.entity.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface RoleDao extends JpaRepository<Role, Integer> {
	Role findByRoleType(String role);
}
