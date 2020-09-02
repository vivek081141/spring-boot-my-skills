package com.myskills.demo.services;

import com.myskills.demo.models.Comment;
import com.myskills.demo.models.Feed;
import java.util.List;

public interface IFeedService {

  public List<Feed> getMyPosts(Long userId);

  public List<Feed> getFeeds(Long userId);

  public void postFeed(Feed feed);

  public void postComment(Comment comment);

  public void likeFeed(Long feedId);
}
