package com.myskills.demo.controller;

import com.myskills.demo.models.Feed;
import com.myskills.demo.models.Comment;
import com.myskills.demo.models.Like;
import com.myskills.demo.services.IFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "/feeds")
//@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
public class FeedController {

  @Autowired
  private IFeedService feedService;

  /**
   * Get the posts posted by user
   **/
  @RequestMapping(value = "/getMyPost/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public List<Feed> getMyPosts(@PathVariable(name = "userId", required = true) Long userId) {
    return feedService.getMyPosts(userId);
  }

  /** get all the feeds **/
  @RequestMapping(value = "/getFeeds/{userId}", method = RequestMethod.GET)
  @ResponseBody
  public List<Feed> getFeeds(@PathVariable(name = "userId", required = true) Long userId) {
    return feedService.getFeeds(userId);
  }

  @RequestMapping(value = "/postFeed", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity postFeed(@RequestBody @Validated Feed feed) {
    List<Feed> feedList = feedService.postFeed(feed);
    return ResponseEntity.ok().body(feedList);
  }

  @RequestMapping(value = "/postComment", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity postComment(@RequestBody @Validated Comment comment) {
    List<Comment> commentList = feedService.postComment(comment);
    return ResponseEntity.ok().body(commentList);
  }

  @RequestMapping(value = "/like", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity like(@RequestBody Like like) {
    feedService.likeFeed(Long.valueOf(like.getFeedId()));
    //ResponseEntity.accepted().headers(headers).body(c);
    return ResponseEntity.ok().build();
  }

}


