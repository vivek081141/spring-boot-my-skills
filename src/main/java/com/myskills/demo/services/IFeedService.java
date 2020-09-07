package com.myskills.demo.services;

import com.myskills.demo.models.Feed;
import com.myskills.demo.models.Comment;
import java.util.List;

public interface IFeedService {

  public List<Feed> getMyPosts(Long userId);

  public List<Feed> getFeeds(Long userId);

  public List<Feed> postFeed(Feed feed);

  public List<Comment> postComment(Comment comment);

  public void likeFeed(Long feedId);
}
