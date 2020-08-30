package com.myskills.demo.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "COMMENT_TBL")
public class CommentsEntity {

  @Id
  @GeneratedValue
  private Integer id;

  /** every comment will be associated with a feed **/
  private FeedsEntity feedsEntity;

}
