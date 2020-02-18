package com.hexaware.MLP197.integration.test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Objects;

// import javax.management.RuntimeErrorException;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.databind.ObjectWriter;
public class CommonUtil {
    public static final String host;
    public static final String port;
    public static final String webapp;
    public static final String uri_prefix;
    static {
        host = System.getProperty("service.host", "localhost");
        port = System.getProperty("service.port", "8080");
        webapp = System.getProperty("service.webapp", "MLP197");
        uri_prefix = "http://" + host + ":" + port + "/" + webapp;
    }
    public static URI getURI(String path) throws URISyntaxException {
        return new URI(uri_prefix + path);
    }
}

class Employee {
    /**
   * empId to store employee id. empFullName to store employee full name email to
   * store employee email empMobile to store employee mobile empDateOfJoining to
   * store employee date of joining empDesignation to store employee designation
   * empDepartment to store employee department empLeaveBalance to store employee
   * leave balance empManagerId to store employee's manager id
   */
  private int empId;
  private String empFullName;
  private String email;
  private Long empMobile;
  private String empDateOfJoining;
  private String empDesignation;
  private String empDepartment;
  private int empLeaveBalance;
  private int empManagerId;

  /**
   * No argument employee constructor.
   */
  public Employee() {
  }

  /**
   * @param argEmpId            to initialize employee id.
   * @param argEmpFullName      to initialize employee full name.
   * @param argEmail            to initialize employee email.
   * @param argEmpMobile        to initialize employee mobile number.
   * @param argEmpDateOfJoining to initialize employee date of joining.
   * @param argEmpDesignation   to initialize employee designation.
   * @param argEmpDepartment    to initialize employee department.
   * @param argEmpLeaveBalance  to initialize employee leave balance.
   * @param argEmpManagerId     to initialize employee manager id.
   */
  public Employee(final int argEmpId, final String argEmpFullName, final String argEmail, final Long argEmpMobile,
      final String argEmpDateOfJoining, final String argEmpDesignation, final String argEmpDepartment,
        final int argEmpLeaveBalance, final int argEmpManagerId) {
    this.empDepartment = argEmpDepartment;
    this.empLeaveBalance = argEmpLeaveBalance;
    this.empId = argEmpId;
    this.empFullName = argEmpFullName;
    this.email = argEmail;
    this.empMobile = argEmpMobile;
    this.empDateOfJoining = argEmpDateOfJoining;
    this.empDesignation = argEmpDesignation;
    this.empManagerId = argEmpManagerId;
  }

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Employee emp = (Employee) obj;
    if (Objects.equals(empId, emp.empId) && Objects.equals(empFullName, emp.empFullName)
        && Objects.equals(email, emp.email) && Objects.equals(empMobile, emp.empMobile)
        && Objects.equals(empDateOfJoining, emp.empDateOfJoining) && Objects.equals(empDesignation, emp.empDesignation)
        && Objects.equals(empDepartment, emp.empDepartment) && Objects.equals(empLeaveBalance, emp.empLeaveBalance)
        && Objects.equals(empManagerId, emp.empManagerId)) {
      return true;
    }
    return false;
  }

  @Override
   public final int hashCode() {
    return Objects.hash(empId, empFullName, empDepartment, email, empDesignation, empMobile,
    empDateOfJoining, empManagerId, empLeaveBalance);
  }
  /**
   * Gets the EmployeeId.
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   *
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }
  /**
   * @return the employee full name.
   */
  public final String getEmpFullName() {
    return empFullName;
  }

  /**
   * @param argEmpFullName to set employee full name
   */
  public final void setEmpFullName(final String argEmpFullName) {
    this.empFullName = argEmpFullName;
  }
  /**
   * @return the employee email
   */
  public final String getEmail() {
    return email;
  }
  /**
  * @param argEmail to set emp email
  */
  public final void setEmail(final String argEmail) {
    this.email = argEmail;
  }
  /**
  * @return the employee mobile number.
  */
  public final Long getEmpMobile() {
    return empMobile;
  }
  /**
  * @param argEmpMobile to set emp mobile
  */
  public final void setEmpMobile(final Long argEmpMobile) {
    this.empMobile = argEmpMobile;
  }

  /**
   * @return the employee's date of joining
   */
  public final String getEmpDateOfJoining() {
    return empDateOfJoining;
  }

  /**
   * @param argEmpDateOfJoining to set emp date of joining.
   */
  public final void setEmpDateOfJoining(final String argEmpDateOfJoining) {
    this.empDateOfJoining = argEmpDateOfJoining;
  }

  /**
   * @return the employee designation
   */
  public final String getEmpDesignation() {
    return empDesignation;
  }

  /**
   * @param argEmpDesignation to set emp designation
   */
  public final void setEmpDesignation(final String argEmpDesignation) {
    this.empDesignation = argEmpDesignation;
  }

  /**
   * returns the employee's department.
   * @return the employee department
   */
  public final String getEmpDepartment() {
    return empDepartment;
  }

  /**
   * to set the employee departments.
   * @param argEmpDepartment employee departments
   */
  public final void setEmpDepartment(final String argEmpDepartment) {
    this.empDepartment = argEmpDepartment;
  }

  /**
   * for getting employee's leave balance details.
   * @return the employee's leave balance
   */
  public final int getEmpLeaveBalance() {
    return empLeaveBalance;
  }
  /**
   * @param argEmpLeaveBalance to set emp leave balance
   */
  public final void setEmpLeaveBalance(final int argEmpLeaveBalance) {
    this.empLeaveBalance = argEmpLeaveBalance;
  }

  /**
   * for getting employee's manager id.
   * @return the get the employee manager id
   */
  public final int getEmpManagerID() {
    return empManagerId;
  }
  /**
   * @param empManagerID to set manager id
   */
  public final void setEmpManagerID(final int empManagerID) {
    this.empManagerId = empManagerID;
  }

  @Override
  public final String toString() {
    return "Employee [email=" + email + ", empDateOfJoining=" + empDateOfJoining + ", empDepartment=" + empDepartment
        + ", empDesignation=" + empDesignation + ", empFullName=" + empFullName + ", empId=" + empId
        + ", empLeaveBalance=" + empLeaveBalance + ", empManagerID=" + empManagerId + ", empMobile=" + empMobile + "]";
  }
}

