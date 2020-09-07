package com.myskills.demo.models;

import lombok.Data;
import java.util.List;

@Data
public class User {
  private Long id;
  private String userName;
  private String displayProfile;
  private List<Feed> feedList;
}
