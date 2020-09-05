package com.myskills.demo.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "RELATIONSHIP_TBL")
public class RelationshipEntity {
  @Id
  @GeneratedValue
  @Column(name = "ID")
  private Long id;

  @Column(name = "USER_0", nullable = false)
  private Long user0;

  @Column(name = "USER_1", nullable = false)
  private Long user1;

}
