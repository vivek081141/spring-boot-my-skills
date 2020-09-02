package com.myskills.demo.services;

import com.myskills.demo.converters.FeedConverter;
import com.myskills.demo.entity.CommentsEntity;
import com.myskills.demo.entity.FeedsEntity;
import com.myskills.demo.entity.UserEntity;
import com.myskills.demo.models.Comment;
import com.myskills.demo.models.Feed;
import com.myskills.demo.repository.CommentsRepository;
import com.myskills.demo.repository.FeedRepository;
import com.myskills.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FeedService implements IFeedService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private FeedRepository feedRepository;

  @Autowired
  private CommentsRepository commentsRepository;

  @Autowired
  private FeedConverter feedConverter;

  @Override
  public List<Feed> getMyPosts(Long userId) {
    Optional<UserEntity> userOptional = userRepository.findById(userId);
    UserEntity userEntity = userOptional.get();
    return feedConverter.convertFeedEntityToFeed(userEntity.getFeedsEntityList());
  }

  @Override
  public List<Feed> getFeeds(Long userId) {
    return null;
  }

  @Override
  public void postFeed(Feed feed) {
    Optional<UserEntity> userOptional = userRepository.findById(feed.getUserId());
    userOptional.ifPresent(x-> {
      FeedsEntity feedsEntity = feedConverter.convertFeedModelToEntity(feed);
      feedsEntity.setUserEntity(x);
      x.getFeedsEntityList().add(feedsEntity);
      feedRepository.save(feedsEntity);
    });
  }

  @Override
  public void postComment(Comment comment) {
    Optional<FeedsEntity> feedOptional = feedRepository.findById(comment.getFeedId());
    feedOptional.ifPresent(feedsEntity -> {
      UserEntity user = userRepository.findById(comment.getCommentedBy()).get();
      CommentsEntity commentsEntity = feedConverter.convertCommentModelToEntity(comment);
      commentsEntity.setCommentedBy(user);
      commentsEntity.setFeedsEntity(feedsEntity);
      feedsEntity.getCommentsList().add(commentsEntity);
      commentsRepository.save(commentsEntity);
    });
  }

}
