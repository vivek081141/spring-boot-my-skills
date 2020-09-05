package com.myskills.demo.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Getter
@Setter
@Entity
@Table(name = "USER_TBL")
public class UserEntity {

  @Id
  @GeneratedValue
  @Column (name = "ID")
  private Long id;

  @Column (name = "USERNAME")
  private String username;

  @Column (name = "DISPLAY_PICTURE")
  private String displayPicture;

  @Column (name = "AGE")
  private Long age;

  /**
   * one to many relationship
   **/
  @OneToMany(mappedBy = "userEntity",
          cascade = CascadeType.ALL,
          orphanRemoval = true,
          fetch = FetchType.LAZY)
  private List<FeedsEntity> feedsEntityList = new ArrayList<>();




  public void addComment(FeedsEntity feedsEntity) {
    feedsEntityList.add(feedsEntity);
    feedsEntity.setUserEntity(this);
  }

  public void removeComment(FeedsEntity feedsEntity) {
    feedsEntityList.remove(feedsEntity);
    feedsEntity.setUserEntity(null);
  }
}
