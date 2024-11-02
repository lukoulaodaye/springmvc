package org.example.jdbcexample.repository;

import org.example.jdbcexample.dox.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,String>{

}
