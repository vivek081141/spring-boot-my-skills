package com.myskills.demo.repository;

import com.myskills.demo.entity.FeedsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Collection;

@Repository
public interface FeedRepository extends CrudRepository<FeedsEntity, Long> {

  @Query(value = "SELECT * FROM FEED_TBL u WHERE u.user_id = ?1 order by posted_on desc", nativeQuery = true)
  Collection<FeedsEntity> getAllFeeds(Long userId);
}
