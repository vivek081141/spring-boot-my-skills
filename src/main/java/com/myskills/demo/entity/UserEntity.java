package com.myskills.demo.entity;

import lombok.Data;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "USER_TBL")
public class UserEntity {

  @Id
  @GeneratedValue
  private Integer id;

  private String username;

  private String displayPicture;

  private Integer age;


  /** one to many relationship **/
  @OneToMany(mappedBy = "user")
  private List<FeedsEntity> feedsEntityList;
}
