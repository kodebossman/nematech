package com.nematech.umsebenzi.enums;

public enum ApplicationStatus {
  PENDING(1),
  ASSESSED(2),
  SUCCESS(3),
  FAILED(4);

  private final int applicationStatusId;
  ApplicationStatus(int applicationStatusId) {
    this.applicationStatusId = applicationStatusId;
  }

  public int getJobTypeId() {
    return applicationStatusId;
  }

}
