package com.myskills.demo.controller;

import com.myskills.demo.models.Feed;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "/feeds")
public class FeedController {

  @GetMapping
  @RequestMapping(value = "/getMyPost/{userName}", method = RequestMethod.GET)
  public List<Feed> getMyPosts(@PathVariable(name="userName", required=true) String userName) {
    return null;
  }

  @GetMapping
  @RequestMapping(value = "/getMyFeeds/{userName}", method = RequestMethod.GET)
  public List<Feed> getMyFeeds(@PathVariable(name="userName", required=true) String userName){
    return null;
  }

  @RequestMapping(value = "/postFeed", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public void postFeed(){

  }

  @RequestMapping(value = "/postComment", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public void postComment() {

  }

  @RequestMapping(value = "/like", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public void likeAFeed() {

  }

}


