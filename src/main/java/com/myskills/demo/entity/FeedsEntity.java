package com.myskills.demo.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Getter
@Setter
@Entity
@Table(name = "FEED_TBL")
public class FeedsEntity {

  @Id
  @GeneratedValue
  @Column (name = "ID")
  private Long id;

  @Column(name = "FEED_DETAIL")
  private String feedDetail;

  @Column (name = "POSTED_ON")
  private Date postedOn;

  @Column (name = "LIKES")
  private Integer likes;

  /**
   * many to one relationship
   **/
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "USER_ID")
  private UserEntity userEntity;

  /**
   * one to many relationship
   **/
  @OneToMany(mappedBy = "feedsEntity")
  private List<CommentsEntity> commentsList;


}
