package com.nematech.umsebenzi.enums;

public enum Education {

  DEGREE(1),
  DIPLOMA(2),
  CERTIFICATE(7),
  MASTERS(3),
  DR(4),
  ENG(5),
  OTHERS(6);

  private final int educationLevelId;
  Education(int educationLevelId) {
    this.educationLevelId = educationLevelId;
  }

  public int getJobCategoryId() {
    return educationLevelId;
  }
}
