package com.lyx297.springloginapp.repository;

import com.lyx297.springloginapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT u FROM Role u WHERE u.roleName = :roleName")
    Role findByRoleName(@Param("roleName") String roleName);
}
