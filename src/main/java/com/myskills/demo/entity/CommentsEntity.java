package com.myskills.demo.entity;

import lombok.Data;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "COMMENT_TBL")
public class CommentsEntity {

  @Id
  @GeneratedValue
  private Integer id;

  private String message;

  private Date postedDate;

  /**every comment will be posted by some user **/
  @OneToOne
  private UserEntity commentedBy;


  /** many to one relationship **/
  @ManyToOne
  private FeedsEntity feedsEntity;

}
