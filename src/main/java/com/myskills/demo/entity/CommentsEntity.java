package com.myskills.demo.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "COMMENT_TBL")
public class CommentsEntity {

  @Id
  @GeneratedValue
  @Column(name = "ID")
  private Long id;

  @Column (name = "MESSAGE")
  private String message;

  @Column (name = "POSTED_DATE")
  private Date postedDate;

  /**
   * every comment will be posted by some user
   **/
  @OneToOne
  @JoinColumn(name = "COMMENTED_BY_ID")
  private UserEntity commentedBy;


  /**
   * many to one relationship
   **/
  @ManyToOne
  @JoinColumn (name = "FEEDS_ENTITY_ID")
  private FeedsEntity feedsEntity;

}
