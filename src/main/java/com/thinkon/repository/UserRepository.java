package com.thinkon.repository;

import org.springframework.data.repository.CrudRepository;
import com.thinkon.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
