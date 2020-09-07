package com.myskills.demo.converters;

import com.myskills.demo.entity.CommentsEntity;
import com.myskills.demo.entity.FeedsEntity;
import com.myskills.demo.entity.UserEntity;
import com.myskills.demo.models.Comment;
import com.myskills.demo.models.Feed;
import com.myskills.demo.models.User;
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
      feed.setId(feedsEntity.getId());
      feed.setUserId(feedsEntity.getUserEntity().getId());
      feed.setHeader(feedsEntity.getFeedDetail());
      feed.setDescription(feedsEntity.getFeedDetail());
      feed.setLikesCount(feedsEntity.getLikes());
      feed.setPostedDate(DateConverter.getStringFromDate(feedsEntity.getPostedOn()));
      feed.setUser(convertUserEntityToModel(feedsEntity.getUserEntity()));
      feed.setCommentList(convertCommentEntityToModel(feedsEntity.getCommentsList()));
      feedList.add(feed);
    }
    return feedList;
  }

  public List<Comment> convertCommentEntityToModel(List<CommentsEntity> commentsList) {
    List<Comment> comments = new ArrayList<>();
    if (commentsList != null && !commentsList.isEmpty()) {
      commentsList.forEach( entity -> {
        Comment comment = new Comment();
        comment.setComment(entity.getMessage());
        comment.setCommentedBy(entity.getCommentedBy().getId());
        comment.setCommentedByDP(entity.getCommentedBy().getDisplayPicture());
        comment.setCommentedOn(DateConverter.getStringFromDate(entity.getPostedDate()));
        comment.setFeedId(entity.getFeedsEntity().getId());
        comments.add(comment);
      });
    }
    return comments;
  }

  private User convertUserEntityToModel(UserEntity userEntity) {
    User user = new User();
    user.setUserName(userEntity.getUsername());
    user.setDisplayProfile(userEntity.getDisplayPicture());
    user.setId(userEntity.getId());
    return user;
  }

  public FeedsEntity convertFeedModelToEntity(Feed feed) {
    FeedsEntity entity = new FeedsEntity();
    entity.setFeedDetail(feed.getDescription());
    entity.setPostedOn(DateConverter.getDateFromString(feed.getPostedDate()));
    entity.setLikes(0);
    return entity;
  }

  public CommentsEntity convertCommentModelToEntity(Comment comment) {
    CommentsEntity entity = new CommentsEntity();
    entity.setMessage(comment.getComment());
    entity.setPostedDate(DateConverter.getDateFromString(comment.getCommentedOn()));
    return entity;
  }
}
