package com.myskills.demo.converters;

import com.myskills.demo.entity.CommentsEntity;
import com.myskills.demo.entity.FeedsEntity;
import com.myskills.demo.models.Comment;
import com.myskills.demo.models.Feed;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class FeedConverter {

  public List<Feed> convertFeedEntityToFeed(Long userId, List<FeedsEntity> feedsEntityList) {
    if (feedsEntityList == null || feedsEntityList.isEmpty()) {
      return null;
    }
    List<Feed> feedList = new ArrayList<>();
    for (FeedsEntity feedsEntity : feedsEntityList) {
      Feed feed = new Feed();
      feed.setUserId(userId);
      feed.setHeader(feedsEntity.getFeedDetail());
      feed.setDescription(feedsEntity.getFeedDetail());
      feed.setLikesCount(feedsEntity.getLikes());
      feed.setPostedDate(DateConverter.getStringFromDate(feedsEntity.getPostedOn()));
      feedList.add(feed);
    }
    return feedList;
  }

  public FeedsEntity convertFeedModelToEntity(Feed feed) {
    FeedsEntity entity = new FeedsEntity();
    entity.setFeedDetail(feed.getDescription());
    entity.setPostedOn(new Date()); //TODO
    entity.setLikes(0);
    return entity;
  }

  public CommentsEntity convertCommentModelToEntity(Comment comment) {
    CommentsEntity entity = new CommentsEntity();
    entity.setMessage(comment.getComment());
    entity.setPostedDate(new Date()); //TODO
    return entity;
  }
}
