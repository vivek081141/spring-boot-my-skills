package com.myskills.demo.repository;

import com.myskills.demo.entity.RelationshipEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Collection;

@Repository
public interface RelationshipRepository extends CrudRepository<RelationshipEntity, Long> {

  @Query("SELECT u FROM RelationshipEntity u WHERE u.user0 = ?1 or u.user1 = ?1")
  Collection<RelationshipEntity> findUserRelationships(Long userId);
}
