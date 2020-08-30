package com.myskills.demo.entity;

import lombok.Data;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "USER_TBL")
public class UserEntity {

  @Id
  @GeneratedValue
  private Integer id;

  private List<FeedsEntity> feedsEntityList;
}
