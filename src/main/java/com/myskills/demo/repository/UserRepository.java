package com.myskills.demo.repository;

import com.myskills.demo.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

  public Optional<UserEntity> findById(Long id);
}
