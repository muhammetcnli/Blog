package com.atlas.repository;

import com.atlas.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String userName);

    User findByEmail(String email);
}
