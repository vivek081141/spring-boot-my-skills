package com.myskills.demo.models;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class Feed {

  @NotBlank(message = "User id can not be empty")
  private Long userId;
  private String postedDate;
  private String header;
  @NotBlank(message = "feed cannot be empty")
  private String description;
  private List<Comment> commentList;
  private Integer commentsCount;
  private Integer likesCount;

  public Integer getCommentsCount() {
    if (commentList != null && !commentList.isEmpty()){
      return commentList.size();
    }
    return 0;
  }

}
