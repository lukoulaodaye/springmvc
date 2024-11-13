package org.example.backendexamples.repository;

import org.example.backendexamples.dox.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,String> {
     User findByAccount(String account);

}
