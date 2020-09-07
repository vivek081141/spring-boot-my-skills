package com.myskills.demo.models;

import lombok.Data;
import java.util.List;

@Data
public class Feed {

  private Long userId;
  private String postedDate;
  private String header;
  private String description;
  private List<Comment> commentList;
  private Integer commentsCount;
  private Integer likesCount;

  private User user;
  private Long id;

  public Integer getCommentsCount() {
    if (commentList != null && !commentList.isEmpty()){
      return commentList.size();
    }
    return 0;
  }

}