class LeaveDetails {
  /**
   * leaveId to store leave id leaveStartDate store start date of the leave.
   * leaveEndDate store end date of the leave leaveType to store leaveType of the.
   * leave leaveReason to store the reason of the leave leaveStatus to store
   * status of the leave. leaveAppliedOn to store date on which the leave was
   * applied. leaveComment to store the comments given by the manager empId to
   * store the employee.
   */
  private int leaveId;
  private Date leaveStartDate;
  private Date leaveEndDate;
  private int leaveNoOfDays;
  private String leaveType;
  private String leaveReason;
  private String leaveStatus;
  private Date leaveAppliedOn;
  private String leaveComment;
  private int empId;

    /**
     * No argument constructor.
     */
  public LeaveDetails() {

  }

  /**
   * constructer to initialize values.
   * @param argLeaveId to initialize leaveId
   * @param argLeaveStartDate to initialize start date
   * @param argLeaveEndDate to initialize end date
   * @param argsLeaveNoOfDays to initialize no of days
   * @param argLeaveType to initialize leave type
   * @param argLeaveReason to initialize leave reason
   * @param argLeaveStatus to initialize leave status
   * @param argLeaveAppliedOn to initialize leave applied on
   * @param argLeaveComment to initialize leave comment
   * @param argEmpId to initialize empId
   */
  public LeaveDetails(final int argLeaveId, final Date argLeaveStartDate, final Date argLeaveEndDate,
          final int argsLeaveNoOfDays, final String argLeaveType, final String argLeaveReason,
          final String argLeaveStatus, final Date argLeaveAppliedOn, final String argLeaveComment,
          final int argEmpId) {
    this.leaveId = argLeaveId;
    Date startDate = new Date(argLeaveStartDate.getTime());
    this.leaveStartDate = startDate;
    Date endDate = new Date(argLeaveEndDate.getTime());
    this.leaveEndDate = endDate;
    this.leaveNoOfDays = argsLeaveNoOfDays;
    this.leaveType = argLeaveType;
    this.leaveReason = argLeaveReason;
    this.leaveStatus = argLeaveStatus;
    Date appliedOn = new Date(argLeaveAppliedOn.getTime());
    this.leaveAppliedOn = appliedOn;
    this.leaveComment = argLeaveComment;
    this.empId = argEmpId;
  }

  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final LeaveDetails emp = (LeaveDetails) obj;
    if (Objects.equals(leaveId, emp.leaveId) && Objects.equals(leaveStartDate, emp.leaveStartDate)
            && Objects.equals(leaveEndDate, emp.leaveEndDate)  && Objects.equals(leaveNoOfDays, emp.leaveNoOfDays)
            && Objects.equals(leaveType, emp.leaveType) && Objects.equals(leaveStatus, emp.leaveStatus)
            && Objects.equals(leaveReason, emp.leaveReason) && Objects.equals(empId, emp.empId)
            && Objects.equals(leaveComment, emp.leaveComment) && Objects.equals(leaveAppliedOn, emp.leaveAppliedOn)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(leaveId, leaveStartDate, leaveEndDate, leaveNoOfDays,
                        leaveType, leaveStatus, leaveReason, empId, leaveComment, leaveAppliedOn);
  }

