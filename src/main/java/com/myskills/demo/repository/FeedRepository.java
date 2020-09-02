package com.myskills.demo.repository;

import com.myskills.demo.entity.FeedsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedRepository extends CrudRepository<FeedsEntity, Long> {
}
