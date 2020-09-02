package com.myskills.demo.controller;

import com.myskills.demo.models.Comment;
import com.myskills.demo.models.Feed;
import com.myskills.demo.services.IFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "/feeds")
public class FeedController {

  @Autowired
  private IFeedService feedService;

  /**
   * Get the posts posted by user
   **/
  @GetMapping
  @RequestMapping(value = "/getMyPost/{userId}", method = RequestMethod.GET)
  public List<Feed> getMyPosts(@PathVariable(name = "userId", required = true) Long userId) {
    return feedService.getMyPosts(userId);
  }

  @GetMapping
  @RequestMapping(value = "/getFeeds/{userName}", method = RequestMethod.GET)
  public List<Feed> getFeeds(@PathVariable(name = "userName", required = true) Long userId) {
    return feedService.getFeeds(userId);
  }

  @RequestMapping(value = "/postFeed", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public void postFeed(@RequestBody @Validated Feed feed) {
    feedService.postFeed(feed);
  }

  @RequestMapping(value = "/postComment", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public void postComment(Comment comment) {
    feedService.postComment(comment);
  }

  @RequestMapping(value = "/like", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public void likeAFeed() {

  }

}


