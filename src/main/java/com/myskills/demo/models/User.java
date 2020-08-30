package com.myskills.demo.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Setter
@Getter
@ToString
public class User {
  private String userName;
  private String displayProfile;
  private List<Feed> feedList;
}
