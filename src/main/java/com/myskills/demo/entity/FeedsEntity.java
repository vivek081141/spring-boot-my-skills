package com.myskills.demo.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "FEED_TBL")
public class FeedsEntity {

  @Id
  @GeneratedValue
  private Integer id;

  /** ever feed/post will be done by a user **/
  private UserEntity user;


}
