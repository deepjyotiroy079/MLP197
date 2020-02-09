package com.hexaware.MLP197.model;

import java.util.Objects;

/**
 * EmployeeReport class to store employee report.
 * @author hexware
 */
public class EmployeeReport {
  /**
   * department to store dept.
   * count to store count of ever dept
   */
  private String department;
  private int count;
  /**
   * default constructor.
   */
  public EmployeeReport() {
  }
  /**
   * constructor to initialize the values.
   * @param argDepartment the department name
   * @param argCount the employee count
   */
  public EmployeeReport(final String argDepartment, final int argCount) {
    this.department = argDepartment;
    this.count = argCount;
  }
  /**
   * getting the department.
   * @return the department name
   */
  public final String getDepartment() {
    return department;
  }
  /**
   * initializing the department.
   * @param argDepartment the department name
   */
  public final void setDepartment(final String argDepartment) {
    this.department = argDepartment;
  }
  /**
   * return the count.
   * @return the count
   */
  public final int getCount() {
    return count;
  }

  /**
   * initializing the count value.
   * @param argCount the count value
   */
  public final void setCount(final int argCount) {
    this.count = argCount;
  }

  @Override
  public final String toString() {
    return "EmployeeReport [count=" + count + ", department=" + department + "]";
  }

  @Override
  public final int hashCode() {
    return Objects.hash(department, count);
  }
  @Override
  public final boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final EmployeeReport other = (EmployeeReport) obj;
    if (count != other.count) {
      return false;
    }
    if (department == null) {
      if (other.department != null) {
        return false;
      }
    } else if (!department.equals(other.department)) {
      return false;
    }
    return true;
  }
}
