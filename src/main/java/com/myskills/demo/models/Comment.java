package com.myskills.demo.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Comment {
  private String comment;
  private String commentedBy;
  private String commentedOn;
  private String commentedByDP;

 }
