package com.myskills.demo.services;


import com.myskills.demo.converters.FeedConverter;
import com.myskills.demo.entity.CommentsEntity;
import com.myskills.demo.entity.FeedsEntity;
import com.myskills.demo.entity.RelationshipEntity;
import com.myskills.demo.entity.UserEntity;
import com.myskills.demo.models.Comment;
import com.myskills.demo.models.Feed;
import com.myskills.demo.repository.CommentsRepository;
import com.myskills.demo.repository.FeedRepository;
import com.myskills.demo.repository.RelationshipRepository;
import com.myskills.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class FeedService implements IFeedService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private FeedRepository feedRepository;

  @Autowired
  private CommentsRepository commentsRepository;

  @Autowired
  private RelationshipRepository relationshipRepository;

  @Autowired
  private FeedConverter feedConverter;

  @Override
  public List<Feed> getMyPosts(Long userId) {
    List<Feed> feedList = new ArrayList<>();
    Optional<UserEntity> userOptional = userRepository.findById(userId);
    userOptional.ifPresent(userEntity -> {
      feedList.addAll(feedConverter.convertFeedEntityToFeed(userEntity.getId(), userEntity.getFeedsEntityList()));
    });
    return feedList;

  }

  //GET PERSON from Relationship,
  //for list of feeds
  @Override
  public List<Feed> getFeeds(Long userId) {
    List<FeedsEntity> feedsEntity = new ArrayList<>();
    List<Feed> feedList = new ArrayList<>();
    Optional<UserEntity> userOptional = userRepository.findById(userId);
    Set<Long> set = new HashSet<>();
    if (userOptional.isPresent()) {
      UserEntity userEntity = userOptional.get();
      Collection<RelationshipEntity> relList = relationshipRepository.findUserRelationships(userId);
      if (relList != null && !relList.isEmpty()) {
        relList.iterator().forEachRemaining(relationshipEntity -> {
          set.add(relationshipEntity.getUser1());
          set.add(relationshipEntity.getUser0());
        });
      }
      for (Long id : set) {
        Collection<FeedsEntity> feeds = feedRepository.getAllFeeds(id);
        feedsEntity.addAll(feeds);
      }
      if (!feedsEntity.isEmpty()) {
        feedList.addAll(feedConverter.convertFeedEntityToFeed(userEntity.getId(), feedsEntity));
      }
    }
    return feedList;
  }

  @Override
  public List<Feed> postFeed(Feed feed) {
    List<Feed> feedList = new ArrayList<>();
    Optional<UserEntity> userOptional = userRepository.findById(feed.getUserId());
    userOptional.ifPresent(userEntity -> {
      FeedsEntity feedsEntity = feedConverter.convertFeedModelToEntity(feed);
      feedsEntity.setUserEntity(userEntity);
      userEntity.getFeedsEntityList().add(feedsEntity);
      feedRepository.save(feedsEntity);
      feedList.addAll(feedConverter.convertFeedEntityToFeed(userEntity.getId(), userEntity.getFeedsEntityList()));
    });
    return feedList;
  }

  @Override
  public List<Comment> postComment(Comment comment) {
    List<Comment> commentList = new ArrayList<>();
    Optional<FeedsEntity> feedOptional = feedRepository.findById(comment.getFeedId());
    feedOptional.ifPresent(feedsEntity -> {
      UserEntity user = userRepository.findById(comment.getCommentedBy()).get();
      CommentsEntity commentsEntity = feedConverter.convertCommentModelToEntity(comment);
      commentsEntity.setCommentedBy(user);
      commentsEntity.setFeedsEntity(feedsEntity);
      feedsEntity.getCommentsList().add(commentsEntity);
      commentsRepository.save(commentsEntity);
      commentList.addAll(feedConverter.convertCommentEntityToModel(feedsEntity.getCommentsList()));
    });
    return commentList;
  }

  @Override
  public void likeFeed(Long feedId) {
    Optional<FeedsEntity> feedOptional = feedRepository.findById(feedId);
    feedOptional.ifPresent(feedsEntity -> {
      feedsEntity.setLikes(feedsEntity.getLikes() + 1);
      feedRepository.save(feedsEntity);
    });
  }

}