  /**
   * getting leave id.
   * @return leaveId.
   */
  public final int getLeaveId() {
    return leaveId;
  }

  /**
   * setting the leave id.
   * @param argLeaveId to set the leaveId.
   */
  public final void setLeaveId(final int argLeaveId) {
    this.leaveId = argLeaveId;
  }

  /**
   * getting the leave start date.
   * @return leavestartDate.
   */
  public final Date getLeaveStartDate() {
    Date startDate = leaveStartDate;
    return startDate;
  }

  /**
   * setting the leaveStart date.
   * @param argLeaveStartDate to set the Leave start date.
   */
  public final void setLeaveStartDate(final Date argLeaveStartDate) {
    Date startDate = new Date(argLeaveStartDate.getTime());
    this.leaveStartDate = startDate;
  }

  /**
   * getting the leave end date.
   * @return leaveEnddate.
   */
  public final Date getLeaveEndDate() {
    Date endDate = leaveEndDate;
    return endDate;
  }

  /**
   * setting the end date.
   * @param argLeaveEndDate to set the leave end date.
   */
  public final void setLeaveEndDate(final Date argLeaveEndDate) {
    Date endDate = new Date(argLeaveEndDate.getTime());
    this.leaveEndDate = endDate;
  }
  /**
   * getting the noofdays.
   * @return leaveNoOfDays.
   */
  public final int getLeaveNoOfDays() {
    return leaveNoOfDays;
  }
  /**
   * setting the leave no of days.
   * @param argLeaveNoOfDays total no of leaves
   */
  public final void setLeaveNoOfDays(final int argLeaveNoOfDays) {
    this.leaveNoOfDays = argLeaveNoOfDays;
  }

    /**
     * getting the leave type.
     * @return leaveType.
     */
  public final String getLeaveType() {
    return leaveType;
  }

    /**
     * setting the leaveType.
     * @param argLeaveType to set the leave type.
     */
  public final void setLeaveType(final String argLeaveType) {
    this.leaveType = argLeaveType;
  }

    /**
     * getting the leave reason.
     * @return leaveReason.
     */
  public final String getLeaveReason() {
    return leaveReason;
  }

    /**
     * setting the leave reason.
     * @param argLeaveReason to set the leave reason.
     */
  public final void setLeaveReason(final String argLeaveReason) {
    this.leaveReason = argLeaveReason;
  }

    /**
     * getting leave status.
     * @return leaveStatus.
     */
  public final String getLeaveStatus() {
    return leaveStatus;
  }

    /**
     * setting the leave status.
     * @param argLeaveStatus to set the leave status.
     */
  public final void setLeaveStatus(final String argLeaveStatus) {
    this.leaveStatus = argLeaveStatus;
  }

    /**
     * getting the leave applied date.
     * @return leaveAppliedOn.
     */
  public final Date getLeaveAppliedOn() {
    Date appliedOn = leaveAppliedOn;
    return appliedOn;
  }

    /**
     * setting the Leave Applied date.
     * @param argLeaveAppliedOn to set the leave applied on.
     */
  public final void setLeaveAppliedOn(final Date argLeaveAppliedOn) {
    Date appliedOn = new Date(argLeaveAppliedOn.getTime());
    this.leaveAppliedOn = appliedOn;
  }

    /**
     * getting Leave comments from manager.
     * @return leaveComment.
     */
  public final String getLeaveComment() {
    return leaveComment;
  }

    /**
     * setting the Leave comment.
     * @param argLeaveComment to set the leave comment.
     */
  public final void setLeaveComment(final String argLeaveComment) {
    this.leaveComment = argLeaveComment;
  }

    /**
     * getting Employee id.
     * @return empId.
     */
  public final int getEmpId() {
    return empId;
  }

    /**
     * setting the employee Id.
     * @param argEmpId to set the employee id.
     */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }

  @Override
  public final String toString() {
    return "LeaveDetails [empId=" + empId + ", leaveAppliedOn=" + leaveAppliedOn + ", leaveComment=" + leaveComment
            + ", leaveEndDate=" + leaveEndDate + ", leaveId=" + leaveId + ", leaveReason=" + leaveReason
                + ", leaveStartDate=" + leaveStartDate + ", leaveStatus=" + leaveStatus + ", leaveType=" + leaveType
                + ", leaveNoOfDays=" + leaveNoOfDays + "]";
  }
}

class EmployeeReport {
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
