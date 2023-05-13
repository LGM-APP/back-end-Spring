package com.lgm.backend.repository.backendDb;



import com.lgm.backend.model.backendDb.Role;
import com.lgm.backend.model.backendDb.RoleName;
import com.lgm.backend.model.backendDb.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, User> {

    Role findByRoleName(RoleName roleName);

}
