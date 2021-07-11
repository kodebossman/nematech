package com.nematech.umsebenzi.enums;

public enum JobType {

  ARTISAN(1),
  FREELANCE(2),
  PERMANENT(3),
  CONTRACT(4);

  private final int jobTypeId;
  JobType(int jobTypeId) {
    this.jobTypeId = jobTypeId;
  }

  public int getJobTypeId() {
    return jobTypeId;
  }

}
