package com.hexaware.MLP197.model;

// import java.text.SimpleDateFormat;
// import java.time.LocalDate;
import java.util.Date;
//import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;

import com.hexaware.MLP197.persistence.DbConnection;
import com.hexaware.MLP197.persistence.LeaveDetailsDAO;


/**
 * LeaveDetails.
 * @author MLP197
 */
public class LeaveDetails {
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
  public LeaveDetails()       {

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

    // private static LeaveDetailsDAO dao() {
    //     final DbConnection db = new DbConnection();
    //     return db.getConnect().onDemand(LeaveDetailsDAO.class);
    // }
  @Override
  public final String toString() {
    return "LeaveDetails [empId=" + empId + ", leaveAppliedOn=" + leaveAppliedOn + ", leaveComment=" + leaveComment
            + ", leaveEndDate=" + leaveEndDate + ", leaveId=" + leaveId + ", leaveReason=" + leaveReason
                + ", leaveStartDate=" + leaveStartDate + ", leaveStatus=" + leaveStatus + ", leaveType=" + leaveType
                + ", leaveNoOfDays=" + leaveNoOfDays + "]";
  }
    /**
     * @return LeaveDetailsDAO.
     */
  private static LeaveDetailsDAO dao() {
    final DbConnection db = new DbConnection();
    return db.getConnect().onDemand(LeaveDetailsDAO.class);
  }
    /**
     * @param empID to set empid.
     * @return empid.
     */
  public static LeaveDetails listById(final int empID) {
    return dao().find(empID);
  }
    /**
     * @param leaveId to set empid.
     * @return empid.
     */
  public static LeaveDetails listByLd(final int leaveId) {
    return dao().viewLeaveByLd(leaveId);
  }
    /**
     * @param leaveId to set leave id.
     * @return message.
     */
  public static String approveById(final int leaveId) {
    dao().approve(leaveId);
    return "Leave Approved";
  }
  /**
   * @param leaveId to set leaveid.
   * @param leaveComment to set leave comment.
   * @return message.
   */
  public static String denyById(final int leaveId, final String leaveComment) {
    dao().deny(leaveId, leaveComment);
    return "Leave Denied";
  }
  /**
  * @param leaveId to set leaveId.
  * @param empId to set empid.
  * @return message.
  */
  public static String reducingLeaveBalance(final int leaveId, final int empId) {
    dao().reduce(leaveId, empId);
    return "Leave Balance reduced";
  }
  /**
   * @param argsleaveEndDate .
   * @param argsleaveStartDate .
   * @return diffdays
   */
  public static long daysBetween(final Date argsleaveEndDate, final Date argsleaveStartDate) {
  //  }
    // SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    Date d1 = argsleaveStartDate;
    Date d2 = argsleaveEndDate;
    try {
      long diff = d2.getTime() - d1.getTime();
      long diffDays = diff / (24 * 60 * 60 * 1000);
      return diffDays;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return 0;
  }
     /**
     * @param argEmpId to set the arg emp id.
     * @param argLeaveStartDate to set the arg leave start date.
     * @param argLeaveEndDate to set the arg leave end date.
     * @param argLeaveNumberOfDays to set the leave number of days.
     * @param argLeaveType to set the arg leave type.
     * @param argLeaveReason to set the arg leave reason.
     * @return success message
     */
  public static String leaveApply(final int argEmpId, final Date argLeaveStartDate, final Date argLeaveEndDate,
      final int argLeaveNumberOfDays, final String argLeaveType,
      final String argLeaveReason) {
    if (argLeaveStartDate.compareTo(argLeaveEndDate) > 0) {
      System.out.println("Leave End Date should be greater than equal to Leave Start Date!");
      Runtime.getRuntime().halt(0);
    }
    if (argLeaveStartDate.compareTo(new Date()) < 0) { // starting date is less than todays date
      System.out.println("Leave Start Date should not be in past!");
      Runtime.getRuntime().halt(0);
    }
    long count = daysBetween(argLeaveEndDate, argLeaveStartDate);
    if (count != argLeaveNumberOfDays) {
      System.out.println("Leave number of days did not match your leave days");
      Runtime.getRuntime().halt(0);
    }
    dao().applyLeaveDAO(argEmpId, argLeaveStartDate, argLeaveEndDate, argLeaveNumberOfDays,
                        argLeaveType, argLeaveReason);
    return "LEAVE APPLIED SUCCESSFULLY";
  }
  //  * check leave number of days method.
  //  * @param leaveNoOfDays to get leave number of days.
  //  * @param leaveStartDate to get leave start date.
  //  * @param leaveEndDate to get leave end date.
  //  * @return result.
  //  */
  // public static int checkLeaveNoOfDays(final int leaveNoOfDays, final Date leaveStartDate, final Date leaveEndDate) {
  //   Long difference = leaveEndDate.getTime() - leaveStartDate.getTime();
  //   int leaveDays = (int) (difference / (1000L * 60 * 60 * 24));
  //   int noOfDays = leaveDays + 1;
  //   if (leaveNoOfDays != noOfDays) {
  //     System.out.println("Number of days doesn't match");
  //     return 4;
  //   }
  //   return 0;
  // }
  /**
   * @param argEmpId to set arg emp id.
   * @return empid.
   */
  public static List<LeaveDetails> leaveHistory(final int argEmpId) {
    return dao().getLeaveHistory(argEmpId);
  }
  /**
   * getting total leaves.
   * @param argEmpId empId
   * @return total leaves
   */
  public static int totalLeaves(final int argEmpId) {
    return dao().findTotalLeaves(argEmpId);
  }
  /**
   * viewing pending leave details under a manager.
   * @param mgrId manager id
   * @return pending leave list
   */
  public static List<LeaveDetails> viewPendingLeaves(final int mgrId) {
    return dao().pendingDetails(mgrId);
  }
  /**
   * retuns leave details of given id.
   * @param leaveId the leave id
   * @return the given leave details
   */
  public static LeaveDetails viewLeaveById(final int leaveId) {
    return dao().displayLeaveById(leaveId);
  }
}

