package com.myskills.demo.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter
@Setter
@ToString
public class Feed {
  private User user;
  private String postedDate;
  private String header;
  private String shortDescription;
  private List<Comment> commentList;
  private Integer commentsCount;
  private Integer likesCount;

  public Integer getCommentsCount() {
    return commentList.size();
  }

}
