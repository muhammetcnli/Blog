package com.atlas.repository;

import com.atlas.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {

    Role findByRole(String role);
}
