package com.emerald.blue.repositories;

import com.emerald.blue.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
