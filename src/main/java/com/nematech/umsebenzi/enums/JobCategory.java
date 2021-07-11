package com.nematech.umsebenzi.enums;

public enum JobCategory {

  IT(1),
  COMMERCE(2),
  MEDICAL(3),
  ENGINEERING(4),
  PROJECT_MANAGEMENT(5),
  CONSTRUCTION(6);

  private final int jobCategoryId;
  JobCategory(int jobCategoryId) {
    this.jobCategoryId = jobCategoryId;
  }

  public int getJobCategoryId() {
    return jobCategoryId;
  }
}
