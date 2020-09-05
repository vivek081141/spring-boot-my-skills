package com.myskills.demo.models;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class Comment {
  @NotBlank(message = "Feed id can not be empty")
  private Long feedId;

  @NotBlank(message = "Comment can not be empty")
  private String comment;

  @NotBlank(message = "CommentBy can not be empty")
  private Long commentedBy;

  private String commentedOn;
  private String commentedByDP;

}
