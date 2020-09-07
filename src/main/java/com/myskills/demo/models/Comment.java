package com.myskills.demo.models;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Comment {
  @NotNull(message = "Feed id can not be empty")
  private Long feedId;

  @NotBlank(message = "Comment can not be empty")
  private String comment;

  @NotNull(message = "CommentBy can not be empty")
  private Long commentedBy;

  private String commentedOn;
  private String commentedByDP;

}
