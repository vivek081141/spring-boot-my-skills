package com.myskills.demo.repository;

import com.myskills.demo.entity.CommentsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends CrudRepository<CommentsEntity, Long> {
}
