package com.myskills.demo.repository;

import com.myskills.demo.entity.RelationshipEntity;
import com.myskills.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

  public Optional<UserEntity> findById(Long id);

  @Query("SELECT u FROM RelationshipEntity u WHERE u.user0 = x and u.user1 = x")
  Collection<RelationshipEntity> findUserRelationships();
}
