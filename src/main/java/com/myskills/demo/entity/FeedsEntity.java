package com.myskills.demo.entity;

import lombok.Data;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "FEED_TBL")
public class FeedsEntity {

  @Id
  @GeneratedValue
  private Integer id;

  private String feedDetail;

  private Date postedOn;

  private Number likes;

  /** many to one relationship **/
  @ManyToOne
  private UserEntity user;

  /** one to many relationship **/
  @OneToMany(mappedBy = "feedsEntity")
  private List<CommentsEntity> commentsList;


}
